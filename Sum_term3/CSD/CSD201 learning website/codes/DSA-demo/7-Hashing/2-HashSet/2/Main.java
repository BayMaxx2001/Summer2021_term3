import java.util.*;
//==================================================
public class Main
 {public static void main(String args[])
   {
    String elements[] = { "A", "B", "C", "D", "E" };
    Set set = new HashSet(Arrays.asList(elements));

    elements = new String[] { "A", "B", "C", "D" };
    Set set2 = new HashSet(Arrays.asList(elements));

    System.out.println(set.equals(set2));
   }
 }
