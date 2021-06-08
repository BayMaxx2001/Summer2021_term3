class Node
 {int info;
  Node left,right;
  Node(int x) {info=x; left=right=null;}
 }

class BSTree
 {Node root;
  BSTree() {root=null;}
  boolean isEmpty() {return(root==null);}
  void clear() {root=null;}
  Node search(Node p,int x)
   {if(p==null) return(null);
    if(p.info==x) return(p);
    if(x<p.info)
      return(search(p.left,x));
       else
       return(search(p.right,x));
   }
  void insert(int x)
   {Node q = new Node(x);
    if(isEmpty()) {root=q;return;}
    Node f,p; f=null;p=root;
    while(p!=null)
     {if(p.info==x) 
       {System.out.println(" The key " + x + " already exists, no insertion");
        return;
       }
      f=p;
      if(x<p.info)
        p = p.left;
         else
          p = p.right;
     }
    if(x<f.info) f.left=q; else f.right=q;
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
  void addArray(int [] a)
   {for(int i=0;i<a.length;i++)
      insert(new Integer(a[i]));
   }
 }
class Main
 {public static void main(String [] args)
   {BSTree t = new BSTree();
    System.out.println("\n After inserting 3, 5, 1, 5, 9, 8:");
    int [] a = {3,5,1,5,9,8};
    t.addArray(a);
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    System.out.println("\n Post-order traverse:");
    t.postOrder(t.root);
   }
 }