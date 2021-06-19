/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_vutrihien;

public class Product {
    String bcode ; 
    int quantity;

    public Product() {
    }

    public Product(String bcode, int quantity) {
        this.bcode = bcode;
        this.quantity = quantity;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void displayAllAttributeOfBook(){
        System.out.printf(bcode + "," + quantity+"\n");
    }
    @Override
    public String toString() {
        String ans = String.format(bcode + "," + quantity+"\n");
        return ans;
    }
}
