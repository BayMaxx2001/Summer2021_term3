

public class App {
    public static void main(String[] args) throws Exception {
        MyList listNumber = new MyList();
        
        listNumber.addToTail(2);
        listNumber.addToTail(4);
        listNumber.addToTail(5);
        listNumber.addToTail(1);
        listNumber.addToTail(5);

        System.out.println(listNumber.search(5).infor);
    }
}
