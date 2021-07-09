public class App {
    public static void main(String[] args) throws Exception {
        int selectOption;
        ManagerProducts manager = new ManagerProducts();
        menu menu = new menu();
        while ( true )
        {
            selectOption=menu.selectOption();
            switch (selectOption) {
                case 1:
                    System.out.println("-------------- Add Storekeeper --------------");
                    manager.addStorekeeper();
                    break;
                case 2:
                    System.out.println("--------------- Add product -----------------");
                    manager.addProduct();
                    break;
                case 3:
                    System.out.println("-------------- Update product ---------------");
                    manager.updateProduct();
                    break;
                case 4:
                    System.out.println("-------------- Search product ---------------");
                    manager.searchProduct();
                    break;
                case 5: 
                    System.out.println("--------------- Sort product ----------------");
                    manager.sortProduct();
                    break; 
                case 6: 
                    System.out.println("------------------ Exit ---------------------");
                    // managerProduct.Exit();
                    System.exit(0);
                    break ; 
                case 7: 
                    // managerProduct.show();
                default:
                    break;
            }
        }    
    }
}
