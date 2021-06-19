import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String idEmployee, firstName, lastName, email, address, sex, egency, phone;
    private Date dateOfBird;
    private Double salary;


    public Employee() {
    }

    public Employee(String idEmployee, String firstName, String lastName, String email, String address, String sex, String egency, Date dateOfBird, String phone, Double salary) {
        this.idEmployee = idEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.egency = egency;
        this.dateOfBird = dateOfBird;
        this.phone = phone;
        this.salary = salary;
    }

    public String getIdEmployee() {
        return this.idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEgency() {
        return this.egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }

    public Date getDateOfBird() {
        return this.dateOfBird;
    }

    public void setDate( Date date){
        this.dateOfBird = date;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee idEmployee(String idEmployee) {
        setIdEmployee(idEmployee);
        return this;
    }

    public Employee firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Employee lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Employee email(String email) {
        setEmail(email);
        return this;
    }

    public Employee address(String address) {
        setAddress(address);
        return this;
    }

    public Employee sex(String sex) {
        setSex(sex);
        return this;
    }

    public Employee egency(String egency) {
        setEgency(egency);
        return this;
    }

    public Employee dateOfBird(Date dateOfBird) {
        setDate(dateOfBird);
        return this;
    }

    public Employee Phone(String Phone) {
        setPhone(Phone);
        return this;
    }

    public Employee salary(Double salary) {
        setSalary(salary);
        return this;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof Employee)) {
    //         return false;
    //     }
    //     Employee employee = (Employee) o;
    //     return Objects.equals(idEmployee, employee.idEmployee) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(email, employee.email) && Objects.equals(address, employee.address) && Objects.equals(sex, employee.sex) && Objects.equals(egency, employee.egency) && Objects.equals(dateOfBird, employee.dateOfBird) && Phone == employee.Phone && Objects.equals(salary, employee.salary);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(idEmployee, firstName, lastName, email, address, sex, egency, dateOfBird, Phone, salary);
    // }

    @Override
    public String toString() {
        return "{" +
            " idEmployee='" + getIdEmployee() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", sex='" + getSex() + "'" +
            ", egency='" + getEgency() + "'" +
            ", dateOfBird='" + getDateOfBird() + "'" +
            ", Phone='" + getPhone() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }

    public void displayList(Employee e) {
        //System.out.print("ID      First name  Last name     Phone        Email       Address    DOT           SEX   Salary     Egency   ");
        System.out.println();
        System.out.format("|%-10s|%-11s|%-18s", getIdEmployee(), getFirstName(), getLastName());
        System.out.format("|%-11s|%-28s|%-18s|", getPhone(), getEmail(), getAddress());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print( formatter.format(getDateOfBird()) + "    |"  );
        System.out.format("%-7s|%-12.1f|%-11s|", getSex(), getSalary(), getEgency());
        
    }

}
