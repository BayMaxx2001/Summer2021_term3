class A
  {public String toString()
    {return("ABC");
    }
  }
public class Main 
  {public static void main(String args[])
    {Object t1 = new Object();
     Object t2 = new Object();
     String a = t1.toString().substring(16);
     String b = t2.toString().substring(16);
     System.out.println(" A string returned by the function toString() of the object t1, t2, and h are");

     System.out.println(a);
     System.out.println(b);
     A h = new A();
     System.out.println(h);
    }
  }

