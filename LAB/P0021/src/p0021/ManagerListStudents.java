package p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManagerListStudents{
    ArrayList<Student> list = new ArrayList<>();
    //init
    public void add(Student st){
        list.add(st);
    }

    public  boolean checkLengh(ArrayList<Student> list){
        if ( list.size() >= 10 ) 
        {
            System.out.println("----Do you want to continue (Y/N): ");
            if (Validation.checkInputYESNO()==false){
                return false;
            }
        }
        return true;
    }
    //create
    public  void createStudent(){
        if ( checkLengh(list) == false ) 
            return ; 

        while (true) {
            System.out.print("Enter id: ");
            //input ID && Standardize ID
            String id = Validation.checkInputString();
            id = Validation.standardizedID(id);

            //input Name && Standardize Name
            System.out.print("Enter name student: ");
            String name = Validation.checkInputString();
            name = Validation.standardizedName(name);
            
            if (!Validation.checkIdExist(list, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
            }
            //input semester && Standardize semester
            System.out.print("Enter semester: ");
            int semester = Validation.checkInputIntLimit(1,21);

            //input course && Standardize course
            System.out.print("Enter name course: ");
            String course = Validation.checkInputCourse();
            course  = Validation.standardizedName(course);

            //check student exist or not
            if (Validation.checkStudentExist(list, id, name, semester, course)) {
                list.add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                return;
            }
            System.err.println("Duplicate.");
        }
    }
    public  void displayListStudent(){
        for(Student student: list) {
            student.displayAll();
        }
    }
    public  void findAndSort() {
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
            System.out.printf("%-10s%-15s%-15s%-15s\n", "idName" , "Student name", "Semester", "Course Name");
            
            for (Student student : listStudentFindByName) {
                student.displayAll();
            }
        }
    }
    public  ArrayList<Student> listStudentFindByName(ArrayList<Student> list) {
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
        nameSearch = nameSearch.trim();
        nameSearch = nameSearch.replaceAll("\\s+", " ");
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
    public  void UpdateOrDelete(){
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        // input id to find
        System.out.println("Enter id: ");
        String id = Validation.checkInputString();
        id = Validation.standardizedID(id);
        ArrayList<Student> listStudentByID = ListStudentById(list, id);
        //check empty
        if ( listStudentByID.isEmpty() ) {
            System.err.println("Not found student!");
            return;
        }

        //display student found
        Student student = getStudentByListFound(listStudentByID);

        //Implement delete or update
        System.out.print("Do you want to update (U) or delete (D) student: ");

        //Update
        if (Validation.checkInputUD()) 
        {
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

    //Get student user want to update/delete in list found
    public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter choice student want to update/delete: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    //find ListStudent by ID 
    public  ArrayList<Student> ListStudentById(ArrayList<Student> list, String id){
        int count=0;
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
                count ++ ;
            }
        }
        System.out.println("Number of Students: " + count);
        return getListStudentById;
    }

    //report
    public  void report(){
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
                if(list.get(i).getId().equals(list.get(j).getId()) && list.get(i).getCourseName().equals(list.get(j).getCourseName()))
                {
                    total ++;
                }
            }
            //System.out.println(total+"--");
            if (Validation.checkReportExist(report, list.get(i).getId(), list.get(i).getCourseName()))
            {
                report.add(new Report(list.get(i).getId(), list.get(i).getStudentName(), list.get(i).getCourseName(),total));
            } 
        }
        //print report
        System.out.printf("%-10s%-15s%-15s%-15s\n", "idName" , "Student name", "Semester", "Course Name");
        for (int i = 0; i < report.size(); i++) 
        {
            report.get(i).displayReport();
        }
    }

    //exit
    public  void exit(){
        System.out.println("Good Bye!");
    }

}