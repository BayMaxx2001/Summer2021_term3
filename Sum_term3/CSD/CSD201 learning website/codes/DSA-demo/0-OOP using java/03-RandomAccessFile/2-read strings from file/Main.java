import java.io.*;
import java.util.*;

//=============================
public class Main
 {public static void main(String [] args)
   {String fname ="Employee.txt";
    RandomAccessFile f;
    String s = "";
    String s1,s2,s3,s4;
    StringTokenizer sk;
    try 
     {f = new RandomAccessFile(fname, "r");
      while((s = f.readLine()) != null )
        {sk = new StringTokenizer(s,"|");
         s1 = sk.nextToken();
         s2 = sk.nextToken();
         s3 = sk.nextToken();
         s4 = sk.nextToken();
	 System.out.println(s1 + " " + s2+ " " + s3 + " " + s4);
        }
      f.close();
     }
     catch(Exception e)
       {System.out.println("Error !");
       }

    }
  }

/*
Content of the Employee.txt file:
007  |  Hung  |  25   |  800
003  |  Tuyet |  27   |  500
010  |  Quang |  19   |  700
002  |  An    |  34   |  900
004  |  Giang |  29   | 1200
008  |  Huy   |  27   |  600
012  |  Quoc  |  21   | 1100

*/
