package tree_asm;


public class BinaryTreeNode {
    Book infor;
    BinaryTreeNode left, right;
    int height;

    public BinaryTreeNode() {
    }

    BinaryTreeNode(Book infor){
        this.infor = infor;
        left = right = null;
        height=0;
    }
}
