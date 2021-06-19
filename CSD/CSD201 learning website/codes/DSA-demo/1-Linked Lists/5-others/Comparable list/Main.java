class Employee implements Comparable
 {String name;
  int age;
  Employee(String name1, int age1)
   {name=name1;age=age1;
   }
  public String toString()
   {return(name+"  "+age);
   }
  public int compareTo(Object x)
   {String name1 = name.trim();
    String name2 = ((Employee) x).name.trim();
    return(name1.compareTo(name2));
   }
  public boolean equals(Object x)
   {String name1 = name.trim();
    String name2 = ((Employee) x).name.trim();
    return(name1.equals(name2));
   }
 }
class Node
 {Comparable info;
  Node next;
  Node() {}
  Node(Comparable x, Node p)
   {info=x;next=p;
   }
  public String toString()
   {return(info.toString());
   }
 }
class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void add(Comparable x)
   {if(isEmpty())
     head=tail=new Node(x,null);
     else
     {Node q =new Node(x,null);
      tail.next=q;
      tail=q;
     }
   }
  void traverse()
   {Node p=head;
    while(p!=null)
     {System.out.println(p);
      p=p.next;
     }
   }
 }
public class Main
 {public static void main(String[] args)
   {MyList h = new MyList();
    Employee x,y, z; 
    x = new Employee("ABC",22);
    h.add(x);
    y = new Employee("XYZ",20);
    h.add(y);
    h.traverse();
    System.out.println(" x.compareTo(y) = " + x.compareTo(y));
    z = new Employee("XYZ",20);
    System.out.println(" y.equals(z) = " + y.equals(z));
    System.out.println();
   }
 }
