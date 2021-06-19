import java.io.*;
import java.util.*;
class Vertex
 {int u,degree,color;
  char [] lbl;//Vertices label
  Vertex()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    lbl = s1.toCharArray();
   }
  void displayIndex()
   {System.out.printf(" %3d %7d %6d\n",u+1,degree,color); 
   }
  void displayLabel()
   {System.out.printf(" %3c %7d %6d\n",lbl[u],degree,color); 
   }
 }
//==========================================
class Graph
 {int [][] a; int n;
  char [] lbl;//Vertices label
  Vertex [] b;
  //----------------------------------------
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    lbl = s1.toCharArray();
    n = 0;
   }
  //----------------------------------------
  void setData(String filename) throws IOException
   {int i,j,k;
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
    b = new Vertex[n];
    for(i=0;i<n;i++) 
      {b[i] = new Vertex();
       b[i].u=i;
       b[i].color=-1;
       k=0;
       for(j=0;j<n;j++) k += a[i][j];
       b[i].degree=k;       
      }
   }
  //----------------------------------------
  void display() throws Exception
   {if(n==0) setData("matrix.txt");
    if(n==0) return;
    int i,j;
    System.out.println("\n The adjacency matrix of the graph:");
    System.out.println(" =================================");
    for(i=0;i<n;i++)
      {System.out.println();
       for(j=0;j<n;j++) System.out.printf("%4d",a[i][j]);
      }
    System.out.println();
    System.out.println("\n vertex  degree  color");
    System.out.println(" ====================");
    for(i=0;i<n;i++) b[i].displayIndex();
    System.out.println();
   }
  //-----------------------------------
  void sortVertexBydegree()
   {int i; boolean swapped;
    Vertex t;
    do
     {swapped=false;
      for(i=0;i<n-1;i++)
        if(b[i].degree<b[i+1].degree)
          {t=b[i];b[i]=b[i+1];b[i+1]=t;
           swapped=true;
          }
     }
    while(swapped);
   }
  //-----------------------------------
  void sortVertexByIndex()
   {int i; boolean swapped;
    Vertex t;
    do
     {swapped=false;
      for(i=0;i<n-1;i++)
        if(b[i].u>b[i+1].u)
          {t=b[i];b[i]=b[i+1];b[i+1]=t;
           swapped=true;
          }
     }
    while(swapped);
   }
  //-----------------------------------
  boolean isAdjacent(int i, int j)
   {if(a[i][j]>0)
      return(true);
       else
        return(false);
   }
  //===================================
  void sequentialColoring()
   {int i, j, k, maxColor;
    b[0].color = 1;
    maxColor=1;
    boolean ok=true;     
    for(i=1;i<n;i++)
     {//find in used colors
      for(j=1;j<=maxColor;j++)
       {ok=true;
        for(k=0;k<i;k++)
          if(isAdjacent(b[i].u,b[k].u) && b[k].color==j)
            {ok=false;break;
            }
        if(ok) {b[i].color = j;break;}
       }
      if(!ok) {maxColor++;b[i].color = maxColor;} 
     }
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
       System.out.println("  3. Sequential coloring on unsorted vertices");
       System.out.println("  4. Largest First Sequential coloring");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 4): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1:  g.setData("matrix.txt");
                  break;
         case 2:  g.setData("matrix.txt");
                  g.display();
                  break;
         case 3:  g.setData("matrix.txt");
                  g.sortVertexByIndex();
                  g.sequentialColoring(); 
                  g.display();
                  break;
         case 4:  g.setData("matrix.txt");
                  g.sortVertexBydegree();
                  g.sequentialColoring(); 
                  g.display();
                  break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
       System.out.println();
      }
   }
 }

