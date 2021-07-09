import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Valadition {

    private static final Scanner sc = new Scanner(System.in);
    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int rerult = Integer.parseInt(sc.nextLine().trim());
                if (rerult < min || rerult > max) {
                    throw new NumberFormatException();
                }
                return rerult;
            } catch (NumberFormatException e) {
                System.err.println("Plesae enter in range [" + min + "-" + max + "]!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString(String message) {
        System.out.print(message);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input Empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String checkInputTaskType(String message) {
        System.out.print(message);
        int type = Valadition.checkInputLimit(1, 4);
        String taskType = null;
        switch (type) {
            case 1:
                taskType = "Code";
                break;
            case 2:
                taskType = "Test";
                break;
            case 3:
                taskType = "Design";
                break;
            case 4:
                taskType = "Review";
                break;
        }
        return taskType;
    }

    public static String checkInputDate(String message) {
        System.out.print(message);
        while (true) {
            String result = checkInputString("");
            SimpleDateFormat spd = new SimpleDateFormat("dd-MM-yyyy");
            spd.setLenient(false);
            try {
                Date date = spd.parse(result);
                return result;
            } catch (Exception e) {
                System.err.println("Date must be format dd-MM-yyyy");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputPlan(double min, double max, String err) {
        while (true) {
            String result = checkInputString("");
            try {
                double time = Double.parseDouble(result);
                if (time >= min && time <= max && (time % 0.5 == (int)time % 0.5) ) {
                    return time;
                } else {
                    System.err.println(err);
                    System.out.print("Re-input: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Time must be 8.0, 8.5, 9.0, ...");
                System.out.print("Enter again: ");
            }
        }
    }

}
