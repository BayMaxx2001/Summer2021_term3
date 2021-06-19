public class Node {
    int infor ;
    Node next;
    public Node(){

    }
    public Node(int infor, Node next) {
        this.infor = infor;
        this.next = next;
    }


    public Node(int x) {
        this.infor = x ;
        next = null ; 
    }
    
}
