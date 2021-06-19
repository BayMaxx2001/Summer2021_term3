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
  void postOrder(Node p)
   {if(p==null) return;
    postOrder(p.left);
    postOrder(p.right);
    visit(p);
   }
 }
class Main
 {public static void main(String [] args)
   {BSTree t = new BSTree();
    t.insert(3);
    t.insert(5);
    t.insert(1);
    t.insert(9);
    System.out.println("\n After inserting 3, 5, 1, 9:");
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    System.out.println("\n Post-order traverse:");
    t.postOrder(t.root);
   }
 }