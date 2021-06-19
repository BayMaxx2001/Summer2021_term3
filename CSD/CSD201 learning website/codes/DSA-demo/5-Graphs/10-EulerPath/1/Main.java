import java.util.*;
class MyStack
  {LinkedList<Integer> t;
    MyStack() {t = new LinkedList<Integer>();}
    boolean isEmpty() {return(t.isEmpty());}
   void clear() {t.clear();}
    void push(int x) {t.addLast(x);}
   Integer pop()
    {if(isEmpty()) return(null);
      return(t.removeLast());
    }
   Integer top()
    {if(isEmpty()) return(null);
      return(t.getLast());
    }
  } 

class MyQueue
  {LinkedList<Integer> t;
    MyQueue() {t = new LinkedList<Integer>();}
    boolean isEmpty() {return(t.isEmpty());}
   void clear() {t.clear();}
    void enqueue(int x) {t.addLast(x);}
   Integer dequeue()
    {if(isEmpty()) return(null);
      return(t.removeFirst());
    }
   Integer front()
    {if(isEmpty()) return(null);
      return(t.getFirst());
    }
  } 
class EulerPath
  {int [] e; int m;
    char [] v;
    EulerPath() {e = new int[50]; m=0; v = "ABCDEFGHIJKLMN".toCharArray();}
    void add(int x) {e[m++] = x;}
    void display()
      {for(int i=0;i<m-1;i++) System.out.print(v[e[i]] + " -> ");
        System.out.println(v[e[m-1]]);
      }
  }

class Graph
 {int [][] a; int n;
  char [] v;
  Graph() {n=0; v = "ABCDEFGHIJKLMN".toCharArray();}
  void setData(int [][] b)
    {n=b.length;
      a=new int[n][n];
      int i,j;
      for(i=0;i<n;i++)
        for(j=0;j<n;j++) a[i][j]=b[i][j];
    }
  void dispAdj()
   {int i,j;
     for(i=0;i<n;i++)
      {System.out.println();
        for(j=0;j<n;j++) System.out.printf("%5d",a[i][j]);
      }
   
   }
 void visit(int i) {System.out.print(v[i] + "  ");}
 boolean isDirected()
   {int i,j;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
        if(a[i][j] != a[j][i]) return(true);
     return(false);
   }
 int deg(int i)
   {int s,j;
     s=0;
     for(j=0;j<n;j++) s += a[i][j];
     if(a[i][i]>0) s += a[i][i];
     return(s);
   }
 boolean isConnected()
  {MyStack s = new MyStack();
    boolean [] p = new boolean[n];
    int i,j,r;
    for(i=0;i<n;i++) p[i]=false;
    s.push(0);p[0]=true;
    while(!s.isEmpty())
      {r = s.pop();
       for(i=0;i<n;i++)
          if(!p[i] && a[r][i]>0) {s.push(i); p[i]=true;}
      }
    for(i=0;i<n;i++) if(!p[i]) return(false);
    return(true);
  }
 boolean has2OddDegree()
  {int i,k;
    k=0;
   for(i=0;i<n;i++)
       if(deg(i) %2 !=0) k++;
    return(k==2);
  }  
boolean hasIsolatedVertex()
 {for(int i=0;i<n;i++) 
    if(deg(i)==0) return(true);
   return(false);
 }
EulerPath findEulerPath()
 {if(isDirected() || !isConnected() || !has2OddDegree() || hasIsolatedVertex())
     {System.out.println(" The conditions for Euler Path are not satisfied");
      return(null);
     }
   MyStack s = new MyStack();
   int [][] b = new int[n][n];
   int i,j,r,k;
   k=0;
   while(deg(k) %2==0) k++;
   if(k==n) return(null);
   for(i=0;i<n;i++)
     for(j=0;j<n;j++) b[i][j]=a[i][j];
   EulerPath t = new EulerPath();
   s.push(k);
   while(!s.isEmpty())
     {r = s.top();
       i=0;
       while(i<n && a[r][i]==0) i++;
       if(i==n) // The vertex r is now isolated
         {r = s.pop();
           t.add(r);
         }
         else
          {s.push(i); a[r][i]--; a[i][r]--;
          }
     }
  setData(b);
  return(t);  
 }

}
public class Main
 {public static void main(String [] args)
   {int [][] b = {
      {0,1,0,1,0},
      {1,0,2,0,2},
      {0,2,0,1,2},
      {1,0,1,0,0},
      {0,2,2,0,0}
     };
     Graph g = new Graph();
     g.setData(b);

     System.out.println("\n1. Display adjacency matrix:");  
     g.dispAdj();

     System.out.println("\n2. Test finding Euler Path:");  
     EulerPath t;
     t = g.findEulerPath();
     if(t==null)
      System.out.println("There is no Euler path");
       else
        t.display();
     System.out.println();  
   }
 }
