import java.io.*;
import java.util.*;
class Node
  {char info;
   Node next;
   Node(char x)
    {info=x; next=null;}
  };
//-------------------------------
class MyQueue
  { Node head,tail;

    MyQueue() 
      { head = tail = null; }

    boolean isEmpty()
      { return(head==null);}

    char front() throws Exception
      { if(isEmpty()) throw new Exception();
        return(head.info);
      }

    char dequeue() throws Exception
      { if(isEmpty()) throw new Exception();
        char x = head.info;
        head=head.next;
        if(head==null) tail=null;
         return(x);
      }

    void enqueue(char x)
      { if(isEmpty())
        head = tail = new Node(x);
        else
        { tail.next = new Node(x);
          tail = tail.next;
         }
      }

    void displayAll()
      { Node p = head;
        while(p!=null)
           { System.out.print(p.info + "  ");
             p = p.next;
           }
        System.out.println();
      }
  } 

//=============================
public class Main
 {public static void main(String [] args) throws Exception
    {int choice; char x;
     Scanner s = new Scanner(System.in);
     MyQueue d = new MyQueue();
     while(true)
      { System.out.println();
       System.out.println("1. enqueue");
       System.out.println("2. front");
       System.out.println("3. dequeue");
       System.out.println("4. Display all");
       System.out.println("0. Exit");
       System.out.print("  Your selection (0 -> 4): ");
       choice = s.nextInt();
       if(choice==0) break;
       switch(choice)
         {case 1: System.out.print("Enter the value to be enqueueed: ");
                  x = (char) System.in.read();
                  d.enqueue(x);
                  break;
          case 2: System.out.println("The element at the front is " + d.front());
                  break;
          case 3: System.out.println("The element dequeued is " + d.dequeue());
                  break;
          case 4: d.displayAll();
                  break;
         }
      }
    }
 }
