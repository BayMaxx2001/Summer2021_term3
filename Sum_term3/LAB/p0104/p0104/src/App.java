import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listDic = new ArrayList<String>();
        String url = "D:\\Study\\Term3_SUMMER_21\\LAB\\p0104\\p0104\\src\\";
        while (true) {
            try {
                System.out.println("Please enter directory of file:  "); 
                String fileName = sc.nextLine().trim();
                url = url + fileName;
                File myObj = new File(url);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) 
                {
                    String data = myReader.nextLine();
                    //System.out.println(data);
                    listDic.add(data);
                }
                myReader.close();
                break ; 
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                //e.printStackTrace();
            }
        }
        System.out.println("Please enter string to search:  ");
        String searchNameFile = sc.nextLine();
        searchNameFile = searchNameFile.trim().toLowerCase();

        System.out.println("Search results:        ");
        for (String string : listDic) {
            String str = string.toLowerCase();
            if ( str.contains(searchNameFile) == true ) {
                System.out.println(string);
            }
        }
    }
}
