import java.util.*;
class Node
 {int info;
  Node left,right;
  Node(int x)
   {info=x;left=right=null;
   }  
 }
class BSTree
 {Node root;
  BSTree() {root=null;}
  Node search(Node p, int x)
   {if(p==null) return(null);
    if(p.info==x) return(p);
    if(x<p.info)
      return(search(p.left,x));
       else
       return(search(p.right,x));
   }
  Node insert(Node p, int x)
   {if(p==null)
     {p=new Node(x);
      return(p);
     }
    if(x<p.info)
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
  void addArray(int [] a)
   {for(int i=0;i<a.length;i++)
      insert(a[i]);
   }

 }
class Main
 {public static void main(String [] args)
   {BSTree t = new BSTree();
    int [] a = {3,5,1,9,8,2};
    t.addArray(a);
    System.out.println(" After inserting 3, 5, 1, 9, 8, 2:");
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    Node p;
    int x;
    x = 8;
    p = t.search(t.root,x);
    if(p != null)
     System.out.println("\n " + x + " is found in the tree");
      else
      System.out.println("\n " + x + " is not found in the tree");
    x = 7;
    p = t.search(t.root,x);
    if(p != null)
     System.out.println("\n " + x + " is found in the tree");
      else
      System.out.println("\n " + x + " is not found in the tree");

   }
 }