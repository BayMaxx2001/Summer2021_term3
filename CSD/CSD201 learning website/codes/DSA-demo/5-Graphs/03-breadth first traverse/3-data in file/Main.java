import java.io.*;
import java.util.*;
class MyQueue
 {LinkedList a;
  MyQueue() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void enqueue(Object x)
   {a.add(x);
   }
  Object dequeue()
   {return(a.removeFirst());
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
    System.out.println(" ================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) 
         System.out.printf(" %3d",a[i][j]);
      }
    System.out.println();
   }
  void visit(int i)
   {System.out.print(" " + v[i]);
   }
  void breadthFirst(boolean [] visited, int k) // bread first traverse from vertex k  
   {MyQueue q = new MyQueue();int i,h;
    boolean [] enqueued = new boolean[n];
    for(i=0;i<n;i++) enqueued[i]=false;
    q.enqueue(new Integer(k));enqueued[k]=true;
    while(!q.isEmpty())
     {h=Integer.parseInt((q.dequeue()).toString().trim());
      visit(h);
      visited[h]=true;
      for(i=0;i<n;i++)
	 if((!enqueued[i]) && (!visited[i]) && a[h][i]>0)
          {q.enqueue(new Integer(i));
           enqueued[i] = true;
          }
     }
    System.out.println();
   }
  void breadthFirst(int k) // breadth first traverse from vertex k  
   {boolean [] visited;
    visited = new boolean[n];
    int i, h;
    for(i=0;i<n;i++) visited[i]=false;
    System.out.println(" The connected part 1:");
    breadthFirst(visited,k);
    h=2;
    for(i=0;i<n;i++) 
     if(!visited[i]) 
       {System.out.println("\n The connected part " + h + ": ");
        h++;
        breadthFirst(visited,i);
       }
    System.out.println();
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    System.out.println("\n The breadth first traversal of the above graph is:");
    g.breadthFirst(0);
    System.out.println();
   }
 }
