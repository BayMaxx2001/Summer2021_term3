import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ManagerProducts {
    static ArrayList<Storekeeper> listStorekeeper = new ArrayList<>(); // list Storekeeper
    static ArrayList<Products> listProduct = new ArrayList<>();        // list Products
    private View view = new View();
    //1 .Method Add Storekeeper
    public void addStorekeeper()
    {
        Storekeeper storekeeper = new Storekeeper();
        storekeeper = view.addStorekeeper();
        listStorekeeper.add(storekeeper);
    }
    //2 .Method Add Product
    public void addProduct(){
        Products product = new Products();
        product = view.addProduct();
        listProduct.add(product);
    }
    
    //3 .Method Update product
    public void updateProduct(){
        view.updateProduct_by_ID();
    }

    //4 .Method Search
    public void searchProduct(){
        view.searchProduct();
    }

    //5 .Method Sort product
    public void sortProduct(){
        view.sortProduct();
    }










}
