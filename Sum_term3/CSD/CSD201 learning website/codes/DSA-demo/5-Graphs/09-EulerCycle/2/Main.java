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

class EulerCycle
 {int [] cyc; int m;
  EulerCycle()
   {cyc = new int[50];
    m = 0;
   }
 }
class Graph
 {int [][] a; int n;
  char [] v;//Vertices label
  //---------------------------------------------------------
  Graph()
   {String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s1.toCharArray();
   }
  //---------------------------------------------------------
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
  void display(EulerCycle c)
   {for(int i=0;i<c.m;i++)
    System.out.print(" " + v[c.cyc[i]]);
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
  //---------------------------------------------------------
  boolean isEvenDegree()
   {int i,j,deg;
    for(i=0;i<n;i++)
     {deg=0;
      for(j=0;j<n;j++)
       deg+=a[i][j];
      if(deg%2==1) return(false);
     }
    return(true);
   }
  //=======================================================
  //Chu trinh Euler xuat phat tu dinh k
  boolean EulerCycle(EulerCycle c,int k)
   {if((!isUndirected()) || (!isConnected()) || (!isEvenDegree()))
      {c.m = 0;
       return(false);
      }
    MyStack t = new MyStack();int [][] b = new int[20][20];int i,j,h;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) b[i][j]=a[i][j];
    t.push(new Integer(k));//Dua dinh k vao Stack
    j=-1;//Ban dau chu trinh chua co phan tu nao
    while(!t.isEmpty())
      {h = ((Integer) t.viewTop()).intValue();i=0;
       while(i<n && a[h][i]==0) i++;//Tim i dau tien de a[h][i]#0
       if(i==n) //h da la dinh co lap, dua h vao chu trinh c
         {j++;c.cyc[j]=h;t.pop();}//Lay dinh co lap ra khoi Stack
         else
          {t.push(new Integer(i));a[h][i]--;a[i][h]--;}//Loai canh (i,h) khoi do thi
      }
    c.m = j+1;
    // Gan lai ma tran ke
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) a[i][j] = b[i][j];
    return(true);
   }
  //---------------------------------------------------------
  void EulerCycle(int k)
   {EulerCycle c = new EulerCycle();
    boolean b = EulerCycle(c,k);
    if(b)
      {System.out.print("\n The Euler cycle is:\n");
       display(c);
      }
       else
        System.out.print("\n Conditions are not satisfied\n");
   }

 }

class Main 
 {public static void main(String [] args) throws Exception
   {String filename;
    filename="matrix.txt";
    Graph g =new Graph();
    g.setData(filename);
    g.displayData();
    g.EulerCycle(1);
    System.out.println();
   }
 }

