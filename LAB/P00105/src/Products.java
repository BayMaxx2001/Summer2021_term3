
import java.text.SimpleDateFormat;
import java.util.Date;
public class Products {
    private String Id;
    private String Name;
    private String Location;
    private double Price;
    private Date   expiryDate;
    private Date   manufactureDate;
    private String Category;
    private String StorekeeperID;
    private Date   ReceiptDate;


    public Products() {
    }

    public Products(String Id, String Name, String Location, double Price, Date expiryDate, Date manufactureDate, String Category, String StorekeeperID, Date ReceiptDate) {
        this.Id = Id;
        this.Name = Name;
        this.Location = Location;
        this.Price = Price;
        this.expiryDate = expiryDate;
        this.manufactureDate = manufactureDate;
        this.Category = Category;
        this.StorekeeperID = StorekeeperID;
        this.ReceiptDate = ReceiptDate;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getManufactureDate() {
        return this.manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCategory() {
        return this.Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getStorekeeperID() {
        return this.StorekeeperID;
    }

    public void setStorekeeperID(String StorekeeperID) {
        this.StorekeeperID = StorekeeperID;
    }

    public Date getReceiptDate() {
        return this.ReceiptDate;
    }

    public void setReceiptDate(Date ReceiptDate) {
        this.ReceiptDate = ReceiptDate;
    }

    public Products Id(String Id) {
        setId(Id);
        return this;
    }

    public Products Name(String Name) {
        setName(Name);
        return this;
    }

    public Products Location(String Location) {
        setLocation(Location);
        return this;
    }

    public Products Price(double Price) {
        setPrice(Price);
        return this;
    }

    public Products expiryDate(Date expiryDate) {
        setExpiryDate(expiryDate);
        return this;
    }

    public Products manufactureDate(Date manufactureDate) {
        setManufactureDate(manufactureDate);
        return this;
    }

    public Products Category(String Category) {
        setCategory(Category);
        return this;
    }

    public Products StorekeeperID(String StorekeeperID) {
        setStorekeeperID(StorekeeperID);
        return this;
    }

    public Products ReceiptDate(Date ReceiptDate) {
        setReceiptDate(ReceiptDate);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", Name='" + getName() + "'" +
            ", Location='" + getLocation() + "'" +
            ", Price='" + getPrice() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            ", manufactureDate='" + getManufactureDate() + "'" +
            ", Category='" + getCategory() + "'" +
            ", StorekeeperID='" + getStorekeeperID() + "'" +
            ", ReceiptDate='" + getReceiptDate() + "'" +
            "}";
    }
    public void displayList() {
        //System.out.print("ID      First name  Last name     Phone        Email       Address    DOT           SEX   Salary     Egency   ");
        //  System.out.print("ID          name                        Location     Price     Category            Expiry date    Manufacture Date       Storekeeper    ReceiptDate   ");

        System.out.println();
        System.out.format("|%-10s|%-28s", getId(), getName());
        System.out.format("|%-11s|%-10.1f|%-18s|", getLocation(), getPrice(), getCategory());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print( formatter.format(getExpiryDate()) + "    |"  );
        System.out.print( formatter.format(getManufactureDate()) + "            |"  );
        System.out.format("%-12s|", getStorekeeperID());
        System.out.print( formatter.format(getReceiptDate()) + "    |"  );
        
    }

}