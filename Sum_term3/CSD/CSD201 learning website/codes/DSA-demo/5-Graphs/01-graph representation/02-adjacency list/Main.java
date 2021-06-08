import java.io.*;
import java.util.*;
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
  void writeToFile(RandomAccessFile f) throws IOException
   {f.writeBytes((u+1) + ", " + (v+1) + ", " + weight + "\n");
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
  //----------------------------------------
  void setAdjMatrix(String fname) throws IOException
   {int i,j;
    String s="", u="";
    StringTokenizer t;
    RandomAccessFile f; 
    f = new RandomAccessFile(fname, "r");
    s = f.readLine();
    n = Integer.parseInt(s.trim());
    a = new int[n][n];
    for(i=0;i<n;i++)
     {s = f.readLine();
      t = new StringTokenizer(s);
      for(j=0;j<n;j++)
       {u = t.nextToken();
        a[i][j]=Integer.parseInt(u.trim());
       }
     }
    f.close();
    createAdjList();
   }
  //----------------------------------------
  // n la so dinh, >= chi so cao nhat trong cac canh
  void setAdjList(String fname) throws IOException
   {int i,j, u, v, w;
    String s="", z = "";
    StringTokenizer t;
    RandomAccessFile f; 
    f = new RandomAccessFile(fname, "r");
    s = f.readLine();
    m = Integer.parseInt(s.trim());
    b = new Edge[m];
    for(i=0;i<m;i++)
     {s = f.readLine();
      s = s.trim();
      t = new StringTokenizer(s,",");
      z = t.nextToken();
      u = Integer.parseInt(z.trim());
      z = t.nextToken();
      v = Integer.parseInt(z.trim());
      z = t.nextToken();
      w = Integer.parseInt(z.trim());
      b[i] = new Edge(u-1,v-1,w);
     }

    f.close();
    createAdjMatrix();
   }
  //----------------------------------------
  void createAdjList()
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
  void createAdjMatrix()
   {int i, j, k;
    k=0;
    for(i=0;i<m;i++)
     {k = (b[i].u>k?b[i].u:k);
      k = (b[i].v>k?b[i].v:k);
     }
    n = k+1;
    a = new int[n][n];
    for(i=0;i<n;i++)
     for(j=i;j<n;j++) a[i][j] = 0;
    for(i=0;i<m;i++) a[b[i].u][b[i].v] = b[i].weight;
    for(i=0;i<n;i++)
     for(j=0;j<i;j++) a[i][j] = a[j][i];
   }
  //----------------------------------------
  void displayAdjacency() throws Exception
   {if(n==0) setAdjMatrix("matrix.txt");
    if(n==0) return;
    int i,j;
    System.out.println("\n The wighted matrix of the graph:");
    System.out.println(" ===============================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
   }
  //----------------------------------------
  void displayAdjList() throws Exception
   {if(n==0) setAdjMatrix("matrix.txt");
    if(m==0) setAdjList("AdjList.txt");
    if(m==0) return;
    int i;
    System.out.println(" Number of edges m = " + m);
    for(i=0;i<m;i++) b[i].display();
    System.out.println();
   }
  //----------------------------------------
  void sortAdjList()
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
  //----------------------------------------
  void writeAdjMatrixToFile(String fname) throws IOException
   {if(n==0) setAdjMatrix("matrix.txt");
    int i,j;
    if(n==0) return;
    Formatter out = new Formatter(new File(fname));
    // Write to file with format() (similar to printf())
    out.format("%d\n",n);
    for(i=0;i<n;i++)
      {for(j=0;j<n;j++)
       out.format("%4d",a[i][j]);
       out.format("\n");
      }
    out.close();  
   }
  //----------------------------------------
  void writeAdjListToFile(String fname) throws IOException
   {if(m==0) setAdjList("AdjList.txt");
    int i;
    if(m==0) return;
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    f.writeBytes(m + "\n");
    for(i=0;i<m;i++) b[i].writeToFile(f);
    f.close();
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
       System.out.println("  3. Read adjacency list from file");
       System.out.println("  4. Display adjacency matrix & adjacency list");
       System.out.println("  5. Write adjacency matrix to file");
       System.out.println("  6. Write adjacency list to file");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 6): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1:  g.setAdjMatrix("matrix.txt");
                  break;
         case 2:  g.displayAdjacency();
                  break;
         case 3:  g.setAdjList("AdjList.txt");
                  break;
         case 4:  g.displayAdjacency();
                  g.displayAdjList();
                  break;
         case 5:  g.writeAdjMatrixToFile("matrix2.txt");
                  break;
         case 6:  g.writeAdjListToFile("AdjList2.txt");
                  break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
       System.out.println();
      }
   }
 }

