import java.io.*;
import java.util.*;
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

  void depthFirst(boolean visited[], int i)
   {visit(i);visited[i] = true; 
    int j;
    for(j=0;j<n;j++)
        if(a[i][j]>0 && (!visited[j]))
           depthFirst(visited,j);
     
   }
  void depthFirst(int k)
   {int i,h; boolean [] visited = new boolean[20];
    for(i=0;i<n;i++) visited[i]=false;
    System.out.println(" The connected part 1:");
    depthFirst(visited,k);
    h=2;
    for(i=0;i<n;i++) 
     if(!visited[i]) 
       {System.out.println("\n The connected part " + h + ": ");
        h++;
        depthFirst(visited,i);
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
    System.out.println("\n The depth first traversal of the above graph is:");
    g.depthFirst(0);
    System.out.println();
   }
 }

