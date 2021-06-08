
package p0052;

public class Country {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
        this.countryCode = "";
        this.countryName = "";
        this.totalArea = 0;
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    
    public void display(){
        System.out.format("%-10s%-20s%-15.2f",countryCode , countryName , totalArea);
        
    }
    
}
