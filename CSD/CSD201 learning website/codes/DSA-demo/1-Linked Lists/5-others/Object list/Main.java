class Employee
 {String name;
  int age;
  Employee(String name1, int age1)
   {name=name1;age=age1;
   }
  public String toString()
   {return(name+"  "+age);
   }
 }
class Node
 {Object info;
  Node next;
  Node() {}
  Node(Object x, Node p)
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
  void add(Object x)
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
    Employee x; 
    x = new Employee("ABC",22);
    h.add(x);
    x = new Employee("XYZ",20);
    h.add(x);
    h.traverse();
    System.out.println();
   }
 }
