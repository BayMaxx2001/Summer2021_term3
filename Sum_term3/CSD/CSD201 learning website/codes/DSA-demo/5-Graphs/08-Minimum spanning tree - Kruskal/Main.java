import java.io.*;
import java.util.*;
class MyQueue
 {LinkedList<Integer> t;
  MyQueue() {t=new LinkedList<Integer>();}
  void clear() {t.clear();}
  boolean isEmpty() {return(t.isEmpty());}
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
//=========================
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
//==========================================
class Graph
 {int [][] a; int n;
  char [] v;//Vertices label
  Edge [] b; int m;
  //----------------------------------------
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s1.toCharArray();
    n = m = 0;
   }
  void setBlank(int k)
    {n=k;
     a = new int[n][n];
     int i,j;
     for(i=0;i<n;i++)
       for(j=0;j<n;j++) a[i][j]=0;
    }
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
    createEdgeList();
   }
  //----------------------------------------
  void setFromArray(int [][] c, int k)
   {int i, j;
    n=k;
    a = new int[n][n];
    for(i=0;i<n;i++)
     for(j=0;j<n;j++) a[i][j] = c[i][j];
    createEdgeList();
   }
  //----------------------------------------
  void dispAdj() throws Exception
   {if(n==0) setData("matrix.txt");
    if(n==0) return;
    int i,j;
    System.out.println("\n The weighted matrix of the graph:");
    System.out.println(" ================================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
   }
  //----------------------------------------
  void displayMatrix(int [][] u, int h) throws Exception
   {int i,j;
    for(i=0;i<h;i++)
      {System.out.println();
       for(j=0;j<h;j++) System.out.printf("%4d",u[i][j]);
      }
    System.out.println();
   }
  //----------------------------------------
  void createEdgeList()
   {int i,j,k;
    k = 0;
    for(i=0;i<n;i++)
     for(j=i;j<n;j++)
      if(a[i][j]>0) k++;
    m = k;
    b = new Edge[m];
    k=0;
    for(i=0;i<n;i++)
     for(j=i;j<n;j++)
      if(a[i][j]>0)
        b[k++] = new Edge(i,j,a[i][j]);
   }
  //----------------------------------------
  void displayEdgeList() throws Exception
   {if(n==0) setData("matrix.txt");
    if(m==0) createEdgeList();
    if(m==0) return;
    int i;
    System.out.println(" Number of edges m = " + m);
    for(i=0;i<m;i++) b[i].display();
    System.out.println();
   }
  //----------------------------------------
  void sortEdgeList()
   {int i, j, k;
    int min;
    Edge t;
    for(i=0;i<m-1;i++)
     {min = b[i].weight; k = i;
      for(j=i+1;j<m;j++)
        if(b[j].weight<min) {k=j;min= b[j].weight;}
      if(k!=i) {t=b[i];b[i]=b[k];b[k]=t;}
     }
   }
  //=========================================================
  boolean isUndirected() // The adjacency matrix is symmetric
   {int i,j;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
      if(a[i][j]!=a[j][i]) return(false);
    return(true);
   }
  //---------------------------------------------------------
  boolean isConnected()
   {MyStack s = new MyStack();
    boolean [] p = new boolean[n];
    int i, k;
    for(i=0;i<n;i++) p[i]=false;
    s.push(0); p[0]=true;
    while(!s.isEmpty())
      {k=s.pop();
       for(i=0;i<n;i++)
         if(!p[i] && a[k][i]>0) {s.push(i); p[i]=true;}
      }
    for(i=0;i<n;i++) if(!p[i]) return(false);
    return(true); 
   }
  //=========================================================
  boolean hasPath(int fro, int to)
   {MyStack s=new MyStack();
    boolean [] p=new boolean[n];
    int i,k;
    for(i=0;i<n;i++) p[i]=false;
    s.push(fro);
    p[fro]=true;
    while(!s.isEmpty())
      {k=s.pop();
       for(i=0;i<n;i++)
         if(!p[i] && a[k][i]>0) {s.push(i); p[i]=true;}
      }
     if(p[to])
        return(true);
          else
           return(false);
   }

  //=========================================================
  Graph kruskal() throws Exception
   {if(!isUndirected() || !isConnected())
      {System.out.println(" The conditions are not satisfied");
       return(null);
      }
    sortEdgeList();
    Graph t = new Graph();
    t.setBlank(n);
    int i = 0;
    t.a[b[0].u][b[0].v] = a[b[0].u][b[0].v];
    t.a[b[0].v][b[0].u] = a[b[0].v][b[0].u];
    while(true)
     {i++;
      if(!t.hasPath(b[i].u,b[i].v))
          {t.a[b[i].u][b[i].v] = a[b[i].u][b[i].v];
            t.a[b[i].v][b[i].u] = a[b[i].v][b[i].u];
          }
      if(i==n-1) break;
     }
    t.createEdgeList();
    return(t);
   }
  //----------------------------------------
  void displayTree() throws Exception
   {Graph t = kruskal();
    int i;
    System.out.println(" Edges in a minimum spanning tree:");
    int sum=0;
    t.sortEdgeList();
    for(i=0;i<t.m;i++)
     {t.b[i].display();
      sum += t.b[i].weight;
     }
    System.out.println(" Total weight: " + sum);
   }
 }
//===========================================
public class Main
 {public static void main(String args[]) throws Exception
   {Scanner s = new Scanner(System.in);
    int choice;
    Graph g =new Graph();
    while(true)
      {System.out.println("\n Choose your option:");
       System.out.println("  1. Read adjacency matrix from file");
       System.out.println("  2. Display adjacency matrix");
       System.out.println("  3. Create list of edges");
       System.out.println("  4. Display adjacency matrix & list of edges");
       System.out.println("  5. Display a minimum spanning tree ");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 5): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1:  g.setData("matrix.txt");
                  break;
         case 2:  g.dispAdj();
                  break;
         case 3:  g.createEdgeList();
                  break;
         case 4:  g.dispAdj();
                  g.displayEdgeList();
                  break;
         case 5:  g.setData("matrix.txt");
                  g.dispAdj();
                  g.displayEdgeList();
                  g.displayTree();
                  break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
       System.out.println();
      }
   }
 }

