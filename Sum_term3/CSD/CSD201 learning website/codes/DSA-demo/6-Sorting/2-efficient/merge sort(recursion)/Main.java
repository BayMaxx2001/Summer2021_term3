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
  /*Sap xep danh sach theo thu tu tang dan bang phuong phap
    Merge Sort.
    Input:  Day a[0],a[1],...,a[n-1]
    Output: Danh sach da duoc sap xep
   */
  void mergeSort(int p, int r)
    {if(p>=r) return;
      int q = (p+r)/2;
      mergeSort(p,q);
      mergeSort(q+1,r);
      merge(p,q,r);
    }

  void merge(int p, int q, int r)
    {if(!(p<=q) && (q<=r)) return;
      int n,i,j,k,x; n = r-p+1;
      int [] b = new int[n];
      i=p;j=q+1;k=0;
      while(i<=q && j<=r)
        {if(a[i]<a[j])
           b[k++] = a[i++];
            else
             b[k++] = a[j++];
        } 
      while(i<=q)  b[k++] = a[i++];
      while(j<=r)  b[k++] = a[j++];
      k=0;
      for(i=p;i<=r;i++) a[i] = b[k++];
    }
 }
//==================================================
public class Main
 {public static void main(String args[])
   {int [] b = {7,3,5,9,11,8,6,15,10,12,14};
    EffSort t = new EffSort(b);
    int n=b.length;
    t.mergeSort(0,n-1);t.display();
    System.out.println();
   }
 }
