package tree_asm;

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
                String[] part = str.split("\\|");
                Book newBook = new Book();
                newBook = splitFile(part);
                //split & insert 
                list.insert(newBook);
            }
        } catch (IOException ex) {
            System.err.println("Not Found File");
        }
        return list;
    }

    private Book splitFile(String[] part) {
        Book newBook = new Book();
        newBook = new Book( part[0].trim(), part[1].trim(), Integer.parseInt(part[2].trim()), Integer.parseInt(part[3].trim()), Float.parseFloat(part[4].trim()));
        return newBook;
    }

    BinaryTree add(BinaryTree tree){
        System.out.print("Enter bcode:");
        String bcode= sc.nextLine();
        System.out.print("Enter title: ");
        String title=sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity= isInt(sc.nextLine());
        System.out.print("Enter lended: ");
        int lended= isInt(sc.nextLine());
        System.out.println("Enter price: ");
        float price = isFloat(sc.nextLine());
        tree.insert(new Book(bcode,title,quantity,lended,price));
        return tree;
    }
    
    int isInt(String str) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.print("Wrong format. Re-enter:");
                str = sc.nextLine();
            }
        }
        return num;
    }

    float isFloat(String str) {
        float num;
        while (true) {
            try {
                num = Float.parseFloat(str);
                break;
            } catch (Exception e) {
                System.out.print("Wrong format. Re-enter:");
                str = sc.nextLine();
            }
        }
        return num;
    }
    
    void saveFile(ArrayList<Book> list) {
        try {
            Formatter f = new Formatter("output.txt");
            for (int i = 0; i < list.size(); i++) {
                Book book = list.get(i);
                f.format("%-10s | %-17s | %-3d | %-3d | %-10.2f\n", book.bcode, book.title, book.quantity, book.lended, book.price);
            }
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
