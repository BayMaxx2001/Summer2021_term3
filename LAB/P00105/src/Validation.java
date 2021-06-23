import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Date;

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

    public static int checkInputMenu(int min, int max){
        View view = new View();
        view.InitMenu();
        while(true)
        {
            view.displayListMenu();
            System.out.println("---------------------------------------");
            System.out.print("Enter your choice: ");
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

    public static double checkInputDoubleLimit(){
        while(true)
        {
            try {
                double choice = Double.parseDouble(sc.nextLine());
                return choice; 
            } catch(Exception e) {
                System.err.println("Please input is number");
                System.out.println("Enter again");    
            }
        }
    }
    public static Date checkInputDate(){
        while (true) {
            try {
                String dateFormat = "dd/MM/yyyy";
                Date date = new SimpleDateFormat(dateFormat).parse(sc.nextLine());
                if (date != null)
                    return date;
            } catch (Exception e) {
                System.out.println("Date of birth does not illegal! Enter again!");
            }
        }
    }
    public static Date checkInputDateSearch(){
        
        while (true) {
            try {
                String dateFormat = "dd/MM/yyyy";
                String input = sc.nextLine();
                if ( input == null){
                    return null;
                }
                Date date = new SimpleDateFormat(dateFormat).parse(input);
                if (date != null)
                    return date;
            } catch (Exception e) {
                System.out.println("Date of birth does not illegal! Enter again!");
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

    public static String checkInputSearchString() {
        String input = sc.nextLine();
        if (input.isEmpty() == true ) 
        {
            return "Empty";
        }
        input = input.trim();
        input = input.replaceAll("\\s+", " ");
        return input;
    }

    public static String standardizedName(String input) {
        if (input.isEmpty()) 
        {
            return input;
        }
        input = input.toLowerCase();
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                input += " ";
        }
        // System.out.println(input);
        return input;
    }
    public static String standardizedID(String input){
        input = input.trim();
        input = input.toUpperCase();
        input = input.replaceAll("\\s+", "");
        // System.out.println(input);
        return input; 
    }

    public static String checkInput_StorekeeperID_of_product(ArrayList<Storekeeper> listStorekeeper)
    {
        while ( true ) {
            String input = sc.nextLine();
            input = input.trim();
            input = input.replaceAll("\\s+", " ");
            if ( input.isEmpty()){
                System.err.println("Input must not empty");
                System.out.print("Enter again: ");
            }
            boolean ok = false ;
            input = standardizedID(input);
            for ( Storekeeper s : listStorekeeper){
                if ( s.getId().equals(input) == true) {
                    ok = true;
                    break;
                }
            }
            System.out.println("ID not exist in list of Storekeeper");
            if (ok== true)
                return input;
        }
    }
    
}
