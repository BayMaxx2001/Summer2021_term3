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
  void displayWeights()
   {int i,j;
    System.out.println("\n The weighted matrix of the graph:");
    System.out.println(" ================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
   }
  void displayStep(int [] dist, int [] path, int k)
   {int i;
    System.out.print("\n " + v[k] + ":");
    for(i=0;i<n;i++) System.out.print(" (" + dist[i] + "," + v[path[i]] + ")");
   } 

  // shortest path from vertex p to vertex q
  void dijkstra(int [] dist, int [] path,int p, int q) 
   {int i,j,t,k,curr,step;// curr: current vertex, which is to be added to the S set
    boolean [] visited = new boolean[n];
    //Khoi tao
    for(i=0;i<n;i++) 
     {visited[i]=false;
      dist[i]=a[p][i]; // At the first step distance is a direct distance  
      path[i]=p;       // and the vertex before vertex i is the vertex  p
     }

    System.out.println("   ");
    for(i=0;i<n;i++) System.out.print("      " + v[i]);
    k=p;// k is selected to the set S
    displayStep(dist,path,k);

    visited[p]=true;curr=p;// add the vertex p the the S set
    while(curr!=q)//Thuc hien vong lap cho den khi gap nut q
     {t=VOCUNG;k=-1;
      for(i=0;i<n;i++)
       {if(i==p || visited[i]) continue;
        //Tim dinh gan nhat de dua vao S = tap da xet)
        if(dist[i]<t) {t=dist[i];k=i;}
       }

      if(t==VOCUNG) {System.out.println("\nKhong co duong di");return;}
      //Dua  dinh k vao tap S da xet
      visited[k]=true;curr=k;
      //Tinh lai khoang cach
      for(i=0;i<n;i++)
       {if(i==p || visited[i]) continue;
        if(dist[i]>dist[k]+a[k][i])
	  {dist[i]=dist[k]+a[k][i];
           path[i]=k;
          }
       }
      displayStep(dist,path,k);
     }
   }
  void pathDijkstra(int [] dist, int [] path,int p, int q)
   {MyStack s = new MyStack() ;int i;
    System.out.println("\n\n The length of shortest path from " + (p+1) + " to  " + (q+1) + " is  " + dist[q]);
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

  void dijkstra(int p, int q)
   {int [] dist = new int[n];
    int [] path = new int[n];
    dijkstra(dist,path,p,q);
    pathDijkstra(dist,path,p,q);
   } 
 }

class Main 
 {public static void main(String [] args)
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    try {g.setWeights(filename);} catch(IOException e) {}
    g.displayWeights();
    g.dijkstra(0,5); // Duong di ngan nhat tu dinh 1 den dinh 6
    System.out.print("\n ");
   }
 }
