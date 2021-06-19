public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(3);
        tree.insert(10);
        tree.insert(6);
        tree.insert(2);
        tree.insert(5);
        System.out.print("Post order : ");
        tree.postorder();
        System.out.print("\nPre order : "); 
        tree.preorder();
        System.out.print("\nIn order : ");
        tree.inorder();


        // tree.delete(10);
        // System.out.print("\nAfter delete: ");
        // tree.inorder();

        System.out.println("\nSum of tree: "+ tree.sum(tree.root));
        
    }
}
