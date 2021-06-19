import java.io.*;
import java.util.*;
class SimpleCycle
 {int [] cyc; int m;
  SimpleCycle()
   {cyc = new int[50];
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
  void displayCycle(SimpleCycle c)
   {for(int i=0;i<=c.m;i++)
    System.out.print(" " + (c.cyc[i]+1));
    //System.out.print(" " + v[c.cyc[i]]);
    System.out.println("\n");
   }
  //=========================================================
  //Tim dinh thu i cua chu trinh khi da den dinh i-1
  // i = 0, 1, 2,...,n c[0] (i = 0) la dinh khoi dau
  void simpleCycle(SimpleCycle c, boolean visited[],int i)
   {int j;
    for(j=0;j<n;j++)
     if(a[c.cyc[i-1]][j]>0 && !visited[j]) // Co duong di tu i-1 den j
      {c.cyc[i]=j;c.m++;visited[j]=true;// Chon dinh j va danh dau la da xet roi
       if(c.cyc[i] == c.cyc[0]) //Co chu trinh 
         {if(c.m>2)
           {hasCycle = true;
            return;
           }
         }
         else if(i<n ) // Con thieu dinh, chua the la chu trinh
          simpleCycle(c,visited,i+1);// chon dinh i+1 tiep theo
       visited[j]=false;//Quay lui va dat lai trang thai visited[j] truoc do bang false.
       c.m--;
      }
   }
  //-------------------------------------------
  boolean hasCycle;
  boolean hasSimpleCycle(int k)
   {SimpleCycle c = new SimpleCycle(); boolean [] visited = new boolean[20];
    int i;
    c.cyc[0] = k;// Chu trinh xuat phat tu dinh k
    for(i=0;i<n;i++) visited[i] = false; // Luc dau tat ca cac dinh deu chua xet, ke ca k,
                                         // vi k phai xuat hien 2 lan 
    hasCycle = false;
    c.cyc[0] = k; // Liet ke tat ca cac chu trinh xuat phat tu dinh k
    simpleCycle(c,visited,1);
    return(hasCycle);
   }
 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    boolean t = g.hasSimpleCycle(0);
    if(t)
     System.out.println(" There is a simple cycle in a graph");
      else
       System.out.println(" There is no simple cycle in a graph");
   }
 }

