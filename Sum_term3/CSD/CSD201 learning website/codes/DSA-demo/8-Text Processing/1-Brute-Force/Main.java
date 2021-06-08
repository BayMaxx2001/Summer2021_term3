class StringMatching {
   int bruteForceSearch(char [] a, char [] p)  { // a: text, p: sample string to be searched
      int i,j,m,n;
      n=a.length;
      m=p.length;
      i=0;j=0;
      while (i<n && j<m) {
           if(a[i]==p[j]) {
              i++;j++;
            } 
           else {
             i=i-j+1;
             j=0;
         }
      }

    if(j==m) //j reaches m-1, it means that p is found in a
      return(i-m);
       else
       return(-1);
   }
 void testSearching(String a, String p) { // a: text, p: sample string to be searched
    char [] a1 = a.toCharArray();
    char [] p1 = p.toCharArray();
    int k;
    k = bruteForceSearch(a1,p1);
    System.out.println(a);
    System.out.println(p);
    if(k==-1)
       System.out.println(p + " is not found in " + a);
         else
         System.out.println(p + " is found at index " + k + " in " + a);

  }
 }
public class Main {
  public static void main(String args[]) {
    StringMatching t = new StringMatching();    
    String a = "0123456789";
    String p = "567";
     t.testSearching(a,p); 
    System.out.println();
   }
 }
