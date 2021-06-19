class Student
 {String name, rollno; int mark;
  Student(String name1, String rollno1, int mark1)
   {name=name1;rollno=rollno1;mark=mark1;
   }
  public String toString() {return(name+" "+rollno+" "+mark);} 
 }
class Node
 {Student info;
  Node next;
  Node() {}
  Node(Student x, Node p) {info=x;next=p;}
  Node(Student x) {this(x,null);}
 }
class MyList
 {Node head, tail;
  MyList() {head=tail=null;}
  void clear() {}
  boolean isEmpty() {return(head==null);}
  void addLast(Student x) 
   {Node q = new Node(x);
    if(isEmpty()) {head=tail=q;return;}
    tail.next=q;
    tail=q;
   }
  void addFirst(Student x)
   {Node q = new Node(x,head);
    head=q;
    if(tail==null) tail=q.next;
   }
  void addMany(String [] a, String [] b, int [] c) 
   {int n = a.length;
    for(int i=0;i<n;i++) addLast(new Student(a[i],b[i],c[i]));
   }
  void traverse()
   {Node p=head;
    while(p!=null) 
     {System.out.println(p.info);
      p=p.next;
     }
   }
 }
public class Main
 {public static void main(String [] args)
   {String [] a = {"Hoa","La","Canh","Cay","Qua"};
    String [] b = {"01","02","03","04","05"};
    int [] c = {7,8,5,9,6};
    System.out.println("\n1. Test addMany():");  
    MyList t = new MyList(); t.addMany(a,b,c);
    t.traverse();
    System.out.println();  
   }
 }

