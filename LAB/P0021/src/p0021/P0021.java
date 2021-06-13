
package p0021;

import java.util.ArrayList;
import java.util.Scanner;

public class P0021 {


    public static void main(String[] args) {
        //Init static instance
        Menu menu = new Menu();
        Validation validation = new Validation();
        ManagerListStudents listStudent = new ManagerListStudents();

        //Init input
        listStudent.add(new Student("1", "Vu Tri Hien", 1, "Java"));
        listStudent.add(new Student("1", "Vu Tri Hien", 1, "C/c++"));
        listStudent.add(new Student("2", "Donal Trump",1, ".Net"));
        listStudent.add(new Student("3", "Ronaldo", 1, "C/C++"));
        listStudent.add(new Student("3", "Ronaldo", 2, ".net"));
        listStudent.add(new Student("3", "Ronaldo", 4, "C/C++"));
        listStudent.add(new Student("4", "Adam Jame ", 1, "C/C++"));
        listStudent.add(new Student("5", "Son Tung", 1, "Java"));
        listStudent.add(new Student("6", "Hoai Linh",1, "C/C++"));
        listStudent.add(new Student("8", "Hoai Linh",1, "C/C++"));
        //call menu
        menu.InitMenu();
        //input & solve
        while (true){
            menu.displayListMenu();
            System.out.print(" Enter your choice: ");
            //input choice
            int choice; 
            choice = validation.checkInputIntLimit(1, 5);

            //solve each choice
            switch(choice){
                case 1:
                    listStudent.createStudent();
                    break;
                case 2:
                    listStudent.findAndSort();
                    break;
                case 3:
                    listStudent.UpdateOrDelete();
                    break;
                case 4:
                    listStudent.report();
                    break;
                case 5:
                    listStudent.displayListStudent();
                    return;
            }
        }
    }
    
}
