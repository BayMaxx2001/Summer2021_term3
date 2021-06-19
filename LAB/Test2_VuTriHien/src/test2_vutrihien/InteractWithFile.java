/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_vutrihien;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class InteractWithFile {
    Scanner sc=new Scanner(System.in);
    
    BinaryTree scan(String url) throws FileNotFoundException {
        BinaryTree list = new BinaryTree();
        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            Scanner sc = new Scanner(fileInputStream);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                //System.out.println(str+"-----");
                if (str.trim().equals("")) break;
                String[] part = str.split(",");
                //System.out.println(part[0]+"-----");
                Product newProduct = new Product();
                newProduct = splitFile(part);
                //split & insert 
                //System.out.println(newProduct.bcode +"-----");
                list.insert(newProduct);
            }
        } catch (IOException ex) {
            System.err.println("Not Found File");
        }
        return list;
    }

    private Product splitFile(String[] part) {
        Product newP = new Product();
        newP = new Product( part[0].trim(),Integer.parseInt(part[1].trim()));
        return newP;
    }
    
    void saveFile(ArrayList<Product> list) {
        try {
            Formatter f = new Formatter("output.txt");
            for (int i = 0; i < list.size(); i++) {
                Product product = list.get(i);
                f.format("%s,%d\n", product.bcode, product.quantity);
            }
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
