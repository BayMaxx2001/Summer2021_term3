class binaryTree
{
    Node root;
    int size(){
        return sizeTree(root);
    }
    int sizeTree(Node node)
    {
        if (node == null)
            return 0;
        else
            return(sizeTree(node.left) + sizeTree(node.right) + 1);
    }
    int height(){
        return heightTree(root);
    }
    int heightTree(Node node ){
        if ( node == null ) return 0;
        else 
            return Math.max(heightTree(node.left), heightTree(node.right)) +1;
    }

}