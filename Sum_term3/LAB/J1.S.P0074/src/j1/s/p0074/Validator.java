
package j1.s.p0074;
import java.util.Scanner;

public class Validator {
    Scanner scanner=new Scanner(System.in);
    public  boolean isNumber(String str) { 
        try {  
            Integer.parseInt(str);  
            return true;
        } catch(NumberFormatException e){   
            System.err.println("Values must be the number");
            return false;  
        }  
    }
    public int validateInput(String message,int min, int max){
        int result;
        while (true){
            System.out.print(message);
            String input=scanner.nextLine();
            if (isNumber(input)) 
            {
                result = Integer.parseInt(input); 
                if (result<min || result>max) {
                    System.err.println("Wrong format, enter again.");
                    continue;
                }
                break;
            }
        }
        return result;
    }
}
