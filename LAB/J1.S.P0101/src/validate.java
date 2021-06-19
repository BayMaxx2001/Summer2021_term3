import java.util.ArrayList;
import java.util.Scanner;

public class validate {
    Scanner sc = new Scanner(System.in);
    public String standardized(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
    public String standardized_id(String str) {
        str = str.trim();
        str = str.toUpperCase();
        str = str.replaceAll("\\s+", "");
        return str ; 
    }
    public boolean checkDuplicate(ArrayList<Employee> list , String str) {
        str = str.trim();
        str = str.toUpperCase();
        str = str.replaceAll("\\s+", "");
        for (Employee e : list) {
            if (e.getIdEmployee().equals(str))return false ;
        }
        return true;
    }
    public String standardized_Name(String str) {
        str = standardized(str);
        String temp[] = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                str += " ";
        }
        return str;
    }
    public boolean checkPhone(String str) {
        for ( int i=0;i<str.length();i++) {
            if ( str.charAt(i) > '9' || str.charAt(i) < '0' ) return false ; 
        }
        return true;
    }

    public boolean checkEmail(String email) 
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    public String checkSex(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        str = str.toLowerCase();
        if ( str.equals("male") || str.equals("female") ) 
        {
            str.substring(0, 1).toUpperCase();
            return str ; 
        }
        return "Other";
    }
    public Double checkSalary(Double x) {
        
        while ( true ) 
        {
            try {
                System.out.println("enter salary");
                x = Double.parseDouble(sc.nextLine());
                if ( x < 0 ) 
                {
                    System.out.println("Salary does not illegal! Enter again!");
                    continue ; 
                } 
                else {
                    return x;
                }
            } 
            catch (Exception e) {
                System.out.println("Salary does not illegal! Enter again!");
            }
            
        }
    }

}
