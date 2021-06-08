import java.io.*;
import java.util.*;
class MyStack
 {LinkedList a;
  MyStack() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void push(Object x)
   {a.add(x);
   }
  Object pop()
   {if(isEmpty()) return(null);
    return(a.removeLast());
   }
  Object viewTop()
   {if(isEmpty()) return(null);
    return(a.getLast());
   }
 }
class HamiltonPath
 {int [] path; int m;
  HamiltonPath()
   {path = new int[50];
    m = 0;
   }
 }
class Graph
 {int [][] a; int n;
  char [] v;//Vertices label
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s1.toCharArray();
   }
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
   }
  //---------------------------------------------------------
  void displayData()
   {int i,j;
    System.out.println("\n The adjacency matrix of the graph:");
    System.out.println(" ==================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) 
         System.out.printf(" %3d",a[i][j]);
      }
    System.out.println();
   }
  //---------------------------------------------------------
  void displayPath(HamiltonPath c)
   {for(int i=0;i<=c.m;i++)
    System.out.print(" " + (c.path[i]+1));
    //System.out.print(" " + v[c.path[i]]);
    System.out.println("\n");
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
   {int i, h;
    boolean [] visited = new boolean[20];
    boolean [] pushed = new boolean[20];
    for(i=0;i<n;i++) {visited[i] = false; pushed[i]=false;}
    MyStack t = new MyStack();
    t.push(new Integer(0));pushed[0] = true;
    System.out.println();
    while(!t.isEmpty())
     {h = ((Integer) t.pop()).intValue(); visited[h] = true;
      for(i = n-1;i>=0; i--)
        if(a[h][i]>0 && !pushed[i]) {t.push(i);pushed[i]=true;}
     }
    for(i=0;i<n;i++) if(!visited[i]) return(false);
    return(true);
   }
  //=======================================================
  //Tim dinh thu i cua duong di Hamilton khi da den dinh i-1
  // i = 0, 1, 2,...,n c[0] (i = 0) la dinh khoi dau
  void hamiltonPath(HamiltonPath c, boolean visited[],int i)
   {int j;
    for(j=0;j<n;j++)
     if(a[c.path[i-1]][j]>0 && !visited[j]) // Co duong di tu i-1 den j
      {c.path[i]=j;c.m++;visited[j]=true;// Chon dinh j va danh dau la da xet roi
       if(i<n-1) // Con thieu dinh, chua the la duong di Hamilton
          hamiltonPath(c,visited,i+1);//chon dinh i+1 tiep theo
         else
         displayPath(c); 
       visited[j]=false;//Quay lui va dat lai trang thai visited[j] truoc do bang false.
       c.m--;
      }
   }
  //-------------------------------------------
  void hamiltonPath(int k)
   {if(!isUndirected() || !isConnected())
      {System.out.println(" The conditions are not satisfied");
       return;
      }
    HamiltonPath c = new HamiltonPath(); boolean [] visited = new boolean[20];
    int i;
    c.path[0] = k;// Chu trinh xuat phat tu dinh k
    for(i=0;i<n;i++) visited[i] = false; // Luc dau tat ca cac dinh deu chua xet,
                                         // tru dinh k 
    visited[k] = true;
    c.path[0] = k; // Liet ke tat ca cac duong di xuat phat tu dinh k
    System.out.println("\n Hamilton paths of the above graph:");
    hamiltonPath(c,visited,1);
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    g.hamiltonPath(0);
    System.out.println();
   }
 }

