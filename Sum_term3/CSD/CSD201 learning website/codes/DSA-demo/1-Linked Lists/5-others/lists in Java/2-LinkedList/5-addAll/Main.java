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
           LinkedList t = new LinkedList();
           Node x; int i;
           t.add(new Node("A01",25));
           t.add(new Node("A02",20));
           t.add(new Node("A03",23));
           for(i=0;i<t.size();i++)
             System.out.println(t.get(i));
           System.out.println();
           
           LinkedList h = new LinkedList(t);
           h.addAll(t);
           for(i=0;i<h.size();i++)
             System.out.println(h.get(i));
           System.out.println();
        }
   } 
