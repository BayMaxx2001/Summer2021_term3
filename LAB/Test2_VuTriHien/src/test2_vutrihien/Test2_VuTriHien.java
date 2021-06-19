/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_vutrihien;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Test2_VuTriHien {

    public static void main(String[] args) throws FileNotFoundException {
        InteractWithFile file = new InteractWithFile();
        BinaryTree tree = new BinaryTree(); 


        tree = file.scan("product.txt");
        
        
        System.out.println("=========================");
        System.out.println("In-order traverse to file");
        tree.inorder();
     
        System.out.println("========================");
        System.out.println("Breadth-first traverse");
        tree.BFS();
        


        // save File 
        System.out.println("========================");
        System.out.println("save file");
        ArrayList<Product> listBook = new ArrayList<>();
        listBook = tree.toList_Inorder(listBook);
        for (Product product : listBook) {
            System.out.print(product);
        }
        file.saveFile(listBook);
        
        
        //search
        System.out.println("========================");
        System.out.println("Search follow bcode");
        BinaryTreeNode nodeTree = new BinaryTreeNode();
        nodeTree = tree.search("B0");
        System.out.println(nodeTree.infor);
        
        //delete
        System.out.println("========================");
        System.out.println("Delete follow bcode");
        tree.delete("B02");
        tree.inorder();
        
        //rotate
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert bocde:");
        String input = sc.nextLine();
        System.out.println("========================");
        System.out.println("Search & Rotate follow bcode");
        BinaryTreeNode searchNode = new BinaryTreeNode();
        searchNode = tree.search(input);
        searchNode = tree.leftRotate(searchNode);
        tree.BFS();
        
        //height
        System.out.println("========================");
        System.out.println("Height of product tree");
        System.out.println(tree.height());
        
        
        //is Balance
        System.out.println("========================");
        System.out.println("Balance tree?");
        if ( tree.isBalanced() == true ) 
            System.out.println("TRUE");
        else 
            System.out.println("FALSE");
        
    }
    
}
