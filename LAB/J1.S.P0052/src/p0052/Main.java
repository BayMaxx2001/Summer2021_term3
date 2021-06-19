
package p0052;

import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("                                                         MENU");
        System.out.println("==================================================================================================================================================================");
        // TODO code application logic here
        ArrayList<EastAsiaCountries > listEAContry = new ArrayList<>();
        EastAsiaCountries lastCountry = new EastAsiaCountries();
        ManageEastAsiaCountries menuDriven = new ManageEastAsiaCountries();
        while(true)
        {
            int option = menuDriven.menu();
            switch(option)
            {
                case 1:
                    lastCountry = menuDriven.InputData(listEAContry);
                    break;
                case 2:
                    menuDriven.displayLastCountry(lastCountry);
                    break;
                case 3 :
                    String inputSearch = GetAndCheckData.GetAndCheckText("Enter the name you want to search for:");
                    menuDriven.searchName(listEAContry, inputSearch);
                    break;
                case 4:
                    menuDriven.sortName(listEAContry);
                    break;
                case 5:
                    System.out.println("==================================================================================================================================================================");
                    return;
            }
            System.out.println("==================================================================================================================================================================");
        }
    }
    
}
