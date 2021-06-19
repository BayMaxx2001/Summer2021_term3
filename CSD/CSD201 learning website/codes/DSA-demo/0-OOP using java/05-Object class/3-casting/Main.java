class A
  {String name; int age;
   A(String name1, int age1) {name=name1;age=age1;}
   void display()
    {System.out.println(name + "  " + age);
    }
  }
public class Main 
  {public static void main(String args[])
    {A t1 = new A("XYZ",25);
     Object h = (Object) t1;
     A t2 = (A) h;
     t2.display();
     System.out.println();
    }
  }

