import java.io.*;
import java.util.*;
class MyStack
 {LinkedList a;
  MyStack() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void push(int x)
   {a.add(new Integer(x));
   }
  int pop()
   {return((Integer) a.removeLast());
   }
 }
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
   {System.out.println(" ("+ (char) (u+65) + ", " + (char) (v+65) + ", " + weight + ")");
   }
 }

class Graph
 {int [][] a; int n;
  char [] v;
  Edge [] b; int m;
  static int VOCUNG = 99; // 99 is considered as infinite value
  Graph() {v = "ABCDEFGHIJKLM".toCharArray();}
  void setWeights(String filename) throws IOException
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
    createAdjList();
   }
  void createAdjList()
   {int i,j,k;
    k = 0;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
      if(a[i][j]!=0 && a[i][j]!=VOCUNG) k++;
    m = k;
    b = new Edge[m];
    k=0;
    for(i=0;i<n;i++)
     for(j=0;j<n;j++)
      if(a[i][j]!=0 && a[i][j]!=VOCUNG)
        b[k++] = new Edge(i,j,a[i][j]);
   }
  void displayWeights()
   {int i,j;
    System.out.println("\n The weighted matrix of the graph:");
    System.out.print(" ================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
   }
  //----------------------------------------
  void displayAdjList() throws Exception
   {if(n==0) setWeights("matrix.txt");
    if(m==0) createAdjList();
    if(m==0) return;
    int i;
    System.out.println("\n Number of edges m = " + m);
    for(i=0;i<m;i++) b[i].display();
    System.out.println();
   }
  //----------------------------------------
  void displayStep(int [] dist, int [] path, int k)
   {int i;
    System.out.print("\n " + k + ":");
    for(i=0;i<n;i++) System.out.print(" (" + dist[i] + "," + v[path[i]] + ")");
   } 

  //shortest path from vertex p to vertex q
  void bellman(int [] dist, int [] path,int p, int q) 
   {int i,j,k;
    //Khoi tao
    for(i=0;i<n;i++) 
     {dist[i]=a[p][i]; // At the first step distance is a direct distance  
      path[i]=p;       // and the vertex before vertex i is the vertex  p
     }
    System.out.println("\n Bellman-Ford algorithm for finding shortest path:");
    System.out.print(" (Applicable for a graph without negative-weight cycle)");
    System.out.println("   ");
    for(i=0;i<n;i++) System.out.print("      " + v[i]);
    displayStep(dist,path,p);

    //Tinh lai khoang cach
    for(k=0;k<n;k++)
     {if(k==p) continue;
      for(i=0;i<m;i++)
       {if(i==p) continue;
        if(dist[b[i].v]>dist[b[i].u]+b[i].weight)
	  {dist[b[i].v]=dist[b[i].u]+b[i].weight;
           path[b[i].v]=b[i].u;
          }
       }
      displayStep(dist,path,k);
     }
   }
  void pathBellman(int [] dist, int [] path,int p, int q)
   {MyStack s = new MyStack() ;int i;
    System.out.println("\n\n The length of shortest path from " + v[p] + " to  " + v[q] + " is  " + dist[q]);
    System.out.println("\n Path:");
    i=q;
    s.push(i);
    do
     {i=path[i];
      s.push(i);
     }
    while(i!=p);

    System.out.print(" ");
    while(!s.isEmpty())
     {i= s.pop();
      System.out.print(v[i]);
      if(i!=q) System.out.print(" -> ");
     }
   }

  void bellman(int p, int q)
   {int [] dist = new int[n];
    int [] path = new int[n];
    bellman(dist,path,p,q);
    pathBellman(dist,path,p,q);
   } 
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    try {g.setWeights(filename);} catch(IOException e) {}
    g.displayWeights();
    g.displayAdjList();
    g.bellman(0,5); // Duong di ngan nhat tu dinh 1 den dinh 6
    System.out.print("\n ");
   }
 }
