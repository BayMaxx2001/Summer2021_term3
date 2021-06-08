import java.util.*;
public class Main
 {public static void main(String args[])
   {
     Set s = new HashSet();
     String [] a = {"i", "came", "i", "came", "i", "conquered"};
     for(int i=0; i<a.length;i++)
      {
       if(!s.add(a[i]))
        System.out.println("Duplicate detected : " + a[i]);
      }

     System.out.println(s.size() + " distinct words detected : " + s );
   }
 }
