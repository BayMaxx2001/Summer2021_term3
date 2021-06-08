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
  void displayAdjacency()
   {int i,j;
    System.out.println("\n Adjacency matrix of the graph:");
    System.out.println(" ============================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.print("  " + a[i][j]);
      }
    System.out.println();
   }
  void visit(int i)
   {System.out.print(" " + v[i]);
   }
  void depthFirst(boolean [] visited, int k) // depth first traverse from vertex k  
   {MyStack s = new MyStack();int i,h;
    boolean [] pushed = new boolean[n];
    for(i=0;i<n;i++) if(!visited[i]) pushed[i]=false;
    s.push(new Integer(k));pushed[k]=true;
    System.out.println("\n Depth first traverse from vertex " + v[k] +":");
    System.out.println(" ===================================\n");
    while(!s.isEmpty())
     {h=Integer.parseInt((s.pop()).toString().trim());visit(h);visited[h]=true;
      for(i=n-1;i>=0;i--)
	 if((a[h][i]>0 && !visited[i] && !pushed[i]))
           {s.push(new Integer(i));
            pushed[i] = true;
           }
     }
    System.out.println();
   }
  void depthFirst(int k) // depth first traverse from vertex k  
   {boolean [] visited;
    visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depthFirst(visited,k);
    i=0;
    while(i<n)
     {if(!visited[i] && i<n) depthFirst(visited,i);
      i++;
     }
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayAdjacency();
    System.out.println("\n The depth first traversal of the above graph is:");
    g.depthFirst(0);
    System.out.println();
   }
 }
