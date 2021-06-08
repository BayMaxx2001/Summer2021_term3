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
    {int choice, i, n; char x='\0';
     Scanner s = new Scanner(System.in);
     MyQueue d = new MyQueue();
     String a = "HowAre$$You$$To$$Day";
     n = a.length();
     for(i=0;i<n;i++)
      {x = a.charAt(i);
       if(x=='$')
        System.out.print(d.dequeue());
         else
          d.enqueue(x);
      }
     System.out.println();
     while(!d.isEmpty())
      System.out.print(d.dequeue());
     System.out.println();
    }
 }
