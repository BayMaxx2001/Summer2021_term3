import java.util.*;
class HashTable
 {MyList [] a;int M; 
  HashTable() 
   {M = 10;
    a = new MyList[M];
    for(int i=0;i<M;i++) a[i] = new MyList();
   }
  boolean isEmpty()
   {boolean empty = true;
    for(int i=0;i<M;i++)
      if(!a[i].isEmpty()) {empty=false;break;}
    return(empty);
   }
  void clear() 
   {for(int i=0;i<M;i++)
      a[i].head = a[i].tail = null;
   }
  void add(int x)
   {int i = x%M;
    a[i].add(x);
   }
  void traverse()
   {if(isEmpty())
     {System.out.println("\n The Hash table is empty");
      return;
     }
    for(int i=0; i<M; i++)
     {System.out.print(" Linked list at " + i + ": ");
      a[i].traverse();
     }
    System.out.println();
   }
  Node search(int x)
   {int i = x%M;
    return(a[i].search(x));
   }
  void dele(int x)
   {int i = x%M;
    a[i].dele(x);
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
    Random r = new Random();
    clear();
    for(i=0;i<n;i++)
      {x = r.nextInt(100); // Choose value from 0 to 99
       add(x);
      }
   }
 }
