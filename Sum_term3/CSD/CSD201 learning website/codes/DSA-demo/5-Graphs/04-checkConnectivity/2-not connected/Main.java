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
   {if(isEmpty()) return(null);
    return(a.removeLast());
   }
  Object viewTop()
   {if(isEmpty()) return(null);
    return(a.getLast());
   }
 }

class EulerCycle
 {int [] cyc; int m;
  EulerCycle()
   {cyc = new int[50];
    m = 0;
   }
 }
class Graph
 {int [][] a; int n;
  char [] v;//Vertices label
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s1.toCharArray();
   }
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
  void displayData()
   {int i,j;
    System.out.println("\n The adjacency matrix of the graph:");
    System.out.println(" ==================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) 
         System.out.printf(" %3d",a[i][j]);
      }
    System.out.println();
   }
  //---------------------------------------------------------
  boolean isConnected()
   {int i, h;
    boolean [] visited = new boolean[20];
    boolean [] pushed = new boolean[20];
    for(i=0;i<n;i++) {visited[i] = false; pushed[i]=false;}
    MyStack t = new MyStack();
    t.push(new Integer(0));pushed[0] = true;
    System.out.println();
    while(!t.isEmpty())
     {h = ((Integer) t.pop()).intValue(); visited[h] = true;
      for(i = n-1;i>=0; i--)
        if(a[h][i]>0 && !pushed[i]) {t.push(i);pushed[i]=true;}
     }
    for(i=0;i<n;i++) if(!visited[i]) return(false);
    return(true);
   }

 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    boolean b = g.isConnected();
    if(b==true)
     System.out.println(" The above graph is connected");
      else
      System.out.println(" The above graph is not connected");
    System.out.println();
   }
 }

