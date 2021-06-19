class Graph
 {int [][] a; int n;
  char [] v;
  Graph() 
   {a=null; n=0;
    v = "ABCDEFGHIJKLMN".toCharArray();
   }
  void clear() {a=null; n=0;}
  void setData(int [][] b)
   {n=b.length;
    a = new int[n][n];
    for(int i=0;i<n;i++)
     for(int j=0;j<n;j++)
         a[i][j]=b[i][j];
   }
  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }
  void visit(int i) {System.out.print(" " + v[i]);}
  void depthFirst(boolean [] visited, int i)
   {visit(i);visited[i]=true;
    int j;
    for(j=0;j<n;j++)
      if(!visited[j] && a[i][j]>0) depthFirst(visited, j);
   } 
  void depthFirst(int i)
   {boolean [] visited = new boolean[n];
    for(int j=0;j<n;j++) visited[j]=false;
    System.out.println("\n Depth first traverse from the vertex " + i);
    depthFirst(visited, i);
   }

 }

class Main 
 {public static void main(String [] args)
   {int [][]b = {
                 {0,1,1,1,0},
                 {1,0,1,0,0},
                 {1,1,0,0,1},
                 {1,0,0,0,0},
                 {0,0,1,0,0}
                };
    Graph g =new Graph();
    g.setData(b);
    g.dispAdj();
    g.depthFirst(0);
    System.out.println();
   }
  }
