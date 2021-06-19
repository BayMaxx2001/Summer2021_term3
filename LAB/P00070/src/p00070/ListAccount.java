package p00070;

public class ListAccount {
    String account;
    String password;

    public ListAccount() {
    }

    public ListAccount(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ListAccount account(String account) {
        setAccount(account);
        return this;
    }

    public ListAccount password(String password) {
        setPassword(password);
        return this;
    }


}
