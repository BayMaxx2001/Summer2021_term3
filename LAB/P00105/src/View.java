import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

class sortByExpirydate implements Comparator<Products> {
    public int compare(Products a, Products b) {
        return (int) (a.getExpiryDate().compareTo(b.getExpiryDate()));
    }
}
class sortBy_DateOfManufacture implements Comparator<Products> {
    public int compare(Products a, Products b) {
        return (int) (a.getManufactureDate().compareTo(b.getManufactureDate()));
    }
}



public class View {
    static ArrayList<Storekeeper> listStorekeeper = new ArrayList<>(); // list Storekeeper
    static ArrayList<Products> listProduct = new ArrayList<>();        // list Products
    
    //Init list
    private ArrayList<String> listMenuStrings = new ArrayList<>();     // list menu
    
    public void InitMenu()
    {
        listMenuStrings.add("1. Add Storekeeper");
        listMenuStrings.add("2. Add product");
        listMenuStrings.add("3. Update product");
        listMenuStrings.add("4. Search product by Name, Category, Storekeeper, ReceiptDate");
        listMenuStrings.add("5. Sort product by Expiry date, Date of manufacture");
        listMenuStrings.add("6. Exit");
    }
    public void displayListMenu()
    {
        System.out.println();
        for (String string : listMenuStrings) {
            System.out.println(string);
        }
    }
    public int selectOption(){
        InitMenu();
        int selectOption = Validation.checkInputMenu(1, listMenuStrings.size());
        return selectOption;
    }
    public void run(int choice){
        ManagerProducts managerProduct = new ManagerProducts();
        switch (choice) {
            case 1:
                System.out.println("-------------- Add Storekeeper --------------");
                managerProduct.addStorekeeper();
                break;
            case 2:
                System.out.println("--------------- Add product -----------------");
                managerProduct.addProduct();
                break;
            case 3:
                System.out.println("-------------- Update product ---------------");
                managerProduct.updateProduct();
                break;
            case 4:
                System.out.println("-------------- Search product ---------------");
                managerProduct.searchProduct();
                break;
            case 5: 
                System.out.println("--------------- Sort product ----------------");
                managerProduct.sortProduct();
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

    // add Storekeeper
    public Storekeeper addStorekeeper()
    {
        Storekeeper storekeeper = new Storekeeper();
        while ( true ) {
            System.out.println("Enter id of storekeeper: ");
            String Id = Validation.standardizedID(Validation.checkInputString());
            if (!checkIdExistStorekeeper(Id)) {
                System.err.println("Id has exist Storekeeper. Pleas re-input.");
                continue;
            }
            storekeeper.setId(Id);
            break;
        }
        System.out.println("Enter name of storekeeper: ");
        storekeeper.setName(Validation.standardizedName(Validation.checkInputString()));
        listStorekeeper.add(storekeeper);
        return storekeeper;
    }


    //add Product
    public Products addProduct(){
        if ( listStorekeeper.size() == 0 ){
            System.out.println("Can not to add product");
            return null;
        }
        Products products = new Products();
        // id
        while ( true ) {
            System.out.println("Enter id of product: ");
            String Id = Validation.standardizedID(Validation.checkInputString());
            if (!checkIdExistProduct(Id)) {
                System.err.println("Id has exist Products. Pleas re-input.");
                continue;
            }
            products.setId(Id);
            break;
        }
        // name
        System.out.print("Enter name of product: ");
        products.setName(Validation.standardizedName(Validation.checkInputString()));
        // location
        System.out.print("Enter location of product: ");
        products.setLocation(Validation.standardizedName(Validation.checkInputString()));
        // price
        System.out.print("Enter price of product: ");
        products.setPrice(Validation.checkInputDoubleLimit());
        // Expiry date
        System.out.println("Enter expiry date of product: ");
        products.setExpiryDate(Validation.checkInputDate());
        // Date of manufacture
        System.out.println("Enter of date manufacture of product: ");
        products.setManufactureDate(Validation.checkInputDate());
        // Category
        System.out.println("Enter of category of product: ");
        products.setCategory(Validation.standardizedName(Validation.checkInputString()));
        // Storekeeper
        System.out.println("Enter of StorekeeperID of product: ");
        products.setStorekeeperID(Validation.standardizedID(Validation.checkInput_StorekeeperID_of_product(listStorekeeper)));
        // ReceiptDate
        System.out.println("Enter of Receipt Date of product: ");
        products.setReceiptDate(Validation.checkInputDate());


        listProduct.add(products);
        return products;
    }

    //Update product by ID
    public Products updateProduct_by_ID(){
        Products products = new Products();
        products = find_by_ID();
        if ( products == null){
            return null; 
        }
        // name
        System.out.print("Enter name of product: ");
        products.setName(Validation.standardizedName(Validation.checkInputString()));
        // location
        System.out.print("Enter location of product: ");
        products.setLocation(Validation.standardizedName(Validation.checkInputString()));
        // price
        System.out.print("Enter price of product: ");
        products.setPrice(Validation.checkInputDoubleLimit());
        // Expiry date
        System.out.println("Enter expiry date of product: ");
        products.setExpiryDate(Validation.checkInputDate());
        // Date of manufacture
        System.out.println("Enter of date manufacture of product: ");
        products.setManufactureDate(Validation.checkInputDate());
        // Category
        System.out.println("Enter of category of product: ");
        products.setCategory(Validation.standardizedName(Validation.checkInputString()));
        // Storekeeper
        System.out.println("Enter of StorekeeperID of product: ");
        products.setStorekeeperID(Validation.standardizedID(Validation.checkInput_StorekeeperID_of_product(listStorekeeper)));
        // ReceiptDate
        System.out.println("Enter of Receipt Date of product: ");
        products.setReceiptDate(Validation.checkInputDate());

        return products;
    }
    
    public Products find_by_ID(){
        System.out.println("Enter ID you want to update products: ");
        String id = Validation.standardizedID(Validation.checkInputString());
        for(Products i: listProduct){
            if(i.getId().equals(id) == true){
                return i;
            }
        }
        System.out.println("Not found ID");
        return null;
    }
    

    public void searchProduct(){
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Category");
        System.out.println("3. Search by Storekeeper");
        System.out.println("4. Search by ReceiptDate");
        System.out.println("Enter select: ");
        int choice = Validation.checkInputIntLimit(1, 4); 
        switch (choice) {
            case 1:
                System.out.println("-------------- Search by Name --------------");
                search_by_Name();
                break;
            case 2:
                System.out.println("--------------- Search by Category -----------------");
                search_by_Category();
                break;
            case 3:
                System.out.println("-------------- Search by Storekeeper ---------------");
                search_by_Storekeeper();
                break;
            case 4:
                System.out.println("-------------- Search by ReceiptDate ---------------");
                search_by_ReceiptDate();
                break;
        }
    }

    public void search_by_Name(){
        System.out.println("Enter name: ");
        String name = Validation.standardizedName(Validation.checkInputSearchString());
        title();
        if ( name.equals("Empty"))
        {
            
            for(Products p : listProduct)
            {
                p.displayList();
            }
            return;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getName().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                listProduct.get(i).displayList();
            }
        }
        if (ok == false)
            System.out.print("Name of Products not found!");
    }
    public void search_by_Category(){
        System.out.println("Enter name Category: ");
        String name = Validation.standardizedName(Validation.checkInputSearchString());
        title();
        if ( name.equals("Empty"))
        {
            for(Products p : listProduct)
            {
                p.displayList();
            }
            return;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getCategory().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                listProduct.get(i).displayList();
            }
        }
        if (ok == false)
            System.out.print("Name Category of Products not found!");
    }
    public void search_by_Storekeeper(){
        System.out.println("Enter StorekeeperID: ");
        String name = Validation.standardizedID(Validation.checkInputSearchString());
        title();
        if ( name.equals("EMPTY"))
        {
            for(Products p : listProduct)
            {
                p.displayList();
            }
            return;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getCategory().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                listProduct.get(i).displayList();
            }
        }
        if (ok == false)
            System.out.print("StorekeeperID of Products not found!");
    }
    public void search_by_ReceiptDate(){
        System.out.println("Enter Receipt Date: ");
        Date date = Validation.checkInputDateSearch();
        title();
        if ( date == null )
        {
            for(Products p : listProduct)
            {
                p.displayList();
            }
            return;
        }
        
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            Date d = listProduct.get(i).getReceiptDate();
            if (d.equals(date)) {
                ok = true;
                listProduct.get(i).displayList();
            }
        }
        if (ok == false)
            System.out.print("StorekeeperID of Products not found!");
    }

    //sort menu
    public void sortProduct(){
        System.out.println("1. sort by Expiry date");
        System.out.println("2. sort by Date of manufacture");
        System.out.println("Enter select: ");
        int choice = Validation.checkInputIntLimit(1, 2); 
        switch (choice) {
            case 1:
                System.out.println("-------------- Sort by Expiry date--------------");
                sortProductsByExpirydate();
                break;
            case 2:
                System.out.println("------------Sort by Date of manufacture----------");
                sortProductsBy_DateOfManufacture();
                break;
        }
        show();
    }
    //sort by Expirydate
    public void sortProductsByExpirydate() {
        if (listProduct.size() == 0) {
            System.out.print("List Products is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        Collections.sort(listProduct, new sortByExpirydate());
    }

    // sort by Date of manufacture
    public void sortProductsBy_DateOfManufacture() {
        if (listProduct.size() == 0) {
            System.out.print("List Products is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        Collections.sort(listProduct, new sortBy_DateOfManufacture());
    }

    //Check duplicate Id
    public boolean checkIdExistStorekeeper(String id) {
        for(Storekeeper elements: listStorekeeper){
            if ( elements.getId().equalsIgnoreCase(id)== true ) {
                return false;
            }
        }
        return true;
    }
    public boolean checkIdExistProduct(String id) {
        for(Products elements: listProduct){
            if ( elements.getId().equalsIgnoreCase(id) == true ) {
                return false;
            }
        }
        return true;
    }
    
    public void title(){
        System.out.println("ID          name                        Location     Price     Category            Expiry date    Manufacture Date       Storekeeper    ReceiptDate   ");
    }
    public void show() {
        title();
        for (Products p : listProduct) {
            p.displayList();
        }
        System.out.println();
    }
}
