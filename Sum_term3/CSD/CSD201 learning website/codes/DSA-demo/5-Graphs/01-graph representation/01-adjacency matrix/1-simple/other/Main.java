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
  Graph(int [][] b, int m)
   {int i,j;
    n = m;
    a = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
           a[i][j]=b[i][j];
   }
  void setAdjacency(int [][] b, int m)
   {int i,j;
    n = m;
    a = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
           a[i][j]=b[i][j];
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
 {public static void main(String [] args)
   {int [][]b = {
                 {0,1,1,1,0},
                 {1,0,1,0,0},
                 {1,1,0,0,1},
                 {1,0,0,0,0},
                 {0,0,1,0,0}
                };
    int n = 5;
    Graph g =new Graph(b,n);
    g.displayAdjacency();
    System.out.println();
   }
  }
