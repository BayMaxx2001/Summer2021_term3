import java.io.*;
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
class Main
   {
     public static  void main(String [] args) throws Exception
        {
          ArrayList<Node> t = new ArrayList<Node>();
           t.ensureCapacity(10);
           Node x; int n,i;
           x = new Node("A01",25); t.add(x);
           x = new Node("A02",23); t.add(x);
           x = new Node("A03",21); t.add(x);
           for(i=0;i<t.size();i++)
          System.out.println(t.get(i));
        }
   } 

/*
*/
