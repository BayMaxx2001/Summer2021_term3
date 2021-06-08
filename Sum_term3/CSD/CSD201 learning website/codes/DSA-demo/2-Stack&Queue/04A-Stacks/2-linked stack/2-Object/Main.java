import java.util.*;
class Node
  { public Object info;
    public Node  next;
    public Node(Object x, Node p)
      { info=x; next=p; }
    public Node(Object x)
      { this(x,null); }
  };
//-------------------------------
class LinkedStack
  { protected Node head;

    public LinkedStack() 
      { head = null; }

    public boolean isEmpty()
      { return(head==null);}

    public void push(Object x)
      { head = new Node(x,head);
      }

    Object top() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        return(head.info);
      }

    public Object pop() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        Object x = head.info;
        head=head.next;
         return(x);
      }

    public void displayAll()
      { System.out.println("Elements in the list are:");
        for(Node p=head;p!=null;p=p.next) System.out.print(p.info + "  ");
        System.out.println();
      }
  }

//=============================
public class Main
  { public static void main(String [] args)
       { int choice; int  x;
         Scanner s = new Scanner(System.in);
         LinkedStack d = new LinkedStack();
         Integer X; 
         while(true)
            { System.out.println();
              System.out.println("1. Push");
              System.out.println("2. Top");
              System.out.println("3. Pop");
              System.out.println("4. Display all");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be pushed: ");
                                  x = s.nextInt();
                                  X = new Integer(x);
                                  d.push(X);
                                  break;
                    case 2: System.out.println("The element at the top is  " + d.top());
                                  break;
                    case 3: System.out.println("The element poped  is  " + d.pop());
                                  break;
                    case 4: d.displayAll();
                                  break;
                  }
            }
        }
  }
