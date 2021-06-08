class A
  {
  }
class B
  {int x;
   B(int x1) {x=x1;}
   public boolean equals(Object h)
    {return(x==((B) h).x);}
  }
public class Main 
  {public static void main(String args[])
    {A t1,t2;
     t1=new A(); t2=new A();
     System.out.println(t1.equals(t2));
     B g1,g2;
     g1=new B(2); g2=new B(2);
     System.out.println(g1.equals(g2));
    }
  }

