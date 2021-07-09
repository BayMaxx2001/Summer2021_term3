import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class ManagerProducts {
    ArrayList<Storekeeper> listStorekeeper = new ArrayList<>(); // list Storekeeper
    ArrayList<Products> listProduct = new ArrayList<>();        // list Products
    
    //1 .Method Add Storekeeper
    public void addStorekeeper()
    {
        Storekeeper storekeeper = new Storekeeper();
        storekeeper = inputStorekeeper();
        listStorekeeper.add(storekeeper);
    }
    public Storekeeper inputStorekeeper()
    {
        Storekeeper storekeeper = new Storekeeper();
        while ( true ) {
            System.out.println("Enter id of storekeeper: ");
            String Id = Validation.standardizedID(Validation.checkInputString());
            if (!Validation.checkIdExistStorekeeper(Id,listStorekeeper)) {
                System.err.println("Id has exist Storekeeper. Pleas re-input.");
                continue;
            }
            storekeeper.setId(Id);
            break;
        }
        System.out.println("Enter name of storekeeper: ");
        storekeeper.setName(Validation.standardizedName(Validation.checkInputString()));
        return storekeeper;
    }

    //2 .Method Add Product
    public void addProduct(){
        Products product = new Products();
        product = inputProducts();
        listProduct.add(product);
    }
    
    public Products inputProducts(){

        if ( listStorekeeper.size() == 0 ){
            System.out.println("Can not to add product, you must add to Storekeeper");
            return null;
        }
        Products products = new Products();
        // id
        while ( true ) {
            System.out.println("Enter id of product: ");
            String Id = Validation.standardizedID(Validation.checkInputString());
            if (!Validation.checkIdExistProduct(Id,listProduct)) {
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

        return products;
    }

    //3 .Method Update product
    public void updateProduct(){
        Input_updateProduct_by_ID();
    }
    public Products find_by_ID(String id){
        for(Products i: listProduct){
            if(i.getId().equals(id) == true){
                return i;
            }
        }
        System.out.println("Not found ID");
        return null;
    }
    public Products Input_updateProduct_by_ID(){
        System.out.println("Enter ID you want to update products: ");
        String id = Validation.standardizedID(Validation.checkInputString());
        if (listProduct.isEmpty()) 
        {
            System.out.println("List product is empty!");
            return null;
        }
        Products products = new Products();
        products = find_by_ID(id);
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
    //4 .Method Search
    public String inputString(String msg){
        System.out.println(msg);
        String name = Validation.standardizedName(Validation.checkInputSearchString());
        return name;
    }
    public void searchProduct(){
        if ( listProduct.isEmpty()) 
        {
            System.out.println("List product is empty!");
            return ;
        }
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Category");
        System.out.println("3. Search by Storekeeper");
        System.out.println("4. Search by ReceiptDate");
        System.out.println("Enter select: ");
        int choice = Validation.checkInputIntLimit(1, 4); 
        switch (choice) {
            case 1:
                search_by_name();
                break;
            case 2:
                search_by_Category();
                break;
            case 3:
                search_by_Storekeeper();
                break;
            case 4:
                search_by_ReceiptDate();
                break;
        }
    }

    public void search_by_name()
    {
        ArrayList<Products> list = new ArrayList<>();
        String name = inputString("-------------- Search by Name --------------");
        list = process_search_by_Name(name);
        show(list);
    }
    public ArrayList<Products> process_search_by_Name(String name){
        ArrayList<Products> list = new ArrayList<>();
        
        if ( name.equals("Empty"))
        {
            for(Products p : listProduct)
            {
                list.add(p);
            }
            return list;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getName().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                list.add(listProduct.get(i));
            }
        }
        if (ok == false)
        {
            System.out.print("Name of Products not found!");
            return null;
        }
        return list;
    }

    public void search_by_Category()
    {
        ArrayList<Products> list = new ArrayList<>();
        String name = inputString("-------------- Search by Category --------------");
        list = process_search_by_Category(name);
        show(list);

    }
    public ArrayList<Products> process_search_by_Category(String name){
        ArrayList<Products> list = new ArrayList<>();
        
        if ( name.equals("Empty"))
        {
            for(Products p : listProduct)
            {
                list.add(p);
            }
            return list;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getCategory().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                list.add(listProduct.get(i));
            }
        }
        if (ok == false)
        {
            System.out.print("Name of Products not found!");
            return null;
        }
        return list;
    }

    public void search_by_Storekeeper()
    {
        ArrayList<Products> list = new ArrayList<>();

        String name = inputString("-------------- Search by Storekeeper --------------");
        list = process_search_by_Storekeeper(name);
         show(list);
    }
    public ArrayList<Products> process_search_by_Storekeeper(String name){
        ArrayList<Products> list = new ArrayList<>();
        if ( name.equals("Empty"))
        {
            for(Products p : listProduct)
            {
                list.add(p);
            }
            return list;
        }
        name = name.toLowerCase();
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            String str = listProduct.get(i).getStorekeeperID().toLowerCase();
            if (str.contains(name) == true) {
                ok = true;
                list.add(listProduct.get(i));
            }
        }
        if (ok == false)
        {
            System.out.print("Name of Products not found!");
            return null;
        }
        return list;
    }

    public Date inputDate(String msg){
        System.out.println(msg);
        System.out.println("Enter Receipt Date: ");
        Date date = Validation.checkInputDateSearch();
        return date;
    }
    public void search_by_ReceiptDate()
    {
        ArrayList<Products> list = new ArrayList<>();
        Date date = inputDate("-------------- Search by ReceiptDate --------------");
        list = process_search_by_ReceiptDate(date);
        show(list);
    }
    public ArrayList<Products> process_search_by_ReceiptDate(Date date){
        ArrayList<Products> list = new ArrayList<>();
        if ( date == null)
        {
            for(Products p : listProduct)
            {
                list.add(p);
            }
            return list;
        }
        
        Boolean ok = false;
        for ( int i=0;i<listProduct.size();i++)
        {
            Date d = listProduct.get(i).getReceiptDate();
            if (d.equals(date)) {
                ok = true;
                list.add(listProduct.get(i));
            }
        }
        if (ok == false)
        {
            System.out.print("StorekeeperID of Products not found!");
            return null;
        }
        return list;
    }


    //5 .Method Sort product
    public void sortProduct(){
        if ( listProduct.isEmpty()) 
        {
            System.out.println("List product is empty!");
            return ;
        }
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

    public void sortProductsByExpirydate() {
        if (listProduct.size() == 0) {
            System.out.print("List Products is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        Collections.sort(listProduct, new sortByExpirydate());
    }

    public void sortProductsBy_DateOfManufacture() {
        if (listProduct.size() == 0) {
            System.out.print("List Products is empty!");
            System.out.println("\n---------------------------------------");
            return;
        }
        Collections.sort(listProduct, new sortBy_DateOfManufacture());
    }
    // public boolean checkIdExistStorekeeper(String id) {
    //     for(Storekeeper elements: listStorekeeper){
    //         if ( elements.getId().equalsIgnoreCase(id)== true ) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean checkIdExistProduct(String id) {
    //     for(Products elements: listProduct){
    //         if ( elements.getId().equalsIgnoreCase(id) == true ) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
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
    public void show(ArrayList<Products> list) {
        title();
        for (Products p : list) {
            p.displayList();
        }
        System.out.println();
    }
}
