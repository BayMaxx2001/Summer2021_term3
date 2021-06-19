import java.util.*;
class MyStack
 {LinkedList<Integer> t;
  MyStack() {t = new LinkedList<Integer>();}
  boolean isEmpty() {return(t.isEmpty());}
  void push(int x)
   {t.add(x);
   }
  int pop()
   {return(t.removeLast());
   }
 }

class MyQueue
 {LinkedList<Integer> t;
  MyQueue() {t = new LinkedList<Integer>();}
  boolean isEmpty() {return(t.isEmpty());}
  void enqueue(int x)
   {t.add(x);
   }
  int dequeue()
   {return(t.removeFirst());
   }
 }
class Graph
 {int [][] a; int n;
  char [] v;
  Graph() {v = "ABCDEFGHIJKLMN".toCharArray();}
  void setData(int [][] b)
   {n = b.length;
    int i,j;
    a = new int[n][n];
    for(i=0;i<n;i++)
     for(j=0;j<n;j++) a[i][j]=b[i][j];
   }
  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++) System.out.printf("%5d",a[i][j]);
     }
    System.out.println();  
   }
  void visit(int i) {System.out.print(v[i] + "  ");}
  void depth(boolean [] visited, int i)
   {visit(i);visited[i]=true;
    for(int j=0;j<n;j++)
     if(!visited[j] && a[i][j]>0) depth(visited,j);
   } 
  void depth(int k)
   {boolean [] visited = new boolean[n];
    int i,j;
    System.out.println("\n Depth first traverse from the vertex " + v[k] + ":");  
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k);
    for(i=0;i<n;i++) if(!visited[i]) depth(visited,i);
   } 
  void breadth(int k)
   {boolean [] en = new boolean[n];
    int i,j,x;
    for(i=0;i<n;i++) en[i]=false;
    MyQueue q = new MyQueue();
    q.enqueue(k);en[k]=true;
    while(!q.isEmpty())
     {x = q.dequeue();
      visit(x);
      for(j=0;j<n;j++)
        if(!en[j] && a[x][j]>0) {q.enqueue(j);en[j]=true;}
     }
   }
  boolean isConnected()
   {boolean [] p = new boolean[n];
    int i,j,x;
    for(i=0;i<n;i++) p[i]=false;
    MyStack s = new MyStack();
    s.push(0);p[0]=true;
    while(!s.isEmpty())
     {x = s.pop();
      for(j=n-1;j>=0;j--)
        if(!p[j] && a[x][j]>0) {s.push(j);p[j]=true;}
     }
    boolean ok = true;
    for(i=0;i<n;i++) {if(!p[i]) {ok=false;break;}}
    return(ok);
   }
  void displayDegrees()
   {int [] d = new int[n];
    int t;
    int i,j;
    for(i=0;i<n;i++)
     {t=0;
      for(j=0;j<n;j++)
        if(a[i][j]>0) t++;
      if(a[i][i]>0) t++;
      d[i]=t;
     }
    for(i=0;i<n;i++)
      System.out.print(v[i]+":"+d[i]+ " "); 
   }

 }
public class Main
 {public static void main(String [] args)
   {Graph g = new Graph();
    int [][] b = {
     {0,1,1,1,0,0},
     {1,0,0,0,1,0},
     {1,0,0,0,1,1},
     {1,0,0,0,0,1},
     {0,1,1,0,0,0},
     {0,0,1,1,0,0}
    };
    g.setData(b);
    g.dispAdj();
    System.out.println("\nDepth first from the vertex A:");  
    g.depth(0);
    System.out.println("\nBreadth first from the vertex A:");  
    g.breadth(0);
    System.out.println("\nCheck connectivity:");  
    boolean t = g.isConnected();
    if(t) 
     System.out.print("Connected");
      else
     System.out.print("Not connected");
    System.out.println();  
    g.displayDegrees();
    System.out.println();  
    int [][] c = {
     {0,1,1,0,0,0},
     {1,0,0,0,1,0},
     {1,0,0,0,1,1},
     {0,0,0,0,0,0},
     {0,1,1,0,0,0},
     {0,0,1,0,0,0}
    };
    g.setData(c);
    t = g.isConnected();
    if(t) 
     System.out.print("Connected");
      else
     System.out.print("Not connected");


    System.out.println();  
   }
 }
