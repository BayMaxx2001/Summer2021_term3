import java.util.*;
class MyQueue
 {LinkedList g;
  MyQueue() {g = new LinkedList();}
  void clear() {g.clear();}
  boolean isEmpty() {return(g.isEmpty());}
  void enqueue(int x)
   {g.add(new Integer(x));
   }
  int dequeue() {return(((Integer) g.removeFirst()).intValue());}
 }
class MyStack
 {LinkedList g;
  MyStack() {g = new LinkedList();}
  void clear() {g.clear();}
  boolean isEmpty() {return(g.isEmpty());}
  void push(int x)
   {g.add(new Integer(x));
   }
  int pop() {return(((Integer) g.removeLast()).intValue());}
 }
class Graph
 {int [][] a; int n;
  char [] v;
  Graph()
   {String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    v = s.toCharArray();
   }
  void setData(int [][] b)
   {n=b.length;int i,j;
    a = new int[n][n];
    for(i=0;i<n;i++)
     for(j=0;j<n;j++) a[i][j] = b[i][j];
   }
  void displayAdj()
   {int i,j;
    System.out.println("\n The adjacency matrix of the graph:");
    System.out.println(" =================================");
    for(i=0;i<n;i++)
      {System.out.println("\n");
       for(j=0;j<n;j++) 
         System.out.printf(" %3d",a[i][j]);
      }
    System.out.println();
   }
  void visit(int i)
   {System.out.print(" " + v[i]);
   }

  void depthFirst(boolean visited[], int i)
   {visit(i);visited[i] = true; 
    int j;
    for(j=0;j<n;j++)
        if(a[i][j]>0 && (!visited[j]))
           depthFirst(visited,j);
     
   }
  void depthFirst(int k)
   {int i,h; boolean [] visited = new boolean[20];
    for(i=0;i<n;i++) visited[i]=false;
    System.out.println(" The connected part 1:");
    depthFirst(visited,k);
    h=2;
    for(i=0;i<n;i++) 
     if(!visited[i]) 
       {System.out.println("\n The connected part " + h + ": ");
        h++;
        depthFirst(visited,i);
       }
    System.out.println();
   }
  void depthFirstS(boolean [] visited, int k) // depth first traverse from vertex k  
   {MyStack s = new MyStack();int i,h;
    boolean [] pushed = new boolean[n];
    for(i=0;i<n;i++) if(!visited[i]) pushed[i]=false;
    s.push(k);pushed[k]=true;
    System.out.println("\n Depth first traverse from vertex " + v[k] +":");
    System.out.println(" ===================================\n");
    while(!s.isEmpty())
     {h=s.pop();visit(h);visited[h]=true;
      for(i=n-1;i>=0;i--)
	 if((a[h][i]>0 && !visited[i] && !pushed[i]))
           {s.push(i);
            pushed[i] = true;
           }
     }
    System.out.println();
   }
  void depthFirstS(int k) // depth first traverse from vertex k  
   {boolean [] visited;
    visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depthFirst(visited,k);
    i=0;
    while(i<n)
     {if(!visited[i] && i<n) depthFirst(visited,i);
      i++;
     }
   } 
  void breadthTraverse(boolean [] visited, int k) // bread first traverse from vertex k  
   {MyQueue q = new MyQueue();int i,h;
    boolean [] displayed = new boolean[n];
    for(i=0;i<n;i++) displayed[i]=false;
    q.enqueue(k);visited[k]=true;
    System.out.println("\n Breadth first traverse from vertex " + (k+1) +":");
    System.out.println(" =====================================\n");
    while(!q.isEmpty())
     {h=q.dequeue();visited[h]=true;
      if(!displayed[h])
	{visit(h);displayed[h]=true;}
      for(i=0;i<n;i++)
	 if((!visited[i] || !displayed[h]) && a[h][i]>0) q.enqueue(i);
     }
    System.out.println();
   }
  void breadthTraverse(int k) // breadth first traverse from vertex k  
   {boolean [] visited;
    visited = new boolean[n];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    breadthTraverse(visited,k);
    i=0;
    while(i<n)
     {if(!visited[i] && i<n) breadthTraverse(visited,i);
      i++;
     }
   }

 }
class Main 
 {public static void main(String [] args)
   {int [][]b = {
{0,  1,  0,  0,  1,  0,  0,  0,  0},
{1,  0,  0,  1,  1,  0,  0,  0,  0},
{0,  0,  0,  1,  0,  0,  0,  0,  0},
{0,  1,  1,  0,  0,  0,  0,  0,  0},
{1,  1,  0,  0,  0,  0,  0,  0,  0},
{0,  0,  0,  0,  0,  0,  1,  1,  1},
{0,  0,  0,  0,  0,  1,  0,  1,  0},
{0,  0,  0,  0,  0,  1,  1,  0,  0},
{0,  0,  0,  0,  0,  1,  0,  0,  0} 
                };
    Graph g =new Graph();
    g.setData(b);
    g.displayAdj();
    System.out.println(" Depth first traverse from the vertex 0:");
    g.depthFirst(0);
    System.out.println(" Depth first traverse using stack from the vertex 0:");
    g.depthFirstS(0);
    System.out.println(" Breadth first traverse from the vertex 0:");
    g.breadthTraverse(0);
    System.out.println();
   }
  }

/*
                 {0,1,1,1,0},
                 {1,0,1,0,0},
                 {1,1,0,0,1},
                 {1,0,0,0,0},
                 {0,0,1,0,0}
*/