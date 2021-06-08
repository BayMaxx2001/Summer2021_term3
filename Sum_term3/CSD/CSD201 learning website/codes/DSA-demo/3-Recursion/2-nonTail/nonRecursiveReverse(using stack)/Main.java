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

   char pop() throws EmptyStackException
    {if(isEmpty()) throw new EmptyStackException();
     char x = head.info;
     head=head.next;
     return(x);
    }

  }


public class Main
 {public static void nonRecursiveReverse() throws Exception
   {MyStack t = new MyStack();
    char ch;
    while(true)
     {ch = (char) System.in.read();
      if(ch == '\n') break; 
      t.push(ch);
     }
    while(!t.isEmpty())
      System.out.print(t.pop());
   }
  public static void main(String [] args) throws Exception
   {System.out.println("\nEnter a string to be reversed:");
    nonRecursiveReverse();
    System.out.println("\n");
   }
 }
