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
  boolean isEmpty()
   {return(root==null);
   }
  void insert(int x)
   {if(root==null)
      {root = new Node(x);
       return; 
      }
    Node f,p;
    p=root;f=null;
    while(p!=null)
     {if(p.info==x)
       {System.out.println(" The key " + x + " already exists, no insertion");
        return;
       }
      if(x<p.info)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(x<f.info)
      f.left=new Node(x);
       else
        f.right=new Node(x);
   }
  void mergeDele(int x)
   {if(root==null)
       {System.out.println(" The tree is empty, no deletion");
        return;
       }
    Node f,p; // f will be the father of p
    p=root;f=null;
    while(p!=null)
     {if(p.info==x) break;//Found key x
      if(x<p.info)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(p==null)
     {System.out.println(" The key " + x + " does not exist, no deletion");
      return;
     }
    if(p.left==null && p.right==null) // p is a leaf node
     {if(f==null) // The tree is one node
       root=null; 
        else
        {if(f.left==p)
          f.left=null;
           else
            f.right=null;
        }
      return;
     }

    if(p.left!=null && p.right==null) // p has only left child
     {if(f==null) // p is a root
       root=p.left; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.left;
            else 
             f.right=p.left;
        }
      return;
     }

    if(p.left==null && p.right!=null) // p has only right child
     {if(f==null) // p is a root
       root=p.right; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.right;
            else 
             f.right=p.right;
        }
      return;
     }

    if(p.left!=null && p.right!=null) // p has both left and right children
     {Node q,pr; pr = p.right;
      q = p.left;
      while(q.right!=null) q = q.right;// Find the right most node on the left tree
      q.right = pr;
     }
    // Now we get the case p has only left child
    if(f==null) // p is a root
      root=p.left; 
       else
       {if(f.left==p) // p is aleft child
         f.left=p.left;
          else 
           f.right=p.left;
       }
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
    System.out.println("\n After inserting 3, 5, 1, 5, 9, 8, 2:");
    int [] a = {3,5,1,5,9,8,2};
    t.addArray(a);
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    System.out.println("\n\n Ater deleting 3:");
    t.mergeDele(new Integer(3));
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
   }
 }