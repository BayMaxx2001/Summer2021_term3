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
  /*Sap xep bang HEAP: Heap la cay nhi phan gan day duoc cai dat bang
    mang mot chieu voi cac nut tren heap co noi dung nho hon nut goc
    va cac nhanh cay con cung la cac heap
  */
  void heapSort()
   {/*Chuyen danh sach thanh HEAP bang cach xem khoi dau heap gom nut
      a[0], sau do lan luot chuyen cac nut a[1],a[2],...,
      a[n-1] vao heap*/
    int i,s,f;int x;
    for(i=1;i<n;i++)
     {x=a[i];//Nut can them vao HEAP, ban dau heap co mot nut a[0].
          /*Insert x vao vi tri thich hop cua HEAP: xuat phat tu i, di dan ve
            goc de tim mot vi tri nut cha thich hop. Vay f se giam dan
          */
      s=i; //s la nut con, hien tai tren heap chua co a[i]
       //f=(s-1)/2 la nut cha
      while(s>0 && x>a[(s-1)/2])
        {a[s]=a[(s-1)/2]; //Keo nut < x xuong 1 muc
         s=(s-1)/2;
        };
      a[s]=x; //Dua nut x vao vi tri phu hop
     };
    //Ket thuc chuyen danh sach thanh heap
    System.out.println(" Heap:");
    display();
    //Lan luot xoa nut a[0] tren HEAP, dua ve vi tri thich hop tren ds
    for(i=n-1;i>0;i--)
     {x=a[i];a[i]=a[0];
      /*O buoc i heap co i+1 nut, la a[0], a[1],...,a[i]
        Muc dich cua chung ta la dua nut a[0] ve vi tri a[i],
        dong thoi, chen a[i] vao heap sao cho cau truc heap van bao
        toan. De lam dieu nay ta bat dau tu
        nut f = 0, theo con duong cha - con trai hoac phai, tim mot vi tri
        de chen nut a[i]. De co duoc nut trong de chen a[i], ta can
        dich cac nut tren duong di len mot muc, bang cong thuc
        nutgoc=max(contrai,conphai,a[i])
      */
      f=0; //f la nut cha, s la nut con lon hon
      s=2*f+1; //Gan s la nut con ben trai
      if(s+1<i && a[s]<a[s+1]) s=s+1;/*Neu co nut phai va
					lon hon thi chon nut phai*/
      while(s<i && x<a[s])
       {a[f]=a[s];//Con lon thay the cha
	f=s;//Chuyen den con lon tiep theo
	s=2*f+1;
	if(s+1<i && a[s]<a[s+1]) s=s+1;
       };
       a[f]=x; //Nut a[k] duoc chen dung cho
     };
   };
 }
//==================================================
public class Main
 {public static void main(String args[])
   {int [] b = {7,3,5,9,11,8,6,15,10,12,14};
    EffSort t = new EffSort(b);
    t.heapSort();t.display();
    System.out.println();
   }
 }
