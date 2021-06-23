public class App {
    public static void main(String[] args) throws Exception {
        int selectOption;
        View view = new View();
        while ( true )
        {
            selectOption=view.selectOption();
            view.run(selectOption);
        }    
    }
}
