import java.util.*;
class Node
 {int info;
  Node left,right;
  Node(int x)
   {info=x;left=right=null;
   }  
 }
class MyStack
 {LinkedList a;
  MyStack() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void push(Object x)
   {a.add(x);
   }
  Object pop()
   {return(a.removeLast());
   }
 }
class MyQueue
 {LinkedList a;
  MyQueue() {a = new LinkedList();}
  boolean isEmpty() {return(a.isEmpty());}
  void enqueue(Object x)
   {a.add(x);
   }
  Object dequeue()
   {return(a.removeFirst());
   }
 }
class BSTree
 {Node root;
  BSTree() {root=null;}
  Node insert(Node p, int x)
   {if(p==null)
     {p=new Node(x);
      return(p);
     }
    if(x< p.info)
      p.left=insert(p.left,x);
       else
      p.right=insert(p.right,x);
    return(p);  
   }
  void insert(int x)
   {root=insert(root,x);
   }
  void visit(Node p)
   {if(p==null) return;
    System.out.print("  " + p.info);
   }
  void preOrder(Node p)
   {if(p==null) return;
    visit(p);
    preOrder(p.left);
    preOrder(p.right);
   }
  void inOrder(Node p)
   {if(p==null) return;
    inOrder(p.left);
    visit(p);
    inOrder(p.right);
   }
  void postOrder(Node p)
   {if(p==null) return;
    postOrder(p.left);
    postOrder(p.right);
    visit(p);
   }
  void breadth()
   {if(root==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(root);
    Node p;
    while(!q.isEmpty())
     {p = (Node) q.dequeue();
      if(p.left !=null)
         q.enqueue(p.left);
      if(p.right !=null)
         q.enqueue(p.right);
      visit(p);
     }
   }
  void preOrder2()
   {if(root==null) return;
    MyStack s = new MyStack();
    s.push(root);
    Node p;
    while(!s.isEmpty())
     {p = (Node) s.pop();
      if(p.right !=null)
         s.push(p.right);
      if(p.left !=null)
         s.push(p.left);
      visit(p);
     }
   }
  void addArray(int [] a)
   {for(int i=0;i<a.length;i++)
      insert(a[i]);
   }
 }
class Main
 {public static void main(String [] args)
   {BSTree t = new BSTree();
    System.out.println(" After inserting 11, 5, 13, 7:");
    int [] a = {11,5,13,9,7};
    t.addArray(a);
    
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n Pre-order traverse (using stack):");
    t.preOrder(t.root);
    System.out.println("\n Breadth-first traverse:");
    t.breadth();
   }
 }