import java.text.ParseException;
import java.util.Scanner;


public class App {
    
    static Scanner sc = new Scanner(System.in);
    static listEmployees myList = new listEmployees();
    public static void main(String[] args) throws Exception {
        System.out.println("----------APP Employee Manege----------");
        int choice ; 
        mainMenu menu = new mainMenu();
        menu.InitMenu();
        while ( true ) {
            while(true) {
                menu.displayListMenu();
                System.out.println("---------------------------------------");
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if ( choice > 6 || choice <= 0 ) {
                        System.out.println("Your choice not exist! . Enter again");
                        continue ; 
                    }
                    else break ; 
                    
                } catch (Exception e) {
                    System.out.println("Your choice not exist! . Enter again");
                }
            }
            solve(choice);
            System.out.println();
            System.out.print("Do you want to continue? (y/n): ");
            char c = sc.nextLine().charAt(0);
            if ( c == 'y' || c == 'Y') continue ; 
            else 
            {
                System.out.println("Goodbye!");
                break ;
            } 
        }
    }

    public static void solve(int choice) throws ParseException {
        switch (choice) {
            case 1:
                System.out.println("-------------ADD EMPLOYEE--------------");
                myList.addEmployees();
                break;
            case 2:
                System.out.println("---------UPDATE EMPLOYEE BY ID---------");
                myList.updateEmployees();
                break;
            case 3:
                System.out.println("---------REMOVE EMPLOYEE BY ID---------");
                myList.removeEmployees();
                break;
            case 4:
                System.out.println("------------SEARCH EMPLOYEE------------");
                myList.searchEmployees();
                break;
            case 5: 
                System.out.println("--------SORT EMPLOYEES BY SALARY-------");
                myList.sortEmployeesBySalary();
                break; 
            case 6: 
                System.out.println("----------------Exit-------------------");
                myList.Exit();
                System.exit(0);
                break ; 
            case 7: 
                myList.show();
            default:
                break;
        }
    }


}
