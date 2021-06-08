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
//--------------------------------------------------
  void swap(int [] a, int i, int k) // Swap element at position i with element at position k 
   {int x; x=a[i];a[i]=a[k];a[k]=x;
   }
//==================================================
  /*CAI DAT GIAI THUAT QUICKSORT}
    Thu tuc partition se phan hoach danh sach tu low den up thanh 2 phan:
    cac nut co noi dung <= a[pivot] nam ben trai pivot, cac nut co
    noi dung > a[pivot] nam ben phai.
    Chon nuttruc=a[low], quet 2 dau lai, i tu duoi len, j tu tren xuong,
    va doi cho cac cap phan tu sai cho, khi ket thuc quet thi doi cho a[low]
    va a[j], vay nut truc se chuyen den vi tri j*/
  int partition(int low,int up) // return pivot index
   {int pivot,pivotval;
     pivotval=a[low];//Chon nut dau lam truc
    int i=low;
    int j=up;
    while(i<j) //Bat dau quet
      {while(a[i]<=pivotval && i<up) i++; //a[i]>pivotval
      while(a[j]>pivotval)  j--;         //a[j]<=pivotval
      if(i<j) swap(a,i,j); //Doi cho cap nut sai vi tri
     };
     /*Sau vong lap ta co i>=j, cac phan tu tu low den j deu <=pivotval
      cac phan tu tu j+1 deu > pivota, thi du
      0  1  2  3  4
      3  7  2  1  6  i=1 j=3 (a[1]=7>pivotval,(a[3]=1<=pivotval)
      3  1  2  7  6  i=3 j=2 (a[3]=7>pivotval,(a[2]=2<=pivotval)
      ta chuyen pivotval den vi tri j de bao dam rang pivotval
      o dung vi tri trong day, tuc la cac phan tu ben trai
      deu nho hon hoac bang, cac phan tu ben phai lon hon*/
    swap(a,low,j);
    pivot=j;
    return(pivot);
   }
  //-----------------------------------------------------
  void quickSort(int low,int up)
   {int pivot;
    if(low>=up) return;
    pivot=partition(low,up);
    quickSort(low,pivot-1);
    quickSort(pivot+1,up);
   }
  //-----------------------------------------------------
  void quickSort()
   {quickSort(0,n-1);
   }
 }
//==================================================
public class Main
 {public static void main(String args[])
   {int [] b = {7,3,5,9,11,8,6,15,10,12,14};
    EffSort t = new EffSort(b);
    t.quickSort();t.display();
    System.out.println();
   }
 }
