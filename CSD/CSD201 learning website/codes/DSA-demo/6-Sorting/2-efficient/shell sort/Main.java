import java.util.*;
class EffSort
 {int [] a; int n;
  EffSort() {}
  EffSort(int [] b)
   {int i;
    n = b.length;
    a = new int[n];
    for(i=0;i<n;i++) a[i]= b[i];
   }
  void setData(int [] b)
   {int i;
    n = b.length;
    a = new int[n];
    for(i=0;i<n;i++)
       a[i]= b[i];
   }
  void display()
   {int i;
    for(i=0;i<n;i++)
      System.out.print("  " + a[i]);
    System.out.println();
   }
//==================================================
  // shell sort
  void insertSort2(int h)
   {int i,j,x;
    for(i=h;i<n;i++)
      {x=a[i];
       j=i;
       while(j-h>=0 && x<a[j-h])
         {a[j]=a[j-h];//Keo nut lon hon x len h vi tri
          j=j-h;
         };
       a[j]=x;
      }
   };
  void shellSort(int [] step)
   { /*Cac buoc tang la step[0],step[1],...,step[stepnum] trong do
       step[0]>step[1]>...>step[stepnum]  */
    int h,i,stepnum;
    stepnum = step.length;
    for(i=0;i<stepnum;i++)
     {h=step[i];
      insertSort2(h);
     }
   };
  void shellSort()
   {int [] step = {5,3,1};
    shellSort(step);
   };
 }
//==================================================
public class Main
 {public static void main(String args[])
   {int [] b = {7,3,5,9,11,8,6,15,10,12,14};
    EffSort t = new EffSort(b);
    t.shellSort();t.display();
    System.out.println();
   }
 }
