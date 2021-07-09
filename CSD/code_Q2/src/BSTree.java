
import java.io.RandomAccessFile;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class BSTree {
    Node root;
    public boolean isEmpty() {return root == null;}
    public void visit(Node x)
    {
        System.out.println(x.info + " ");
    }
    public void bfs(Node p){ //input root
        if(p == null) return;
        Queue m = new Queue();
        m.enqueue(p);
        while(!m.isEmpty()){
            Node q = (Node)m.dequeue();// get node
            if(q.left != null){ // if lever still hava node left
                m.enqueue(q.left);
            }
            if(q.right != null){ //if lever still hava node right
                m.enqueue(q.right);
            }
            visit(q);// traversal them
        }        
    }
    public void changeNodeCondition(Node p){
        if(p == null) return;
        Queue m = new Queue();
        m.enqueue(p);
        int c = 0;
        while(!m.isEmpty()){
            Node q = (Node)m.dequeue();
            if(q.left != null){
                m.enqueue(q.left);
            }
            if(q.right != null){
                m.enqueue(q.right);
            }
            if(q.info.price >= 5){ //maybe or not
                c++;
                if(c == 2){
                    q.info.price = 10;
                    break; 
                }
            }
        }        
    }
    public void insert(Car x)
    {
        Node p = new Node(x);
        if(isEmpty()){root = p; return;}
        Node f = null;
        Node q = root;
        while(q != null){
            if(q.info.owner.equals(x.owner)){
                System.out.println("Insertion failed, duplicated key");
                return;
            }
            else if(q.info.owner.compareToIgnoreCase(x.owner) > 0){f = q; q = q.left;}
            else{f = q; q = q.right;}
        }
        if(f.info.owner.compareToIgnoreCase(x.owner) > 0) f.left = p;
        else f.right = p;
    }
    void preOrder2(Node p, RandomAccessFile f) throws Exception{
        if(p==null) return;
        if(p.info.price>=3&&p.info.price<=5){
           fvisit(p,f);
        }
        preOrder2(p.left,f);
        preOrder2(p.right,f);
   }
    public Node search(Car x){
        return search(root, x);
    }

//search by string
    public Node search(Node p, Car x){
        if(p == null){
            return null;
        }
        if(p.info.owner.equals(x.owner)){
            return p;
        }
        else if(p.info.owner.compareToIgnoreCase(x.owner) > 0){
            return search(p.left,x);
        }
        else{
            return search(p.right,x);
        }
    }
    public Node search(Node p, int key){
        if(p == null) return null;
         if(p.info.price == key) return p;
         else if(p.info.price > key) return search(p.left, key);
         else return search(p.right, key);
    }
    public int count(Node p){
        if(p==null) return(0);
        int k,h,r;
        k = count(p.left);
        h = count(p.right);
        r = k+h+1;
        return(r);
    }
    //count node have 1 child
   int countModifer(Node p) {
      int n = 0;
      Queue m = new Queue();
        m.enqueue(p);
        while(!m.isEmpty()) {
            Node q = (Node)m.dequeue();
            if(q.left != null) m.enqueue(q.left);
            if(q.right != null) m.enqueue(q.right);
            // If q has only one child, increment c by 1
            if(q.left == null && q.right != null) n++;
            if(q.right == null && q.left != null) n++;
        }
      return n;
  }
 
//count node have exactly 2 child
    int countNodeCo2con(Node p) {
      int n = 0;
      Queue m = new Queue();
        m.enqueue(p);
        while(!m.isEmpty()) {
            Node q = (Node)m.dequeue();
            if(q.left != null) m.enqueue(q.left);
            if(q.right != null) m.enqueue(q.right);
            if(q.left != null && q.right != null) n ++;
        }
        return n;
     }
   
    //count height of tree
    public int height(Node p) {
        if (p == null) {
            return 0;
        }
        int l = height(p.left) + 1;
        int r = height(p.right) + 1;
        return (l > r) ? l : r;
    }
    void deleByCopy(int xPrice)
    {
        if (root == null) {
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.price == xPrice) {
                break;//Found key x
            }
            if (xPrice < p.info.price) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xPrice + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p 
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }
    }
    void deleByCopy(String xName) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.owner.equals(xName)) {
                break;
            }
            f = p;
            if (xName.compareTo(p.info.owner) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // not found
        }
        // p is leaf node
        if (p.left == null && p.right == null) {
            if (f == null) // p=root
            {
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                }
                f.right = null;
            }
            return;
        }

        // p has left child only
        if (p.left != null && p.right == null) {
            if (f == null) // p=root
            {
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                }
                f.right = p.left;
            }
            return;
        }

        // p has right child only
        if (p.left == null && p.right != null) {
            if (f == null) // p=root
            {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                }
                f.right = p.right;
            }
            return;
        }

        // p has both 2 children
        if (p.left != null && p.right != null) {// find the right most node
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right most node on the left child
            p.info = rp.info;
            if (frp == null) // rp=q
            {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

//delete by node p
    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            System.out.println("Key does not exists, deletion failed");
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while (q != p) {
            if (q.info.owner.compareTo(p.info.owner) > 0) {         // Changed
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        } // 2. p has a left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {// remove root
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } // 3. p has a right child only
        else if (p.right != null && p.left == null) {
            if (f == null) {// remove root
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        } // 4. Both of right and left child 
        else if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {// rp has no right child 
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }
    public void balance(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last) /2;
        Car x = ((Node)a.get(m)).info;
        insert(x);
        balance(a, first, m-1);
        balance(a, m+1, last);
    }
    Node p123=null;
    void breadth3(Node p) {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.info.price < 7) {
                p123 = r;
                break;
            };
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    Node father2(int xPrice) // return the father of the node q, where q.info.price = xPrice
    {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == xPrice) {
                break;
            }
            f = p;
            if (xPrice < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            System.out.println(" Cannot rotate right.");
            return (p);
        }
        Node pl = p.left;
        p.left = pl.right;
        pl.right = p;
        return (pl);
    }
    
    public Node rotateLeft(Node p){//must be have node right
        if(p.right == null){
            return p;
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
//get node by string
    public Node getNode(String xName) {
        Node p = root;
        while (p != null) {
            if (p.info.owner.compareToIgnoreCase(xName) > 0) p = p.left;
            else if (p.info.owner.compareToIgnoreCase(xName) < 0) p = p.right;
            return p;
        }
        return null;
    }
	
//get node by integer/double
    public Node getNode(int x) {
        Node p = root;
        while (p != null) {
            if (p.info.price > x) p = p.left;
            else if (p.info.price < x) p = p.right;
            return p;
        }
        return null;
    }
}
