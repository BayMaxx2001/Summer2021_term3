package p0021;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static int checkInputIntLimit(int min, int max){
        while(true)
        {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if ( choice < min || choice > max ) {
                    throw new NumberFormatException();
                }
                else 
                    return choice; 
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.println("Enter again");    
            }
        }
    }

    public static String checkInputString() {
        while ( true ) {
            String input = sc.nextLine();
            input = input.trim();
            input = input.replaceAll("\\s+", " ");
            if ( input.isEmpty()){
                System.err.println("Input must not empty");
                System.out.print("Enter again: ");
            }
            else 
                return input;
        }
    }
    public static String standardizedName(String input) {
        input = input.toLowerCase();
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                input += " ";
            System.err.println(temp[i]);
        }
        return input;
    }
    public static String standardizedID(String input){
        input = input.trim();
        input = input.toUpperCase();
        input = input.replaceAll("\\s+", "");
        return input; 
    }
    public static boolean checkInputYESNO() {
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputCourse() {
        while ( true ) 
        {
            String input = checkInputString();
            if (input.equalsIgnoreCase("java")
                    || input.equalsIgnoreCase(".net")
                    || input.equalsIgnoreCase("c/c++")) {
                return input;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    public static boolean checkIdExist(ArrayList<Student> list, String idStudent) {
        for(Student student: list){
            if ( student.getId().equalsIgnoreCase(idStudent)) {
                return false;
            }
        }
        return true;
    }

    //check id and exist
    public static boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && !name.equalsIgnoreCase(student.getStudentName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
        String studentName, int semester, String courseName) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester == student.getSemester() 
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReportExist(ArrayList<Report> lr, String id, String course) {
        for (Report report : lr) {
            if (id.equalsIgnoreCase(report.getId()) && 
            course.equalsIgnoreCase(report.getCourseName())) {
                return false;
            }
        }
        return true;
    }
        //check report exist
    public static boolean checkReportExist(ArrayList<Report> lr, String name, String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
