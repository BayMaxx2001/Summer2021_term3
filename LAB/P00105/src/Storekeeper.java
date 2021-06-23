import java.text.SimpleDateFormat;
import java.util.Date;
public class Storekeeper {
    private String Id;
    private String name;

    public Storekeeper() {
    }

    public Storekeeper(String Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Storekeeper Id(String Id) {
        setId(Id);
        return this;
    }

    public Storekeeper name(String name) {
        setName(name);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
