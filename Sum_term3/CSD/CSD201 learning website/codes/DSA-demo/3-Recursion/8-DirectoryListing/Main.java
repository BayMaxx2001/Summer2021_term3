import java.io.File;
public class Main
  {static int level = 0;
   public static void display(File f)
    {System.out.println(" " + f.getName());
     if(f.isDirectory())
       {String [] a = f.list();
        for(int i = 0; i < a.length; i++)
          {display(new File(f, a[i]));
	  }
       }
    }

   public static void main(String [] args)
     {//String DirOrFileName = "data\\two.txt";
      String DirOrFileName = "data";
      File f = new File(DirOrFileName);
      if(f.isDirectory())
        System.out.println(" Contents of " + DirOrFileName + " directory are:");
         else
          System.out.println(" Name of file is:");
      display(f);
      
      System.out.println();
     }
  }
