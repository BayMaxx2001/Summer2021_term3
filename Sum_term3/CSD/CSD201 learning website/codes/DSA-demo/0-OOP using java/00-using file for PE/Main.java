import java.io.*;
import java.util.*;
class Employee
 {String name;
  int salary,bonus;
  Employee(String xName, int xSalary, int xBonus)
   {name=xName;salary=xSalary;bonus=xBonus;
   }
  public String toString()
   {return(name+","+salary + ","+bonus);
   }
 }

class Node
 {Employee info;
  Node next;
  Node(Employee x, Node p)
   {info=x;next=p;
   }
  Node(Employee x)
   {this(x,null);
   }
 }

class MyList
 {Node head,tail;

  MyList() {head=tail=null;}

  boolean isEmpty()
   {return(head==null);
   }

  void clear() {head=tail=null;}

  void add(Employee x)
   {Node q = new Node(x);
    if(isEmpty())
     head=tail=q;
     else
     {tail.next=q;
      tail=q;
     }
   }

  void visit(Node p)
   {System.out.println(" " + p.info);
   }

  void visit(Node p, RandomAccessFile f) throws Exception
   {f.writeBytes(p.info + "\r\n");
   }

  void traverse()
   {Node p=head;
    while(p!=null)
     {visit(p);
      p=p.next;
     }
   }

  void traverse(String fname) throws Exception
  { File g = new File(fname);
    if(g.exists()) g.delete();
    RandomAccessFile f;
    f = new RandomAccessFile(fname, "rw");
    Node p = head;
   while(p!=null)
     {visit(p,f);
      p=p.next;
     }
   f.close();
  }

  void loadFile(String fname) throws Exception
  { RandomAccessFile f;
    String s,sa,sb,sc; int b, c; 
    StringTokenizer t;
    clear();
    f = new RandomAccessFile(fname, "r");
      while(true)
        {s = f.readLine();
         if(s==null) break;
         s = s.trim();
         if(s.length()<5) continue;
         t = new StringTokenizer(s,",");
         sa = t.nextToken();
         sb = t.nextToken();
         sc = t.nextToken();
         b = Integer.parseInt(sb.trim());
         c = Integer.parseInt(sc.trim());
         add(new Employee(sa,b,c));
        }
      f.close();
  }

 }

public class Main
 {public static void main(String args[]) throws Exception
   {String fname = "emp.txt";
     MyList t = new MyList();

     {System.out.println("\n 1. Test add & traverse (1 mark):");
       t.loadFile(fname);
       t.traverse("report.txt");
       System.out.println();       
     }
   }
 }
