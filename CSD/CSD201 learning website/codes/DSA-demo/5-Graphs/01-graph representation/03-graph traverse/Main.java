import java.util.*;
class MyQueue
 {ArrayList t;
  MyQueue() {t=new ArrayList();}
  boolean isEmpty() {return(t.isEmpty());}
  void enqueue(int x) {t.add(new Integer(x));}
  int dequeue() 
   {assert(!isEmpty());
    int x = (Integer) t.remove(0);
    return(x);
   }
 }
class Graph
 {int [][] a; int n;
  char [] v;
  Graph() {v = "ABCDEFGHIJKLMN".toCharArray();}
  void setData(int [][] b)
   {n=b.length;
    a = new int[n][n];
    int i,j;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++) a[i][j]=b[i][j];
   }
  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
     }
   }
  void visit(int i) {System.out.print(" " +v[i]);}
  void depthFirst(boolean [] visited,int k)
   {visit(k);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depthFirst(visited,i);
      }
   }
  void depthFirst(int k)
   {boolean [] visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    System.out.println("\n Depth-first traverse from the vertex " + v[k] + ":");
    depthFirst(visited,k);
   }

  void breadthFirst(int k)
   {boolean [] visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    System.out.println("\n Bread-first traverse from the vertex " + v[k] + ":");
    MyQueue q = new MyQueue();
    q.enqueue(k); int r;
    while(!q.isEmpty())
     {r = q.dequeue();
      if(!visited[r]) visit(r);visited[r]=true;
      for(i=0;i<n;i++)
       {if(!visited[i] && a[r][i]>0) q.enqueue(i);
       }
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
    Graph g =new Graph();
    g.setData(b);
    g.dispAdj();
    g.depthFirst(0);
    g.breadthFirst(0);
    System.out.println();
   }
  }
