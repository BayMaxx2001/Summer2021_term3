/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadDataToLast(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

    void loadDataToFirst(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("person.txt", k);
        int[] b = Lib.readLineToIntArray("person.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addFirst(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        Person p = new Person(xName, xAge);
        if ( xName.startsWith("B")) return;
        addLast(p);
    }
    public void addLast(Person a) {
        Node p = new Node(a);
        if (isEmpty()) {
            head = p;
            tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
    public void addFirst(Person a) {
        Node p = new Node(a);
        if (isEmpty()) {
            head = p;
            tail = p;
       
            return;
        }
        p.next = head;
        head = p;
    }
    void addFirst(String xName, int xAge) {//You should write here appropriate statements to complete this function.
        Person p = new Person(xName, xAge);
        if ( xName.startsWith("B")) return;
        addFirst(p);
    }
    
//=================================================================
    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadDataToLast(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f2() throws Exception {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
         */
        clear();
        loadDataToFirst(1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void addLastWithCondition(Person a) {
        Node p = new Node(a);
        if ( a.age <= 4 ) return; 
        if (isEmpty()) {
            head = p;
            tail = p;
            return;
        }
        
        tail.next = p;
        tail = p;
    }
    void f3() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        
        MyList h = new MyList();
        Node p = head;
        while (p != null) {
            h.addLastWithCondition(p.info);
            p = p.next;
            
        }
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //-------------------------------------------------------------------------------------
        h.ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }
    public void deleteFirstCondition(){
        Node p = head;
        int count = 0 ; 
        while(p != null){
                if(p.info.age<6) 
                {
                    dele(p);
                    count ++ ; 
                    if ( count == 2 )
                        return;
                }
                p=p.next;
        }
    }
    void f4() throws Exception {
        clear();
        loadDataToLast(4);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //-------------------------------------------------------------------------------------
        deleteFirstCondition();
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    public void sort(){
        Node pi,pj; Person x;
        pi=head;
        while(pi!=null){
                pj=pi.next;
                while(pj!=null){
                        if(pj.info.name.compareTo(pi.info.name)<0){
                                x=pi.info;pi.info=pj.info;pj.info=x;
                        }
                        pj=pj.next;
                }
                pi=pi.next;
        }
    }
    public void sortIndex(int indexStart, int indexEnd) {
        if (isEmpty()) {
            return;
        }
        Node startNode = head;
        int cnt = 1;
        while (true) {
            if (cnt == indexStart) {
                break;
            }
            startNode = startNode.next;
            cnt++;
        }
        Node cur = startNode;
        Node after = null;
        indexEnd -= indexStart;
        while (true) {
            boolean swapped = false;
            cnt = 0;
            cur = startNode;
            while (cur != null) {
                if (cnt + 1 > indexEnd) {
                    break;
                }
                after = cur.next;
                //if (cur.infor.compareTo(after.infor) > 0) {
                if (cur.info.age > after.info.age) {
                    Person tmp = cur.info;
                    cur.info = after.info;
                    after.info = tmp;
                    swapped = true;
                }
                cnt++;
                cur = cur.next;
                if (cnt == indexEnd) {
                    break;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    void f5() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sortIndex(1, 4);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list 
    void printList(Node node) {
        while (node != null) {
            node = node.next;
        }
    }
    void reverseIndex(int st , int en){
        MyList h = new MyList();
        Node p = head;
        int count = 0;
        MyList l = new MyList();
        MyList r = new MyList();
        while (p != null ) 
        {
            if(count >= st && count <= en) 
            {
                h.addLast(p.info);
            }
            if ( count < st )
            {
                l.addLast(p.info);
            }
            if ( count > en )
            {
                r.addLast(p.info);
            }
            count ++ ; 
            p = p.next;
        }
        
        appendAnotherList(l);
        appendAnotherList(h);
        appendAnotherList(r);
        
        
    }
    void f6() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        head = reverse(head);
        ftraverse(f123);
        reverseIndex(3, 6);
        //--------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void appendAnotherList(MyList h) {
        Node p = h.head;
        while (p != null) {
            addLast(p.info);
            p = p.next;
        }
    }
    void f7() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        MyList h = new MyList();
        h.loadDataToLast(7);
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        appendAnotherList(h);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    Node deleteFromHead() {
        Node res = head;
        if (isEmpty()) {
            return null;
        }
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
          
        }
        return res;
    }
    void deleteNode( Node p) {
        if (isEmpty())
            return;
        if ( p == head ) 
        {
            deleteFromHead();
            return;
        }
        Node tmp = head.next;
        Node pre = head;

        while (tmp != null && !tmp.equals(p)) {
            tmp = tmp.next;
            pre = pre.next;
        }
        if (tmp != null) {
            pre.next = tmp.next;
            if (tmp == tail)
                tail = pre;// if x in the last node
        }
    }
    
    public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            Node p = head;
            head = head.next;
            p.next = null;
        } else {
            int count = 1;
            Node p = head;
            while (p!= null && count < k) {
                    p = p.next;
                    count ++;
            }
            if ( p != null)
                deleteNode(p);
        }
    }
    
    
    void f8() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        int k = 3;
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteAt(k+1);
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

//=================================================================
    void f9() throws Exception // sort by name
    {
        clear();
        loadDataToLast(4);
        String fname = "f9.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        ftraverse(f123);
        String xName = "C6";
        String yName = "CX";
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
        while(p!=null) 
        {
            if ( p.info.name.equals(xName) == true)
            {
                p.info.name = yName;
                break ;
            }
            p = p.next; 
        }
        //-------------------------------------------------------------------------------------
        ftraverse(f123);
        f123.close();
    }

}
