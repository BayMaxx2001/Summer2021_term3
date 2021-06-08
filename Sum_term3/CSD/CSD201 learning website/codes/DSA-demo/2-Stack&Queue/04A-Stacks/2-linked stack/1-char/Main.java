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
    {int choice; char x;
     Scanner s = new Scanner(System.in);
     MyStack d = new MyStack();
     while(true)
      { System.out.println();
       System.out.println("1. Push");
       System.out.println("2. Top");
       System.out.println("3. Pop");
       System.out.println("4. Display all");
       System.out.println("0. Exit");
       System.out.print("  Your selection (0 -> 4): ");
       choice = s.nextInt();
       if(choice==0) break;
       switch(choice)
         {case 1: System.out.print("Enter the value to be pushed: ");
                  x = (char) System.in.read();
                  d.push(x);
                  break;
          case 2: System.out.println("The element at the top is " + d.top());
                  break;
          case 3: System.out.println("The element poped is " + d.pop());
                  break;
          case 4: d.displayAll();
                  break;
         }
      }
    }
 }
