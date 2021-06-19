import java.util.*;
class FloatList
   {float a[];int n;
    void input()
      {Scanner s = new Scanner(System.in);
       System.out.print("\nNumber of numbers to be entered (n) = ");
       n = s.nextInt();
       a = new float[n];
       System.out.print("\nEnter "+ n + " numbers(separated by spaces): ");
       for(int i = 0;i<n;i++)  a[i]=s.nextFloat();
      }    
    void view()
      {System.out.print("\nNumbers entered are: ");
       for(int i = 0;i<n;i++)  System.out.print(a[i]+ "   ");
       System.out.println();
      }    
   }
class Main
   {public static void main(String args[])
        {FloatList d = new FloatList(); 
         d.input();
         d.view();      
        }
   }