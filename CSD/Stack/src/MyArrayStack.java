public class MyArrayStack{
    int n; 
    int[] a;
    final int MAX = 10000; 
    MyArrayStack(){
        n=-1;
        a = new int[MAX];
    }
    boolean isEmpty(){
        return (n>=0);
    }
    void clear(){
        n = -1;
    }

    void push(int x){
        if ( n > MAX) return ; 
        a[++n]= x;
    }
    void pop(){
        if ( n >= 0 )
            n--;
        else {
            throw new java.util.EmptyStackException();
        }
    }
    int top(){
        if ( isEmpty())  
            throw new java.util.EmptyStackException();
        return a[n];
    }
    void traverse(){
        while(!isEmpty()) {
            System.out.println(top());
            pop(); 
        }
    }
}