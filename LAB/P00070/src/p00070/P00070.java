
package p00070;

public class P00070 {
    public static void main(String[] args) {
        ebank eb = new ebank();

        //do {
            System.out.println("-------Login Program-------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English ");
            System.out.println("3. Exit program");
            System.out.print("Please choice one option: ");
            eb.setLocale();
            eb.displayAcc();
        //} while (true);
        
    }
    
}
