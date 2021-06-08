package tree_asm;

import java.util.ArrayList;

public class BinaryTree {

    BinaryTreeNode root;
    int sumTree = 0;
    int height = 0;

    //insert
    public void insert(Book data)
    {
        root = insert(root, data);
    }
    public BinaryTreeNode insert(BinaryTreeNode node, Book data)
    {
        if (node == null)
            node = new BinaryTreeNode(data);
        else
        {
            int k = data.bcode.compareTo(node.infor.bcode); 
            if (k <  0)
                node.left = insert(node.left, data);
            else if ( k > 0 ) 
                node.right = insert(node.right, data);
            else 
                System.out.println("Dublicate bcode: " + data.bcode);
        }
        return node;
    }
    //Inorder traversal 
    public void inorder()
    {
        inorder(root);
    }
    public void inorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.infor);
            inorder(root.right);
        }
    }
    //Breath First Search
    public void BFS(){
        Queue myQueue = new Queue();

        if ( root == null ) return;
        Node head = new Node(root);
        myQueue.enqueue(head);
        while (!myQueue.isEmpty()){
            Node p = myQueue.dequeue();
            System.out.print(p.data.infor);

            if ( p.data.left != null)
            {
                Node left = new Node(p.data.left);
                myQueue.enqueue(left);
            }
            if ( p.data.right != null)
            {
                Node right = new Node(p.data.right);
                myQueue.enqueue(right);
            }
        }
    }
    //ToList to save file
    public ArrayList<Book> toList_Inorder(ArrayList<Book> current){
        return toList_Inorder(current,root);
    } 
    public ArrayList<Book> toList_Inorder(ArrayList<Book> current , BinaryTreeNode root){
        if ( root == null ) return current; 
        if ( root.left != null)
            toList_Inorder(current, root.left);
        current.add(root.infor);
        if ( root.right != null)
            toList_Inorder(current, root.right);

        return current;
    }
    
    //Search
    public BinaryTreeNode search(String x) {
        return search(x, root);
    }

    public void displaySearchNode(String x) {
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode = search(x, root);
        System.out.println(newNode.infor.bcode + "        |" + newNode.infor.title + "            |"
                + newNode.infor.quantity + "   |"
                + +newNode.infor.lended + "    |" + newNode.infor.price);
    }

    public BinaryTreeNode search(String bcodeFind, BinaryTreeNode root) {
        if (root == null || root.infor.bcode.equalsIgnoreCase(bcodeFind)) {
            return root;
        }
        //System.out.println(root.infor.bcode+"----");
        int k = bcodeFind.compareTo(root.infor.bcode);
        if (k > 0) {
            return search(bcodeFind, root.right);
        } else {
            return search(bcodeFind, root.left);
        }
    }
}
