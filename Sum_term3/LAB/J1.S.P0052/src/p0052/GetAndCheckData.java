
package p0052;

import java.util.Scanner;

public class GetAndCheckData {
    static Scanner sc = new Scanner(System.in);
    
    // function that Get Integer and check this validate and in range [minVal,maxVal]
    public static int GetAndCheckInt(String intro,int minVal , int maxVal)
    {
        int res ;
        do{
            System.out.println(intro);
            try{
                
                res =Integer.parseInt(sc.nextLine());
                if(res >= minVal && res <= maxVal) return res;
                System.out.format("Input value must be in range [%d,%d]\n",minVal , maxVal);
            }
            catch(Exception e)
            {
                System.out.println("Invalid input value!!!!!");
            }
        }while(true);
    }
    
    //function that get Float and check this validate and in range[minVal, maxVal];
    public static float GetAndCheckFloat(String intro, float minVal, float maxVal)
    {
        float res;
        do{
            System.out.println(intro);
            try{
                res = Float.parseFloat(sc.nextLine());
                if(res >= minVal && res <= maxVal) return res;
                //System.out.format("Input value must be in range [%.2f,%.2f]\n",minVal , maxVal);
                System.out.println("Input value must be larger than 0");
                
            }
            catch(Exception e)
            {
                System.out.println("Invalid input value!!!!!");
            }
        }while(true);
    }
    
    
    // funciton that get Text and check not null or empty;
    public static String GetAndCheckText(String intro )
    {
        String res;
        
        do{
            System.out.println(intro);
            try{
                res = (sc.nextLine());
                res = res.trim();
                if(!res.equals("")) return res;
                else System.out.println("String mustn't be empty!!!"); 
            }
            catch(Exception e)
            {
                System.out.println("Invalid input value!!!!!");
            }
        }while(true);
    }
}
