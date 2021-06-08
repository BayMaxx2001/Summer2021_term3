
public class App {
    static int [] a = { -1, 2, 100, 5, -10, 3 , -4};
    static char [] s = { 'a', 'b', 'c', 'd','c', 'b', 'a'};
    final static int MAX_INT = 9999999;
    private static int SUM(int i) {
        if ( i == 0) 
            return 0;
        return i+SUM(i-1);
        
    }
    private static int findmin(int a[], int n){
        if ( n == 0 ) return MAX_INT;
        if ( n == 1 ) return a[0];

        return Math.min(a[n-1],findmin(a,n-1)); 
    }
    private static int findsum(int a[], int n){
        if ( n == 0 ) return 0;
        if ( n == 1 ) return a[0];
        
        return (a[n-1]+findsum(a,n-1)); 
    }
    private static int isPalindrome( char a[], int start, int end){
        if ( start >= end ) return 1; 
        if ( a[start] != a[end] ) return 0;
        
        return isPalindrome(a,++start,--end);
    }
    private static int binarySearch(int arr[], int l, int r, int x){
        if (r >= l) {
            int mid = (l+r)>>1;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    private static void merge(int arr[], int l, int m, int r){
       
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    private static int[] sort(int arr[], int l, int r){
        if (l < r) {
            int m =l+ (r-l)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }
    private static int GCD( int x , int y){
        if ( y == 0 ) return x ;
        return GCD(y,x%y);
    }
    private static int pow(int x, int n) {
        if (n == 0) return 1;
        int temp = pow(x, n/2);
        if (n % 2 == 0) 
            return temp * temp;
        return temp * temp * x;
    }
    private static int fact (int n) {
        if ( n <= 1 ) return 1; 
        return n*fact(n-1);
    }
    private static int Fibonacci(int n){
        if ( n <=2  ) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    private static double addReciprocals(int n){
        double zero = 0.0, _n = n;
        if(n==0) 
            return zero;
        return (double)(1/_n) + addReciprocals(n-1);
    }
    private static int StirlingNumbers(int n,int k){
        if ( n == 0 && k == 0 ) return 1 ; 
        if ( n > 0 && k == 0 ) return 0;
        if (k == 1 || k == n) return 1;
        return StirlingNumbers(n-1,k-1) + k*StirlingNumbers(n-1,k);
    }
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //sum of all numbers from 1 to n 
        System.out.println(SUM(3));

        //minimum element in an array
        System.out.println(findmin(a,a.length));

        //sum of all elements in an array
        System.out.println(findsum(a,a.length));

        //determines whether an array is a palindrome
        System.out.println(isPalindrome(s,0,s.length-1));
        
        //sort array
        a=sort(a, 0, a.length-1);
        for ( int i=0;i<a.length;i++) {
            System.out.print(a[i] + " " );
        }
        System.out.println("");
        
        //searches for a target in a sorted array using binary search
        System.out.println(binarySearch(a,-1,a.length,100));
        
        //GCD
        System.out.println(GCD(20,4));
        
        //fact
        System.out.println(fact(4));
        
        //fibo
        System.out.println(Fibonacci(5));
        
        //Reciprocals
        System.out.println(addReciprocals(4));
        
        //StirlingNumbers
        System.out.println(StirlingNumbers(5,3));
        
        binaryTree bt = new binaryTree();
        bt.root = new Node(3);
        bt.root.left = new Node(4);
        bt.root.right = new Node(4);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(2);
        System.out.println("The size of binary tree is : " + bt.size());
        System.out.println("The height of binary tree is : " + bt.height());
    }

}
