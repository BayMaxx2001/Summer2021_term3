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

class Graph
 {int [][] a; int n;
  char [] v;
  int [][] p; int [][] d;
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
   }
  //----------------------------------------
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
  void displayStep()
   {int i, j;
    System.out.print("\n    " + v[0]);
    for(i=1;i<n;i++) System.out.print("       " + v[i]);
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++) 
        if(p[i][j]==-1)
         System.out.printf(" (%2d,-1)",d[i][j]);
          else
           System.out.printf(" (%2d, %c)",d[i][j],v[p[i][j]]);
     }
   } 

  //----------------------------------------
  //Floyd's algorithm for shortest path
  void floyd() 
   {int i,j,k;
    d = new int[n][n];
    p = new int[n][n];
    
    //Khoi tao
    for(i=0;i<n;i++)
     for(j=0;j<n;j++) 
      {d[i][j]=a[i][j]; // At the first step distance is a direct distance  
       if(a[i][j]==VOCUNG)
         p[i][j]=-1;
          else
           p[i][j] = i;   //  the vertex before vertex j is the vertex  i
      }

    System.out.print("\n\n The start situaton:");
    displayStep();
    String s = "Included vertices: ";

    //Tinh lai khoang cach
    for(k=0;k<n;k++)
     {for(i=0;i<n;i++)
       for(j=0;j<n;j++)
       {if(d[i][j] > d[i][k]+d[k][j] && i!=k && j!=k)
	  {d[i][j] = d[i][k]+d[k][j];
           p[i][j] = p[k][j];
          }
       }
      if(k==0)
       s += v[k];
       else
        s += ", " + v[k];
      System.out.print("\n\n " + s);
      displayStep();
     }
   }

  //----------------------------------------
  //shortest path from vertex k to vertex h
  void floyd(int k, int h) 
   {floyd();
    MyStack s = new MyStack() ;int i,j,r;
    System.out.println("\n\n The length of shortest path from " + v[k] + " to  " + v[h] + " is  " + d[k][h]);
    System.out.println("\n Path:");
    i=k;
    j=h;
    s.push(j);
    do
     {j=p[k][j];
      s.push(j);
     }
    while(j!=k);

    System.out.print(" ");
    while(!s.isEmpty())
     {i= s.pop();
      System.out.print(v[i]);
      if(i!=h) System.out.print(" -> ");
     }
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    try {g.setWeights(filename);} catch(IOException e) {}
    g.displayWeights();
    g.floyd(0,5); // Duong di ngan nhat tu dinh 1 den dinh 6
    System.out.print("\n ");
   }
 }
