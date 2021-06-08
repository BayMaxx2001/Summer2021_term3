package tree_asm;

public class Book {
    String bcode; 
    String title; 
    int quantity; 
    int lended; 
    double price; 

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return this.bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return this.lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book bcode(String bcode) {
        setBcode(bcode);
        return this;
    }

    public Book title(String title) {
        setTitle(title);
        return this;
    }

    public Book quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public Book lended(int lended) {
        setLended(lended);
        return this;
    }

    public Book price(double price) {
        setPrice(price);
        return this;
    }
    public void displayAllAttributeOfBook(){
        System.out.printf("%-10s | %-17s | %-3d | %-3d | %-10.2f\n", bcode, title, quantity, lended, price);
    }
    @Override
    public String toString() {
        String ans = String.format("%-10s | %-17s | %-3d | %-3d | %-9.2f\n", bcode, title, quantity, lended, price);
        return ans;
    }

}
