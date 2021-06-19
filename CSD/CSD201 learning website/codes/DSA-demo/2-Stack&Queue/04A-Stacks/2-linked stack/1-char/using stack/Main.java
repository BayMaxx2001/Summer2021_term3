import java.io.*;
import java.util.*;
class Node
  {char info;
   Node next;
   Node(char x, Node p)
    {info=x; next=p;}
  };
//-------------------------------
class MyStack
  {Node head;

   MyStack() 
    {head = null;}

   boolean isEmpty()
    {return(head==null);}

   void push(char x)
    {head = new Node(x,head);
    }

   char top() throws EmptyStackException
    {if(isEmpty()) throw new EmptyStackException();
     return(head.info);
    }

   char pop() throws EmptyStackException
    {if(isEmpty()) throw new EmptyStackException();
     char x = head.info;
     head=head.next;
     return(x);
    }

   void displayAll()
    {System.out.println("Elements in the list are:");
     for(Node p=head;p!=null;p=p.next) System.out.print(p.info + " ");
     System.out.println();
    }
  }

//=============================
public class Main
 {public static void main(String [] args) throws IOException
    {int choice, i, n; char x='\0';
     Scanner s = new Scanner(System.in);
     MyStack d = new MyStack();
     String a = "GoodM**orn****in*g";
     n = a.length();
     for(i=0;i<n;i++)
      {x = a.charAt(i);
       if(x=='*')
        System.out.print(d.pop());
         else
          d.push(x);
      }
     System.out.println();
     while(!d.isEmpty())
      System.out.print(d.pop());
     System.out.println();
    }
 }
