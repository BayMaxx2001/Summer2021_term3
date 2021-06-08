import java.util.*;
class Node
   { String name;
      int age;
      Node() {}
      Node(String name1, int age1)
         { name=name1; age=age1;
         }
      void set(String name1, int age1)
         { name=name1; age=age1;
         }
      public String toString()
         { String s = name+"  "+age;
           return(s);    
         }
   }
//-------------------------------
class LinkedQueue
  { protected LinkedList list = new LinkedList();

    public boolean isEmpty()
      { return(list.isEmpty());}

    Object first() throws Exception
      { if(isEmpty()) throw new Exception();
        return(list.getFirst());
      }

    void enqueue(Object x)
      { list.addLast(x); 
      }

    public Object dequeue() throws Exception
      { if(isEmpty()) throw new Exception();
        return(list.removeFirst());
      }

   public String toString()
      { return(list.toString());
      }
  } 
//=============================
public class Main
  { public static void main(String [] args) throws Exception
       { LinkedQueue t = new LinkedQueue();
         Object x,y,z;
         x = (Object) new Node("A",1);
         t.enqueue(x);
         y = (Object) new Node("B",2);
         t.enqueue(y);
         z = (Object) new Node("C",3);
         t.enqueue(z);
         System.out.println(t);
         System.out.println((Node) t.first());
         System.out.println((Node) t.dequeue());
         System.out.println((Node) t.dequeue());
        }
  }
