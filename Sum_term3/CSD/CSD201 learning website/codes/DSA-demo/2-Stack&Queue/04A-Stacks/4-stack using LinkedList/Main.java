import java.util.*;
class MyStack
 {LinkedList h;
  MyStack() {h = new LinkedList();}
  boolean isEmpty() {return(h.isEmpty());}
  void push(Object x)
   {h.add(x);
   }
  Object pop()
    {if(isEmpty()) return(null);
     return(h.removeLast()); 
    }
 }
public class Main
 {public static void decToBin(int k)
    {MyStack s = new MyStack();
     System.out.print(k + " in binary system is: ");
     while(k>0)
      {s.push(new Integer(k%2));
       k = k/2;
      }
     while(!s.isEmpty())
      System.out.print(s.pop());
     System.out.println();
    }
  public static void main(String [] args)
   {decToBin(11);
    System.out.println();
   }
 }
