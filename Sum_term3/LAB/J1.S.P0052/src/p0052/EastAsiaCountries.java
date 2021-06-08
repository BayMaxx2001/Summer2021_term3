
package p0052;

import java.util.Comparator;

public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries() {
        this.countryTerrain = "";
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    @Override
    public void display(){
        super.display();
        System.out.format("%-15s\n",countryTerrain);
    }
    
    public static Comparator<EastAsiaCountries> compare =new Comparator<EastAsiaCountries>(){
        @Override
        public int compare(EastAsiaCountries e1, EastAsiaCountries e2){
            String n1 = e1.getCountryName().toLowerCase();
            String n2 = e2.getCountryName().toLowerCase();
            return n1.compareTo(n2);
        }  
    };
    
}
