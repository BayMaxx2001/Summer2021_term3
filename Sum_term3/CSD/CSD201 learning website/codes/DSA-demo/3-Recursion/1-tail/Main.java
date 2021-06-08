public class Main
  {public static void tail(int i)
     {if(i>0)
        {System.out.print(i + "  ");
             tail(i-1);
        }
     }
   public static void main(String [] args)
     {tail(5);
      System.out.println();
     }
  }
/*
Tail recursion is characterized by the use of only one recursive call
at the very end of a method implementation.
*/