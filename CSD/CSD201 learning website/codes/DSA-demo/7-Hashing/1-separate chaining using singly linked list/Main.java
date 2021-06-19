import java.util.*;
public class Main
 {public static void main(String args[])
   {Scanner s = new Scanner(System.in);
    int choice, x; Node p;
    int [] b = {5,7,11,3,9,2,6,5,17,23,92,25};
    HashTable t = new HashTable();
    t.addArray(b);
    while(true)
      {System.out.println("\n Choose your option:");
       System.out.println("  1. Create a list randomly");
       System.out.println("  2. Display a list");
       System.out.println("  3. Search");
       System.out.println("  4. Delete");
       System.out.println("  0. Exit\n");
       System.out.print("  Your selection (0 -> 4): ");
       choice = s.nextInt();
       if(choice==0)
        {System.out.println(" Good bye, have a nice day!");
         break;
        }
       switch(choice)
        {case 1: t.addRandom();
                 t.traverse();
                 break;
         case 2: t.traverse();
                 break;
         case 3: System.out.print("\n Enter value to be searched: ");
                 x = s.nextInt();
                 p = t.search(x);
                 if(p!=null)
                  System.out.println(x + " is found in the list");
                   else 
                    System.out.println(x + " is not found in the list");
                 break;
         case 4: System.out.print("\n Enter value to be deleted: ");
                 x = s.nextInt();
                 t.dele(x);
                 t.traverse();
                 break;
         default: System.out.println("**Invalid choice. Try again.**");
        }
      }
   }
 }
