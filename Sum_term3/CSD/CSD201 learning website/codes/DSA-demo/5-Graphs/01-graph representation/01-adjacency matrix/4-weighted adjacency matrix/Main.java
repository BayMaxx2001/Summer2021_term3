import java.io.*;
import java.util.*;
class Edge
 {int u, v;
  int weight;
  Edge(int u1, int v1, int w1)
   {u=u1; v=v1; weight=w1;
   }
  Edge(Edge h)
   {u = h.u;
    v = h.v;
    weight = h.weight;
   }
  void display()
   {System.out.println(" ("+(u+1) + ", " + (v+1) + ", " + weight + ")");
   }
 }
//================================================
class Graph
 {int [][] a; int n;
  Graph() {}
  //----------------------------------------
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
  //----------------------------------------
  void displayAdjacency()
   {int i,j;
    System.out.println("\n The wighted matrix of the graph:");
    System.out.println(" ===============================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
   }
  //----------------------------------------
  Edge [] createAdjList()
   {int i,j,k;
    k = 0;
    for(i=0;i<n;i++)
     for(j=i;j<n;j++)
      if(a[i][j]>0) k++;
    Edge [] b = new Edge[k];
    k=0;
    for(i=0;i<n;i++)
     for(j=i;j<n;j++)
      if(a[i][j]>0)
        b[k++] = new Edge(i,j,a[i][j]);
    return(b);
   }
  //----------------------------------------
  void displayAdjList() throws Exception
   {if(n==0) setData("matrix.txt");
    Edge [] q = createAdjList();
    int i, m;
    m = q.length;
    if(m==0) return;
    System.out.println(" Number of edges m = " + m);
    for(i=0;i<m;i++) q[i].display();
    System.out.println();
   }
 }
//=======================================================
public class Main
 {public static void main(String args[]) throws Exception
   {Scanner s = new Scanner(System.in);
    int choice;
    Graph g =new Graph();
    while(true)
      {System.out.println("\n Choose your option:");
       System.out.println("  1. Read adjacency matrix from file");
       System.out.println("  2. Display adjacency matrix");
       System.out.println("  3. Create adjacency list");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 3): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1:  g.setData("matrix.txt");
                  break;
         case 2:  g.displayAdjacency();
                  break;
         case 3:  g.displayAdjacency();
                  g.displayAdjList();
                  break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
       System.out.println();
      }
   }
 }

