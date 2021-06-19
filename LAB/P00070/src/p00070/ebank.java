package p00070;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ebank {
    ArrayList<ListAccount> listAcc = new ArrayList<>();
    ListAccount acc = new ListAccount();
    ResourceBundle bundle;
    Scanner sc = new Scanner(System.in);
    public void setLocale(){
        int mode = setMode(1, 3);
        if ( mode == 3 )  
        {
            System.out.println("Good bye");
            System.exit(0);
        }
        setLocale(mode);
    }
    public void setLocale(int mode) {
        switch (mode) 
        {
            case 1:
                Locale.setDefault(new Locale("vi", "VN"));
                break;
            case 2:
                Locale.setDefault(new Locale("en", "US"));
                break;
            default:
                return;
        }
        bundle = ResourceBundle.getBundle("language.MessageBundle");
        inputAccountNumber();
        inputPassword();
        inputCaptcha();
        System.out.println("Login access");
        return;
    }

    public String inputAccountNumber() {
        do {
            System.out.print(bundle.getString("accountNumber") + ": ");
            String accountNumber = sc.nextLine();
            if (checkAccountNumber(accountNumber) == null) {
                return accountNumber ;
            } else {
                System.out.println(checkAccountNumber(accountNumber));
            }
        } while (true);
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.trim().length() == 10) {
            try {
                int number = Integer.parseInt(accountNumber.trim());
                return null;
            } catch (NumberFormatException e) {
                return bundle.getString("wrongFormatAccount");
            }
        } else {
            return bundle.getString("wrongFormatAccount");
        }
    }

    public String inputPassword() {
        do {
            System.out.print(bundle.getString("password") + ": ");
            String password = sc.nextLine();
            if (checkPassword(password) == null) {
                return password;
            } else {
                acc.password = checkPassword(password);
                System.out.println(checkPassword(password));
            }
        } while (true);
    }

    public String checkPassword(String password) {
        if (password.trim().length() < 8 || password.length() > 31) {
            return bundle.getString("wrongFormatPassword");
        } else {
            int ch = 0;
            int num = 0;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    num++;
                }
                if (Character.isAlphabetic(password.charAt(i))) {
                    ch++;
                }
            }
            return ch * num > 0 ? null : bundle.getString("wrongFormatPassword");
        }
    }

    public void inputCaptcha() {
        do {
            String captcha = generateCaptcha();
            System.out.println(bundle.getString("captchaIncorrect") + ": " + captcha);

            System.out.print(bundle.getString("enterCaptcha") + ": ");
            String captchaInput = sc.nextLine();
            if (checkCaptcha(captchaInput, captcha) != null) {
                System.out.println(checkCaptcha(captchaInput, captcha) + '\n');
            } else {
                break;
            }
        } while (true);
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput.trim().equals(captchaGenerate)) {
            return null;
        } else {
            return bundle.getString("wrongCaptcha");
        }
    }

    Random generator = new Random();

    public String generateCaptcha() {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpperCase = alpha.toUpperCase();
        String digits = "0123456789";
        String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(num);
            sb.append(ch);
        }
        return sb.toString();
    }

    public int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    int checkNumber(String string) {
        while (true) {
            try {
                int number = Integer.parseInt(string);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Wrong format. Enter number: ");
                string = sc.nextLine();
            }
        }
    }
    int setMode(int min, int max ) {
        do {
            int mode = checkNumber(sc.nextLine());
            if (mode >= min && mode <= max) {
                return mode;
            } else {
                System.out.print("Wrong input. Re-enter: ");
            }
        } while (true);
    }
    void displayAcc()
    {
        System.out.println("Account: " + acc.account);
        System.out.println("Password: " + acc.password);
    }
}
