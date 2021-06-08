import java.util.*;
class Node
 {int info;
  Node prev,next;
  Node() {}
  Node(int x, Node p, Node q)
   {info=x;prev=p; next=q;
   }
 }
class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}
  void add(int x)	// Different from singly linked list
   {if(search(x)!=null)
     {System.out.println("The key " + x + " already exists, no insertion");
      return;
     }
    if(isEmpty())
     head=tail=new Node(x,null,null);
     else
     {Node q =new Node(x,tail,null);
      tail.next=q;
      tail=q;
     }
   }
  void traverse()
   {if(isEmpty())
     {System.out.println("\n The list is empty");
      return;
     }
    Node p=head;
    while(p!=null)
     {System.out.print("  " + p.info);
      p=p.next;
     }
    System.out.println();
   }
  Node search(int x) 
   {Node p = head;
    while(p!=null)
     {if(p.info==x) return(p);
      p=p.next;
     }
    return(null);
   }
  void dele(int x)	// Different from singly linked list
   {if(isEmpty())
     {System.out.println("\n The list is empty");
      return;
     }
    if(head.info==x)
      {head=head.next;
       if(head==null) tail=null;
       return;
      }
    Node f,p;p = head;
    while(p!=null && p.info!=x) p=p.next;
    if(p!=null)
     {f=p.prev;
      f.next=p.next;
     }
     else
     System.out.println(x + " is not found in the list, no deletion");
   }
   void sort() 
    {Node p1,p2, p; int x;
     p1=head;
     while(p1!=null)
      {x = p1.info;p=p1;
       p2=p1.next;
       while(p2!=null)
        {if(p2.info<x)
           {p=p2;x=p2.info;}
         p2=p2.next; 
        } 
       if(p!=p1)
         {x=p1.info;p1.info=p.info;p.info=x;}
       p1=p1.next;
      }
    }
  boolean sorted() 
   {if(isEmpty() || head==tail)
     {return(true);
     }
    Node f=head,p = f.next;
    while(p!=null)
     {if(p.info<f.info) return(false);
      f=p;
      p=p.next;
     }
    return(true);
   }
  void insert(int x) // Insert value x into sorted list. Different from singly linked list
   {if(!sorted())
     {System.out.println("The list is not sorted, no insertion");
      return;
     }
    if(isEmpty())
      {head=tail=new Node(x,null,null);
       return;
      }
    if(search(x)!=null)
     {System.out.println("The key " + x + " already exists, no insertion");
      return;
     }
    Node f,p; p=head;
    while(x>p.info) p=p.next;

    f=p.prev;
    Node q = new Node(x,f,p);
    f.next=q;
    if(tail==f) tail=q;  
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
       System.out.println("  5. Sort");
       System.out.println("  6. Check sorting");
       System.out.println("  7. Insert");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 7): ");
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
         case 5: t.sort();
                 t.traverse();
                 break;
         case 6: if(t.sorted())
                  System.out.println(" The list is sorted");
                   else 
                    System.out.println(" The list is not sorted");
                 break;
         case 7: System.out.print("\n Enter value to be inserted: ");
                 x = s.nextInt();
                 t.insert(x);
                 t.traverse();
                 break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
      }
   }
 }
