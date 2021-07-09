import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;




public class menu {
    //Init list
     ArrayList<String> listMenuStrings = new ArrayList<>();     // list menu
    
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
}
