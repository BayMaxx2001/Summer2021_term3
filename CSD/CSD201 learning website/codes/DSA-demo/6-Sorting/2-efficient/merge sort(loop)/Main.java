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
    Tr.gian:b la danh sach tam dung khi tron, k la chi so cua danh sach nay
	    size la kich thuoc cua danh sach con, o buoc 1 size = 1,
	    buoc 2 size = 2, buoc 3 size = 4,...
	    low1,up1,low2,up2 la can duoi va can tren cua 2 danh sach dang tron
    Output: Danh sach da duoc sap xep
   */
  void mergeSort()
    {int i,j,k,low1,up1,low2,up2;//Can duoi va tren cua 2 ds con
     int size;
     int [] b=new int[n];
     size=1;//Buoc tron 1: gan size bang 1
     while(size<n)
      {low1=0;k=0;

        while(low1+size<n)
         {low2=low1+size;
          up1=low2-1;
          up2=(low2+size-1<n)? low2+size-1 : n-1;

          /*Cho i quet tu low1 den up1, j quet tu low2 den up2. Voi moi i va j
	    so sanh va chon phan tu nho hon chuyen sang danh sach tam.
          */
          for(i=low1,j=low2;i<=up1 && j<=up2;k++)
	    if(a[i]<=a[j])
               b[k]=a[i++];
	        else
                 b[k]=a[j++];;

          /*Vi so phan tu duoc chon tu 2 ds khong nhu nhau nen co the i hoac
	    j se den dich truoc. Trong truong hop nay ta chuyen phan con lai
	    cua day chua quet xong sang ds tam
          */
          for(; i <= up1; k++) b[k] = a[i++];
          for(; j <= up2; k++) b[k] = a[j++];
          low1 = up2+1;
         } //while(low1+size<n)

        /*Neu so ds con la so le thi khi tron tung cap se con lai ds cuoi
          cung. Ta phai chuyen danh sach nay sang ds tam
        */
        for(i = low1; k < n; i++) b[k++] = a[i];
        for(i = 0; i < n; i++) a[i] = b[i];
        size *= 2;//Tang co cua danh sach con len 2 lan.
      } // end of size<n
    }
 }
//==================================================
public class Main
 {public static void main(String args[])
   {int [] b = {7,3,5,9,11,8,6,15,10,12,14};
    EffSort t = new EffSort(b);
    t.mergeSort();t.display();
    System.out.println();
   }
 }
