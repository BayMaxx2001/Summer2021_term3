
package tree_asm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        InteractWithFile file = new InteractWithFile();
        BinaryTree tree = new BinaryTree(); 

        tree = file.scan("Book.txt");
        System.out.println("In-order traverse to file");
        tree.inorder();
        
        System.out.println("========================");
        System.out.println("Breadth-first traverse");
        tree.BFS();

        //insert file
        Book data = new Book("B08", "Math", 100, 10, 50);
        tree.insert(data);

        // save File 
        System.out.println("========================");
        System.out.println("save file");
        ArrayList<Book> listBook = new ArrayList<>();
        listBook = tree.toList_Inorder(listBook);
        for (Book book : listBook) {
            System.out.print(book);
        }
        file.saveFile(listBook);

        //search 
        System.out.println("========================");
        System.out.println("Search follow bcode");
        BinaryTreeNode nodeTree = new BinaryTreeNode();
        nodeTree = tree.search("B07");
        System.out.println(nodeTree.infor);

        

    }
    
}
