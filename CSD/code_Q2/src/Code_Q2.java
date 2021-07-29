
public class Code_Q2 {

    /**
     * @param args the command line arguments
     */
    static void fun(int n) {
        if (n > 0) {
            System.out.println(" " + n % 5);
            fun(n);
        }
    }

    static void f(int n) {
        if (n == -5)
            return;
        System.out.println(" " + n % 3);
        f(n - 3);
    }

    static int hh(int n)

    {
        if (n == 0 || n == 1)
            return (1);

        else
            return (hh(n - 1) + hh(n - 2));

    }

    static void quiz(int n) {
        if (n > 1) {
            quiz(n / 2);
            quiz(n / 2);
        }
        System.out.print("* ");
    }

    public static void main(String[] args) {
        // System.out.println(hh(3));
        quiz(5);
    }

}
