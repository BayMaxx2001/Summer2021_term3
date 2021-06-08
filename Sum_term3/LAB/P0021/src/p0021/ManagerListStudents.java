package p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManagerListStudents{
    static ArrayList<Student> list = new ArrayList<>();
    public static boolean checkLengh(ArrayList<Student> list){
        if ( list.size() >= 10 ) 
        {
            System.out.println("----Do you want to continue (Y/N): ");
            if (Validation.checkInputYESNO()==false){
                return false;
            }
        }
        return true;
    }
    public static void createStudent(){
        if ( checkLengh(list) == false ) 
            return ; 

        while (true) {
            System.out.print("Enter id: ");
            //input ID && Standardize ID
            String id = Validation.checkInputString();
            id = Validation.standardizedID(id);

            // //check Dublicate
            // if (Validation.checkIdExist(list, id)==false) {
            //     System.err.println("Id has exist student. Enter again: ");
            //     continue;
            // }
            //input Name && Standardize Name
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            name = Validation.standardizedName(name);
            
            //input semester && Standardize semester
            System.out.print("Enter semester: ");
            int semester = Validation.checkInputIntLimit(1,21);

            //input course && Standardize course
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            course  = Validation.standardizedName(course);


            //check student exist or not
            list.add(new Student(id, name, semester, course));
            System.out.println("Add student success.");

            if ( checkLengh(list) == true ) continue;
            else 
                return;
        }
    }
    public static void displayListStudent(){
        for(Student student: list) {
            student.displayAll();
        }
    }
    public static void findAndSort() {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ArrayList<Student> listStudentFindByName = listStudentFindByName(list);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } 
        else {
            Collections.sort(listStudentFindByName);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "Semester", "Course Name");
            
            for (Student student : listStudentFindByName) {
                student.displayAll();
            }
        }
    }
    public static ArrayList<Student> listStudentFindByName(ArrayList<Student> list) {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();

        System.out.print("--Enter name to search: ");
        Scanner sc = new Scanner(System.in);
        String nameSearch = sc.nextLine();
        if ( nameSearch == null )
        {
            for (Student student : list) {
                listStudentFindByName.add(student);
            }
            return listStudentFindByName;
        }
        
        nameSearch = nameSearch.toLowerCase();
        for (Student student : list) 
        {
            //check student have name contains input
            String nameInList = student.getStudentName().toLowerCase();

            if (nameInList.contains(nameSearch)) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
    public static void UpdateOrDelete(){
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // input id to find
        System.out.println("Enter id: ");
        String id = Validation.checkInputString();
        id = Validation.standardizedID(id);
        //ListStudent had found - size = 0 | size = 1
        ArrayList<Student> listStudentByID = ListStudentById(list, id);

        //check empty
        if ( listStudentByID.isEmpty() ) {
            System.err.println("Not found student!");
            return;
        }

        //display student found
        Student student = listStudentByID.get(0);
        System.out.printf("%-10s%-15s%-15s%-15s\n", "IdNumber", "Student name","semester", "Course Name");
        student.displayAll();

        //Implement delete or update
        System.out.print("Do you want to update (U) or delete (D) student: ");

        //Update
        if (Validation.checkInputUD()) 
        {
            //update ID
            String idStudent = student.getId();
            while (true){
                String idUpdate = Validation.checkInputString();
                idUpdate = Validation.standardizedID(idUpdate);
                //check Dublicate
                if (idUpdate == idStudent) 
                    break;
                else if (Validation.checkIdExist(list, id)==false) {
                    System.err.println("Id has exist student. Enter again: ");
                    continue;
                }
                else 
                    break;
            }
            //Update information
            //input & stadardize
            //name
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            name = Validation.standardizedName(name);

            //semester
            System.out.print("Enter semester: ");
            int semester = Validation.checkInputIntLimit(1,21);

            //course
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            course = Validation.standardizedName(course);

            //check student exist or not
            if (Validation.checkStudentExist(list, id, name, semester, course)==true) {
                student.setStudentName(name);
                student.setSemester(semester);
                student.setCourseName(course);
                System.err.println("Update success.");
                return;
            }
        }
        //Delete
        else {
            list.remove(student);
            System.out.println("Delete success");
            return;
        }
    }
    //find ListStudent by ID 
    public static ArrayList<Student> ListStudentById(ArrayList<Student> list, String id){
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
                break;
            }
        }
        return getListStudentById;
    }

    //report
    public static void report(){
        if ( list.isEmpty() ) {
            System.err.println("List is empty.");
            return;
        }
        ArrayList<Report> report = new ArrayList<>();
        // loop report to add
        //System.out.println(size);
        for ( int i=0; i<list.size(); i++)
        {
            int total = 0; 
            for(int j=0;j<list.size();j++)
            {
                if(list.get(i).getId().equals(list.get(j).getId()))
                {
                    total ++;
                }
            }
            //System.out.println(total+"--");
            if (Validation.checkReportExist(report, list.get(i).getStudentName(), list.get(i).getCourseName())){
                report.add(new Report(list.get(i).getStudentName(), list.get(i).getCourseName(),total));
            } 
        }
        //print report
        for (int i = 0; i < report.size(); i++) 
        {
            report.get(i).displayReport();
        }
    }

    //exit
    public static void exit(){
        System.out.println("Good Bye!");
    }

}