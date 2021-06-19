import java.util.*;
class Queen
  { int n,count;
    boolean  a[], b[], c[];
    int x[];
    Scanner in;
    Queen()
      { x = new int[20];
        a = new boolean[20];
        b = new boolean[40];
        c = new boolean[40];
        in = new Scanner(System.in);
      }

    void init()
      { int i;
        System.out.print(" n = ");n = in.nextInt();
        count=0;
        for(i=1;i<=n;i++) a[i] = true;
        for(i=1;i<=2*n;i++) b[i] = true;
        for(i=1;i<=2*n;i++) c[i] = true;
      }

    void result()
      { int i;
        System.out.printf("\n%3d: ",++count);
        for(i=1;i<=n;i++) System.out.printf("%4d",x[i]);
      }

    void test(int i)
      { int j;
        for(j=1;j<=n;j++)       //..........................(1)
          { if(a[j] && b[i+j] && c[i-j+n]) //...............(2)
              { x[i]=j;
                //Ghi nhan trang thai moi
                a[j]=false;b[i+j]=false;c[i-j+n]=false; //..(3)
                if(i==n) result(); else test(i+1);//........(4)
                //Tra lai trang thai cu
                a[j]=true;b[i+j]=true;c[i-j+n]=true;//......(5)
              }
          }
      }
  }
//=============================
public class Main
  {
    public static void main(String [] args)
       { Queen t = new Queen();  
          t.init();
          t.test(1);
          System.out.println();
       }
  }
/*
Lan luot tim cac vi tri quan hau tren cot 1, cot 2, ..., cot n
sao cho khong co hai 2 quan hau nao tan cong duoc nhau,
tuc la khong co hai quan hau nao nam tren cung hang, cung cot
hoac cung duong cheo.
*/
