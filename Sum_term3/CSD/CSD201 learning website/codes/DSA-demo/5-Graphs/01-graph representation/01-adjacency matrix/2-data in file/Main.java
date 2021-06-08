import java.io.*;
import java.util.*;
class MyStack
 {LinkedList a;
  MyStack() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void push(Object x)
   {a.add(x);
   }
  Object pop()
   {return(a.removeLast());
   }
 }
class Graph
 {int [][] a; int n;
  Graph() {}
  void setData(String filename) throws IOException
   {int i,j;
    String s="", s1="";
    StringTokenizer t;
    RandomAccessFile f; 
    f = new RandomAccessFile(filename, "r");
    s = f.readLine();
    n = Integer.parseInt(s.trim());
    a = new int[n][n];
    for(i=0;i<n;i++)
     {s = f.readLine();
      t = new StringTokenizer(s);
      for(j=0;j<n;j++)
       {s1 = t.nextToken();
        a[i][j]=Integer.parseInt(s1.trim());
       }
     }

    f.close();
   }
  void displayAdjacency()
   {int i,j;
    System.out.println("\n Adjacency matrix of the graph:");
    System.out.println(" =============================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.print("  " + a[i][j]);
      }
    System.out.println();
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {Graph g =new Graph();
    g.setData("matrix.txt");
    g.displayAdjacency();
    System.out.println();
   }
  }
