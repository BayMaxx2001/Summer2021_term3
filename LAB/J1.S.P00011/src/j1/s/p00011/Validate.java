package j1.s.p00011;

import java.util.Scanner;

public class Validate {

    public int getChoice(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int temp = Integer.parseInt(sc.nextLine());
                if (temp < min || temp > max) {
                    System.out.print("Wrong choice, please input again: ");
                } else {
                    return temp;
                }
            } catch (Exception e) {
                System.out.print("Wrong input, please enter again:");
            }
        }
    }

    public static String standard(String num) {
        if (num.length() == 0) {
            return "0";
        }
        if (num.length() == 1) {
            return num;
        }
        if (num.charAt(0) == '0') {
            return standard(num.substring(1));
        } else {
            return num;
        }
    }

    public String getValue(int base) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your input number:");
        while (true) {
            String value = sc.nextLine();
            switch (base) {
                case 1:
                    if (value.matches("[0-1]+")) {
                        return standard(value);
                    }
                    break;
                case 2:
                    if (value.matches("[0-9]+")) {
                        return standard(value);
                    }
                    break;
                case 3:
                    if (value.matches("[0-9a-fA-F]+")) {
                        return standard(value);
                    }
                    break;
            }
            System.out.println("Invalid type, please input again: ");
        }
    }
}
