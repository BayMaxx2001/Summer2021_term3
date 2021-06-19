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
  Graph() {}
  Graph(int [][] b, int m)
   {int i,j;
    n = m;
    a = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
           a[i][j]=b[i][j];
   }
  void setAdjancy(int [][] b, int m)
   {int i,j;
    n = m;
    a = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
           a[i][j]=b[i][j];
   }
  void displayAdjancy()
   {int i,j;
    System.out.println("\n Adjancy matrix of the graph:");
    System.out.println(" ============================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.print("  " + a[i][j]);
      }
    System.out.println();
   }
  void breadthTraverse(boolean [] visited, int k) // bread first traverse from vertex k  
   {MyQueue q = new MyQueue();int i,h;
    boolean [] displayed = new boolean[n];
    for(i=0;i<n;i++) displayed[i]=false;
    q.enqueue(new Integer(k));visited[k]=true;
    System.out.println("\n Breadth first traverse from vertex " + (k+1) +":");
    System.out.println(" =====================================\n");
    while(!q.isEmpty())
     {h=Integer.parseInt((q.dequeue()).toString().trim());visited[h]=true;
      if(!displayed[h])
	{System.out.print(" " + (h+1));displayed[h]=true;}
      for(i=0;i<n;i++)
	 if((!visited[i] || !displayed[h]) && a[h][i]>0) q.enqueue(new Integer(i));
     }
    System.out.println();
   }
  void breadthTraverse(int k) // breadth first traverse from vertex k  
   {boolean [] visited;
    visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    breadthTraverse(visited,k);
    i=0;
    while(i<n)
     {if(!visited[i] && i<n) breadthTraverse(visited,i);
      i++;
     }
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
    g.displayAdjancy();
    g.breadthTraverse(0);
    System.out.println();
   }
  }
