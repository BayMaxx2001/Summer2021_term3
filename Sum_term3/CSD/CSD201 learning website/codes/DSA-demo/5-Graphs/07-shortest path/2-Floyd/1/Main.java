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
  int [][] d; int [][] p;int INF;
  char [] v;
  Graph() {v="ABCDEFGHIJKLMN".toCharArray(); INF=999;}
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
  void floyd()
   {int i,j,k;
    d = new int[n][n];
    p = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
         {d[i][j] = a[i][j];
           p[i][j]=i;
         }
     for(k=0;k<n;k++)
       for(i=0;i<n;i++)
          for(j=0;j<n;j++)
            {if(d[i][j] > d[i][k] + d[k][j])
                {d[i][j] = d[i][k] + d[k][j];
                  p[i][j] = k;
                }
            }
   }
  void shortestPath(int fro, int to)
    {floyd();
      int i;
     System.out.println("\n The shortest distance = " + d[fro][to]);
     MyStack h = new MyStack();
     i=to;h.push(i);
     while(true)
       {i = p[fro][i];
         h.push(i);
         if(i==fro) break;
       }
     i = h.pop();
     System.out.print(v[i]);
     while(!h.isEmpty())
       {i=h.pop();
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
    System.out.println("\n1. Test Floyd's shortest path algorithm:");
    g.shortestPath(0,4);
    System.out.println();  
   }
 }
