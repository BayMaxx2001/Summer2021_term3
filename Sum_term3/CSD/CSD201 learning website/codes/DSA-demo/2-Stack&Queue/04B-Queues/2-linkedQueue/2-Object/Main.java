import java.util.*;
//-------------------------------
class Node
  { public Object info;
    public Node  next;
    public Node(Object x, Node p)
      { info=x; next=p; }
    public Node(Object x)
      { this(x,null); }
  };
//-------------------------------
class MyQueue
  { protected Node head,tail;

    public MyQueue() 
      { head = tail = null; }

    public boolean isEmpty()
      { return(head==null);}

    Object front() throws Exception
      { if(isEmpty()) throw new Exception();
        return(head.info);
      }

    public Object dequeue() throws Exception
      { if(isEmpty()) throw new Exception();
        Object x = head.info;
        head=head.next;
        if(head==null) tail=null;
         return(x);
      }

    void enqueue(Object x)
      { if(isEmpty())
        head = tail = new Node(x);
        else
        { tail.next = new Node(x);
          tail = tail.next;
         }
      }

    public void displayAll()
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
  { public static void main(String [] args) throws Exception 
       { int choice; int  x, k;
         Scanner s = new Scanner(System.in);
         MyQueue q = new MyQueue();
         Integer X; 
         while(true)
            { System.out.println();
              System.out.println("1. Enqueue");
              System.out.println("2. View first");
              System.out.println("3. Dequeue");
              System.out.println("4. Display all elements of a queue");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be enqueued: ");
                                  x = s.nextInt();
                                  X = new Integer(x);
                                  q.enqueue(X);
                                  break;
                    case 2: System.out.println("The element at the front is  " + q.front());
                                  break;
                    case 3: System.out.println("The element dequeued  is  " + q.dequeue());
                                  break;
                    case 4: q.displayAll();
                                  break;
                  }
            }
        }
  }
