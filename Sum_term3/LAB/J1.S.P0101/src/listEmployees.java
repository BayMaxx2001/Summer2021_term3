import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class sortBySalary implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return (int) (a.getSalary() - b.getSalary());
    }
}

public class listEmployees {

    ArrayList<Employee> listEmployees = new ArrayList<Employee>();
    Scanner sc = new Scanner(System.in);

    // ADD
    public void addEmployees() throws ParseException {

        // ID
        String str;
        validate chx;
        Employee newEmployee = new Employee();
        System.out.print("Enter ID Employee: ");
        while (true) {
            str = sc.nextLine();
            chx = new validate();
            str = chx.standardized_id(str);
            if (chx.checkDuplicate(listEmployees, str) == true)
                break;
            else {
                System.out.println("ID has exist!. Enter again!");
                continue;
            }
        }
        newEmployee.setIdEmployee(str);

        // First Name
        System.out.print("Enter first Name: ");
        str = sc.nextLine();
        chx = new validate();
        str = chx.standardized_Name(str);
        newEmployee.setFirstName(str);

        // Last Name
        System.out.print("Enter last Name: ");
        str = sc.nextLine();
        chx = new validate();
        str = chx.standardized_Name(str);
        newEmployee.setLastName(str);

        // Phone
        while (true) {
            System.out.print("Enter phone number: ");
            str = sc.nextLine();
            chx = new validate();
            if (chx.checkPhone(str) == true) {
                newEmployee.setPhone(str);
                break;
            } else {
                System.out.println("Phone does not illegal! Enter again!");
            }
        }

        // Mail
        while (true) {
            System.out.print("Enter Mail: ");
            str = sc.nextLine();
            chx = new validate();
            if (chx.checkEmail(str) == true) {
                newEmployee.setEmail(str);
                break;
            } else {
                System.out.println("Mail does not illegal! Enter again!");
            }
        }

        // Address
        System.out.print("Enter address: ");
        newEmployee.setAddress(sc.nextLine());

        // DOB
        while (true) {
            try {
                System.out.print("Enter date of birth: ");
                String dateFormat = "dd/MM/yyyy";
                newEmployee.setDate(new SimpleDateFormat(dateFormat).parse(sc.nextLine()));
                if (newEmployee.getDateOfBird() != null)
                    break;
            } catch (Exception e) {
                System.out.println("Date of birth does not illegal! Enter again!");
            }
        }

        // SEX
        System.out.print("Enter sex: ");
        str = sc.nextLine();
        chx = new validate();
        str = chx.checkSex(str);
        newEmployee.setSex(str);

        // Salary
        while (true) {
            try {
                System.out.print("Enter salary: ");
                Double x = Double.parseDouble(sc.nextLine());
                if (x < 0) {
                    System.out.println("Salary does not illegal! Enter again!");
                    continue;
                } else {
                    newEmployee.setSalary(x);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Salary does not illegal! Enter again!");
            }
        }

        // Egency
        System.out.print("Enter Egency: ");
        str = sc.nextLine();
        chx = new validate();
        str = chx.standardized_Name(str);
        newEmployee.setEgency(str);

        listEmployees.add(newEmployee);
        System.out.println("-----------Updater successful-----------");
    }

    // -------------------------------------UPDATE---------------------------------------
    public void updateEmployees() throws ParseException {

        String idEmp = new String();
        validate chx = new validate();

        if (listEmployees.size() == 0) {
            System.out.print("List Employee is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }

        System.out.print("Enter ID of employee need to update: ");

        idEmp = sc.nextLine();
        chx = new validate();
        idEmp = chx.standardized_id(idEmp);
        System.out.println(idEmp);
        // find idEmployee in listEmployees
        int pos = -1;// position of idEmployee in listEmployees
        Employee newEmployee = new Employee();
        for (int i = 0; i < listEmployees.size(); i++) 
        {
            Employee e1 = listEmployees.get(i);
            if (e1.getIdEmployee().equals(idEmp) == true) 
            {
                pos = i;
                newEmployee = e1;
                break;
            }
        }
        if (pos == -1) {
            System.out.print("ID of employee not found!");
            return;
        }
        System.out.println("-------Choose update information--------");
        System.out.println("---ENTER NUMBER 0 TO CLOSE OF CHOICES---");
        dumbEmployeeById(pos);
        listEmployees.remove(pos);
        ArrayList<Integer> lstUpdate = new ArrayList<Integer>();
        System.out.print("Choose update information(0-10): ");
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice > 10 || choice < 0) {
                    System.out.println("Choice not exist!");
                    continue;
                }
                if (choice == 0)
                    break;
                lstUpdate.add(choice);
            } catch (Exception e) {
                System.out.println("Choice not exist!");
            }

        }

        for (Integer integer : lstUpdate) {
            String str;
            switch (integer) {

                // Update Id;
                case 1:
                    while (true) {
                        System.out.print("Update ID of employee: ");
                        str = sc.nextLine();
                        chx = new validate();
                        str = chx.standardized_id(str);
                        if (chx.checkDuplicate(listEmployees, str) == true)
                            break;
                        else {
                            System.out.println("ID has exist! . Enter again!");
                            continue;
                        }
                    }
                    newEmployee.setIdEmployee(str);
                    break;

                // Update First Name
                case 2:
                    System.out.print("Update first name of employee:");
                    str = sc.nextLine();
                    chx = new validate();
                    str = chx.standardized_Name(str);
                    newEmployee.setFirstName(str);
                    break;

                // Update Last Name
                case 3:
                    System.out.print("Update last name of employee:");
                    str = sc.nextLine();
                    chx = new validate();
                    str = chx.standardized_Name(str);
                    newEmployee.setLastName(str);
                    break;

                // Update Phone
                case 4:
                    while (true) {
                        System.out.print("Update phone number of employee:");
                        str = sc.nextLine();
                        chx = new validate();
                        if (chx.checkPhone(str) == true) {
                            newEmployee.setPhone(str);
                            break;
                        }
                    }

                    break;

                // Update Mail
                case 5:
                    while (true) {
                        System.out.print("Update Mail of employee:");
                        str = sc.nextLine();
                        chx = new validate();
                        if (chx.checkEmail(str) == true) {
                            newEmployee.setEmail(str);
                            break;
                        } else {
                            System.out.println("Mail does not illegal! Enter again!");
                        }
                    }
                    break;

                // Update address
                case 6:
                    System.out.print("Update address of employee:");
                    newEmployee.setAddress(sc.nextLine());
                    break;

                // Update DOT
                case 7:
                    while (true) {
                        try {
                            System.out.print("Update date of birth of employee: ");
                            String dateFormat = "dd/MM/yyyy";
                            newEmployee.setDate(new SimpleDateFormat(dateFormat).parse(sc.nextLine()));
                            if (newEmployee.getDateOfBird() != null)
                                break;
                        } catch (Exception e) {
                            System.out.println("Date of birth does not illegal! Enter again!");
                        }
                    }
                    break;

                // Update SEX
                case 8:
                    System.out.print("Update sex of employee: ");
                    str = sc.nextLine();
                    chx = new validate();
                    str = chx.checkSex(str);
                    newEmployee.setSex(str);
                    break;

                // Update Salary
                case 9:
                    while (true) {
                        try {
                            System.out.print("Update salary of employee: ");
                            Double x = Double.parseDouble(sc.nextLine());
                            if (x < 0) {
                                System.out.println("Salary does not illegal! Enter again!");
                                continue;
                            } else {
                                newEmployee.setSalary(x);
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Salary does not illegal! Enter again!");
                        }

                    }
                    break;

                // Update Egency
                case 10:
                    System.out.print("Update Egency of employee: ");
                    str = sc.nextLine();
                    chx = new validate();
                    str = chx.standardized_Name(str);
                    newEmployee.setEgency(str);
                    break;
                default:
                    break;
            }
        }
        listEmployees.add(newEmployee);
        System.out.println("Update successful");

    }

    // REMOVE BY idEmployee
    public void removeEmployees() {

        if (listEmployees.size() == 0) {
            System.out.print("List Employee is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        System.out.print("Enter ID of employee need to update: ");
        String idEmp = sc.nextLine();
        validate chx = new validate();
        idEmp = chx.standardized_id(idEmp);

        boolean ok = false;
        for (int i = 0; i < listEmployees.size(); i++) {
            Employee e1 = listEmployees.get(i);
            if (e1.getIdEmployee().equals(idEmp) == true ) {
                listEmployees.remove(i);
                System.out.println("Remove successful");
                ok = true;
                break;
            }
        }
        if (ok == true)
            return;
        else {
            System.out.println("ID NOT EXIST! . Enter again");
        }
    }
    
    // Search BY Name (First Name or Last Name) or a part of name.
    public void searchEmployees() {
        if (listEmployees.size() == 0) {
            System.out.print("List Employee is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        String pattern = new String();

        System.out.print("Enter string to find an employee by name (first name or last name) or a part of name: ");
        pattern = sc.nextLine();
        String containString = new String(pattern.toLowerCase());
        ArrayList<String> listName = new ArrayList<String>();
        template();
        System.out.println("");
        for (Employee emp : listEmployees) {
            String fullName = emp.getFirstName() + " " +emp.getLastName();
            listName.add(fullName);
        }
        Boolean ok = false;
        for ( int i=0;i<listName.size();i++)
        {
            String str = listName.get(i);
            String standString = new String(str.toLowerCase());
            //String containString = new String(pattern.toLowerCase());
            if (standString.contains(containString) == true) {
                ok = true;
                //System.out.println(str);
                Employee e = new Employee();
                e = listEmployees.get(i);
                e.displayList(e);
            }
        }
        if (ok == false)
            System.out.print("ID of employee not found!");
    }

    // SORT
    public void sortEmployeesBySalary() {
        if (listEmployees.size() == 0) {
            System.out.print("List Employee is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        Collections.sort(listEmployees, new sortBySalary());
        show();
    }
    
    // Exit
    public void Exit() {
        System.out.println("Good Bye!");
    }

    //Show information of one employee 
    public void dumbEmployeeById(int pos) {
        Employee e1 = listEmployees.get(pos);
        System.out.println("(1)Id Employee: " + e1.getIdEmployee());
        System.out.println("(2)First Name: " + e1.getFirstName());
        System.out.println("(3)Last Name: " + e1.getLastName());
        System.out.println("(4)Phone: " + e1.getPhone());
        System.out.println("(5)Email: " + e1.getEmail());
        System.out.println("(6)Address: " + e1.getAddress());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.print( formatter.format(getDateOfBird()) + "    |"  );
        System.out.println("(7)Date Of Birth: " + formatter.format(e1.getDateOfBird()));
        System.out.println("(8)Sex: " + e1.getSex());
        System.out.println("(9)Salary: " + e1.getSalary());
        System.out.println("(10)Egency: " + e1.getEgency());
        System.out.println("(0)EXIT");
    }


    public void template() {
        System.out.print(
                "|ID        |First name |Last name         |Phone      |Email                       |Address           |DOT           |SEX    |Salary      |Egency     |");
    }

    //Display all of employee
    public void show() {
        template();
        for (Employee e : listEmployees) {
            e.displayList(e);
        }
        System.out.println();
    }
}