class A implements Comparable
  {String name; int age;
   A(String name1, int age1) {name=name1;age=age1;}
   public int compareTo(Object t)
     {A h = (A) t;
      if(age<h.age)
        return(-1);
         else if (age==h.age)
           return(0);
            else
             return(1);
     }
  }
public class Main 
  {public static void main(String args[])
    {A t1 = new A("XYZ",25);
     A t2 = new A("BXY",30);
     System.out.println(t1.compareTo(t2));
    }
  }

