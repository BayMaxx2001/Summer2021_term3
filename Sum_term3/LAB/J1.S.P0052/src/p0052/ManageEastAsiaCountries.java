/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0052;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hoang
 */
public class ManageEastAsiaCountries {

    public ManageEastAsiaCountries() {
    }
    
    public int menu(){
        System.out.println("1. Input country");
        System.out.println("2. Display list country");
        System.out.println("3. Search by name");
        System.out.println("4. Display countries sorted name (ascending)");
        System.out.println("5. Exit");
        System.out.println("==================================================================================================================================================================");
        int option = GetAndCheckData.GetAndCheckInt("Enter your choice :",1,5);
        return option;
    }
    
    
    public boolean checkCountryExist(ArrayList<EastAsiaCountries> listEAContry, String countryCode) {
        for (EastAsiaCountries country : listEAContry) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
    public void displayHeadTable()
    {
        System.out.format("%-10s%-20s%-15s%-15s\n","ID","Name","Total area","Terrain");
    }
    public EastAsiaCountries InputData(ArrayList<EastAsiaCountries> listEAContry)
    {
        String countryCode;
        do{
            countryCode = GetAndCheckData.GetAndCheckText("Enter code of country: ");
            if(!checkCountryExist(listEAContry, countryCode)) break;
            System.out.println("Country exist.");
        }while(true);
        String countryName = GetAndCheckData.GetAndCheckText("Enter name of country: ");
        float countryArea = GetAndCheckData.GetAndCheckFloat("Enter total area: ", 0.0001f, Float.MAX_VALUE);
        String countryTerrain = GetAndCheckData.GetAndCheckText("Enter terrain of country: ");
        EastAsiaCountries country = new EastAsiaCountries(countryTerrain, countryCode, countryName, countryArea);
        listEAContry.add(country);
        System.out.println("Input information complete!");
        return country;
    }
    
    public void displaylist(ArrayList<EastAsiaCountries> listEAContry){
        displayHeadTable();
        for(EastAsiaCountries country : listEAContry){
            country.display();
        }
    }
    
    
    public void displayLastCountry(EastAsiaCountries country)
    {
        if(country.getCountryCode().equals(""))
        {
            System.out.println("You have not entered any Country before !!!!!");
        }
        else
        {
            displayHeadTable();
            country.display();
        }
    }
    
    public void searchName(ArrayList<EastAsiaCountries> listEAContry, String search){
        ArrayList<EastAsiaCountries> found = new ArrayList<EastAsiaCountries>();
        search = search.toLowerCase();
        for(EastAsiaCountries i : listEAContry){
            if (i.getCountryName().toLowerCase().contains(search))
                found.add(i);
        }
        if (found.size() == 0)
            System.out.println("Not found!");
        else{
            displaylist(found);
        }
    }
    
    public void sortName(ArrayList<EastAsiaCountries> listEAContry){

        Collections.sort(listEAContry, EastAsiaCountries.compare );
        displaylist(listEAContry);
    }
}
