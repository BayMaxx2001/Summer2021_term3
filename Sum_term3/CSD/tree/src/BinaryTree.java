import java.util.ArrayList;

public class BinaryTree {

    BinaryTreeNode root;
    int sumTree = 0;
    int height = 0;
    public BinaryTree()
    {
        root = null;
    }
    //isEmpty, clear
    public boolean isEmpty(){
        return (root != null);
    }
    public void clear(){
        root = null;
    }
    //Search
    public BinaryTreeNode search(int x){
        return search(x, root);
    }
    public BinaryTreeNode search(int x, BinaryTreeNode root){
        if(root == null || root.infor == x) return root;
        if (root.infor < x )
            return search(x,root.right);
        else 
            return search(x, root.left);
    }
    //insert data
    public void insert(int data)
    {
        root = insert(root, data);
    }
    public BinaryTreeNode insert(BinaryTreeNode node, int data)
    {
        if (node == null)
            node = new BinaryTreeNode(data);
        else
        {
            if (data <= node.infor)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    //Breath First Search
    public void BFS(){
        Queue myQueue = new Queue();

        if ( root == null ) return;
        Node head = new Node(root);
        myQueue.enqueue(head);
        while (!myQueue.isEmpty()){
            Node p = myQueue.dequeue();
            System.out.print(p.data.infor + " ");

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
            System.out.print(root.infor +" ");
            inorder(root.right);
        }
    }
    //Preorder traversal 
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
    //Postorder traversal 
    public void postorder()
    {
        postorder(root);
    }
    public void postorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            postorder(root.left);             
            postorder(root.right);
            System.out.print(root.infor +" ");
        }
    }
    //Delete
    public void delete(int x) { 
        root = delete(root, x); 
    }
    public BinaryTreeNode delete(BinaryTreeNode root , int x){
        if( root == null ) return root;
        if ( x < root.infor ) 
            root.left = delete(root.left, x);
        else if ( x > root.infor ) 
            root.right = delete(root.right, x);
        else {
            if ( root.left == null )
                return root.right;
            if ( root.right == null ) 
                return root.left;
            
            root = min(root.right);
            x = root.infor;

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
    //Find sum
    public int sum(BinaryTreeNode root){

        if ( root == null ) return 0;

        sum(root.left);
        sum(root.right);
        sumTree += root.infor;
        return sumTree;
    }
    //Display
    public void visit(BinaryTreeNode P) {
        if (P == null ) return ;
        System.out.println(P.infor + " "); 
    }

    public int height()
    {
        Queue myQueue = new Queue();
        int ans = 0; 
        if ( root == null ) return -1;
        Node head = new Node(root);
        myQueue.enqueue(head);
        while (!myQueue.isEmpty()){
            Node p = myQueue.dequeue();
           // System.out.println(p.data.infor + " " + p.data.height) ;

            if ( p.data.left != null)
            {
                Node left = new Node(p.data.left);
                left.data.height = p.data.height + 1;
                ans = Math.max(ans, left.data.height);
                myQueue.enqueue(left);

            }
            if ( p.data.right != null)
            {
                Node right = new Node(p.data.right);
                right.data.height = p.data.height + 1;
                ans = Math.max(ans, right.data.height);
                myQueue.enqueue(right);
            }
        }
        height = ans; 
        return ans; 
    }
    public int avg(){
        return sum(root)/height();
    }
    public ArrayList inorderToArray(BinaryTreeNode root){
        ArrayList<Integer> array = new ArrayList<>();
        if (root != null)
        {
            inorder(root.left);
            //System.out.print(root.infor +" ");
            array.add(root.infor);
            inorder(root.right);
        }
        return array;
    }
    public void balance(ArrayList<Integer> array, int left, int right){
        if ( right < left ) return;
        int mid = (left+right)>>2;
        insert(array.get(mid));
        balance(array, left, mid); 
        balance(array, left, right);
    }
    public BinaryTreeNode rightRotate(BinaryTreeNode y) {
        BinaryTreeNode x = y.left;
        BinaryTreeNode tmp = x.right;
 
        x.right = y;
        y.left = tmp;
 
        y.height = Math.max(y.left.height, y.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;
 
        // Return new root
        return x;
    }
    public BinaryTreeNode leftRotate(BinaryTreeNode x) {
        BinaryTreeNode y = x.right;
        BinaryTreeNode tmp = y.left;
 
        y.left = x;
        x.right = tmp;
 
        x.height = Math.max(x.left.height, x.right.height) + 1;
        y.height = Math.max(y.left.height, y.right.height) + 1;
 
        return y;
    }
    
}
