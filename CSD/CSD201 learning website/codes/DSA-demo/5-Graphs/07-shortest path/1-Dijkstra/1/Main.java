import java.util.*;
class MyQueue
 {LinkedList<Integer> t;
  MyQueue() {t=new LinkedList<Integer>();}
  void clear() {t.clear();}
  boolean isEmpty() {return(t.isEmpty());} 
  void enqueue(Integer x) {t.addLast(x);}
  Integer dequeue()
    {if(isEmpty()) return(null);
      return(t.removeFirst());
    }
  Integer front()
    {if(isEmpty()) return(null);
      return(t.getFirst());
    }
 }

class MyStack
 {LinkedList<Integer> t;
  MyStack() {t=new LinkedList<Integer>();}
  void clear() {t.clear();}
  boolean isEmpty() {return(t.isEmpty());} 
  void push(Integer x) {t.addFirst(x);}
  Integer pop()
    {if(isEmpty()) return(null);
      return(t.removeFirst());
    }
  Integer top()
    {if(isEmpty()) return(null);
      return(t.getFirst());
    }
 }
class Graph
 {int [][] a; int n;
  char [] v;
  Graph() {v="ABCDEFGHIJKLMN".toCharArray();}
  void setData(int [][] b)
   {n=b.length;
    int i,j;
    a=new int[n][n];
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
  void dijkstra(int fro, int to)
    {int INF=999;
     boolean [] s = new boolean[n];
      int [] d = new int[n];
      int [] p = new int[n];
      int i,k,t;
      for(i=0;i<n;i++)
        {s[i]=false;
         d[i]=a[fro][i];
         p[i]=fro;
        }
      s[fro]=true;
      while(true)
        {t=INF;k=-1;
          for(i=0;i<n;i++)
            if(!s[i] && d[i]<t) {t=d[i];k=i;}
          if(k==-1)
            {System.out.println("No solution");
              return;
            }
          s[k]=true;
          if(k==to) break;
          // update labels (d[i])
          for(i=0;i<n;i++)
             {if(s[i]) continue;
               if(d[k] + a[k][i] < d[i])
                 {d[i]=d[k] + a[k][i];
                   p[i]=k;
                 }
             }
        } 
   System.out.println(" Shortest distance from the vertex  " + v[fro] + " to the vertex " + v[to]  + " = " + d[to]);
   MyStack h = new MyStack();
   i = to;
   h.push(i);
   while(true)
     {i = p[i];
      h.push(i);
      if(i==fro) break;
     }
    i = h.pop();
   System.out.print(v[i]);
   while(!h.isEmpty())
     { i = h.pop();
      System.out.print(" -> " + v[i]);
     }

   }
 }

public class Main
 {public static void main(String [] args)
   {Graph g = new Graph();
    int [][] b = {
      {0, 7, 9, 999, 999, 14},
      {7, 0, 10, 15, 999, 999},
      {9, 10, 0, 11, 999, 2},
      {999, 15, 11, 0, 6, 999},
      {999, 999, 999, 6, 0, 9},
      {14, 999, 2, 999, 9, 0}
    };
    g.setData(b);
    g.dispAdj();
    System.out.println("\n1. Test Dijkstra's shortest path algorithm:");
    g.dijkstra(0,4);
    System.out.println();  
   }
 }
