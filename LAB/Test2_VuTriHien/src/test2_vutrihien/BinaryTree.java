/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_vutrihien;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BinaryTree {

    BinaryTreeNode root;
    int sumTree = 0;
    int height = 0;

    //insert
    public void insert(Product data)
    {
        root = insert(root, data);
    }
    public BinaryTreeNode insert(BinaryTreeNode node, Product data)
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
    
    public void preorder()
    {
        preorder(root);
    }
    public void preorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.infor +" ");
            preorder(root.left);             
            preorder(root.right);
        }
    }
    
    
    //ToList to save file
    public ArrayList<Product> toList_Inorder(ArrayList<Product> current){
        return toList_Inorder(current,root);
    } 
    public ArrayList<Product> toList_Inorder(ArrayList<Product> current , BinaryTreeNode root){
        if ( root == null ) return current; 
        current.add(root.infor);
        if ( root.left != null)
            toList_Inorder(current, root.left);
        if ( root.right != null)
            toList_Inorder(current, root.right);

        return current;
    }
    
    
    public BinaryTreeNode search(String x) {
        return search(x, root);
    }

    public void displaySearchNode(String x) {
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode = search(x, root);
        System.out.println(newNode.infor.bcode +","+ newNode.infor.quantity);
    }

    public BinaryTreeNode search(String bcodeFind, BinaryTreeNode root) {
        if ( root == null ) 
        {
            BinaryTreeNode n1 = new BinaryTreeNode();
            return n1; 
        }
        if ( root.infor.bcode.equalsIgnoreCase(bcodeFind)) 
        {
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
    
    
    //Delete
    public void delete(String x) { 
        root = delete(root, x); 
    }
    public BinaryTreeNode delete(BinaryTreeNode root , String x){
        if( root == null ) return root;
        int k = x.compareTo(root.infor.bcode); 
        if ( k < 0 ) 
            root.left = delete(root.left, x);
        else if ( k > 0 ) 
            root.right = delete(root.right, x);
        else {
            if ( root.left == null )
                return root.right;
            if ( root.right == null ) 
                return root.left;
            
            root = min(root.right);
            x = root.infor.bcode;

            root.right = delete(root.right, x);
        }
        return root; 
    }
    
    
        //Find min,max
    public BinaryTreeNode min(BinaryTreeNode root){
        if ( root.left == null ) return root;
        return min(root.left);
    }
    public BinaryTreeNode max(BinaryTreeNode root){
        if ( root.right == null ) return root;
        return min(root.right);
    }
    
    
    //rotate
    public BinaryTreeNode rightRotate(BinaryTreeNode y) {
        BinaryTreeNode x = y.left;
        BinaryTreeNode tmp = x.right;
        
        x.right = y;
        y.left = tmp;
 
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;
        return x;
    }
    public BinaryTreeNode leftRotate(BinaryTreeNode x) {
        if ( x.left == null )
            return x;
        BinaryTreeNode y = x.right;
        BinaryTreeNode tmp = y.left;
 
        y.left = x;
        x.right = tmp;
 
        x.height = Math.max(x.left.height, x.right.height) + 1;
        y.height = Math.max(y.left.height, y.right.height) + 1;
 
        return y;
    }
    
    boolean isBalanced(){
        return isBalanced(root);
    }
    boolean isBalanced(BinaryTreeNode node)
    {
        int lh;
        int rh; 
        if (node == null)
            return true;
        lh = height_getbalance(node.left);
        rh = height_getbalance(node.right);
 
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left)
            && isBalanced(node.right))
            return true;
 
        return false;
    }

    int height_getbalance(BinaryTreeNode node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(height_getbalance(node.left), height_getbalance(node.right));
    }
    public int height()
    {
        if(root == null)
        {
            return 0;
        }
        return height(root);
    }
    private int height(BinaryTreeNode cur)
    {
        if(cur==null) return 0;
        int max = 0;
        int hLeft = height(cur.left);
        int hRight = height(cur.right);
        if(hLeft > max) max = hLeft;
        if(hRight>max) max = hRight;
        return max+1;
    }
    
}
