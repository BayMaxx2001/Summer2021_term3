import java.util.*;
class Node
 {int info;
  Node next;
  Node() {}
  Node(int x, Node p)
   {info=x;next=p;
   }
 }
class MyList
 {Node tail;
  MyList() {tail=null;}
  boolean isEmpty()
   {return(tail==null);
   }
  void clear() {tail=null;}
  void add(int x)
   {if(search(x)!=null)
     {System.out.println("The key " + x + " already exists, no insertion");
      return;
     }
    if(isEmpty())
     {tail=new Node(x,null);
      tail.next=tail;
     }
     else
     {Node q =new Node(x,tail.next);
      tail.next=q;
      tail=q;
     }
   }
  void traverse()
   {if(isEmpty())
     {System.out.println("\n The list is empty");
      return;
     }
    if(tail.next==tail)
     {System.out.print("  " + tail.info);
      return;
     }
    Node p,q; q=tail.next;
    System.out.print("  " + q.info);
    p = q.next;
    while(p!=q)
     {System.out.print("  " + p.info);
      p=p.next;
     }
    System.out.println();
   }
  Node search(int x)
   {if(isEmpty()) return(null);
    Node p;
    if(tail.info==x) return(tail);
    p = tail.next;
    while(p!=tail)
     {if(p.info==x) return(p);
      p=p.next;
     }
    return(null);
   }
  void dele(int x)
   {if(isEmpty())
     {System.out.println("\n The list is empty");
      return;
     }
    Node f,p;
    if(tail.info==x)
      {if(tail.next==tail)
         tail=null;
          else
          {f=tail;p=tail.next;
           while(p!=tail) {f=p;p=p.next;}
           f.next=tail.next;
           tail=f;
          }
       return;
      }
    f=tail; p = f.next;
    while(p!=tail && p.info!=x)
     {f=p;
      p=p.next;
     }
    if(p!=tail)
     {f.next=p.next;
     }
     else
     System.out.println(x + " is not found in the list, no deletion");
   }
  void addArray(int [] b)
   {int i,n;
    n = b.length;
    for(i=0;i<n;i++)
       add(b[i]);
   }
  void addRandom()
   {int i,n,x;
    Scanner s = new Scanner(System.in);
    System.out.print(" Enter n = ");
    n = s.nextInt();
    // Create a random number generator,
    // seeds with current time by default:
    Random r = new Random();
    clear();
    for(i=0;i<n;i++)
      {x = r.nextInt(100); // Choose value from 0 to 99
       add(x);
      }
   }
 }
public class Main
 {public static void main(String args[])
   {Scanner s = new Scanner(System.in);
    int choice, x; Node p;
    int [] b = {5,7,11,3,9,2,6,5};
    MyList t = new MyList();
    t.addArray(b);
    while(true)
      {System.out.println("\n Choose your option:");
       System.out.println("  1. Create a list randomly");
       System.out.println("  2. Display a list");
       System.out.println("  3. Search");
       System.out.println("  4. Delete");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 4): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1: t.addRandom();
                 t.traverse();
                 break;
         case 2: t.traverse();
                 break;
         case 3: System.out.print("\n Enter value to be searched: ");
                 x = s.nextInt();
                 p = t.search(x);
                 if(p!=null)
                  System.out.println(x + " is found in the list");
                   else 
                    System.out.println(x + " is not found in the list");
                 break;
         case 4: System.out.print("\n Enter value to be deleted: ");
                 x = s.nextInt();
                 t.dele(x);
                 t.traverse();
                 break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
      }
   }
 }
