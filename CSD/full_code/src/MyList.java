
import java.util.ArrayList;


public class MyList {
    Node head, tail;
    int size = 0;
    public MyList() {
        head = null;
        tail = null;
        int size = 0;
    }
    public boolean isEmpty() {
        return head == null ;
    }
    // add node 
    public void addLast(Car a) {
        Node p = new Node(a);
        if (isEmpty()) {
            head = p;
            tail = p;
            size = 1;
            return;
        }
        tail.next = p;
        tail = p;
        size++;
    }
    
    public void addFirst(Car a) {
        Node p = new Node(a);
        if (isEmpty()) {
            head = p;
            tail = p;
            size = 1;
            return;
        }
        p.next = head;
        head = p;
        size++;
    }
    // add many
    public void addMany(String [] a, int [] b){
        int n = a.length;
        size += n;
        for(int i=0;i<n;i++) 
            addLast(new Car(a[i],b[i]));
    }
    
    // add position k 
    public void insertPositionK(Car x, int position) {
            if (isEmpty()) head = tail = new Node(x);
            int count = 1;
            Node p = head;
            while (p!= null && count < position) {
                    p = p.next;
                    count ++;
            }
            if ( p != null)
                addNodeAfter(p, x);
    } 
    void addNodeAfter(Node p, Car x) {
        if (isEmpty()) {
            return;
        }
        
        if ( p == tail ) 
        {
            addLast(x);
            return ; 
        }
        Node add = new Node(x);
        Node after = p.next;

        p.next = add;
        add.next = after; 
        
        size++;
    }
    
    //search 
    public Node search(Node x){
        Node p = head;
        while(p != null && p.info.equals(x) == false) p = p.next;
        return p;
    }
    
    public Node search(String Name){
        Node p = head;
        while(p != null){
            if(p.info.owner.equalsIgnoreCase(Name)){
                break;
            }
            p = p.next;
        }
        return p;
    }
    
    public Node search(int X){
        Node p = head;
        while (p != null) {
            if (p.info.price == X) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }
    
    //delete 
    Node deleteFromHead() {
        Node res = head;
        if (isEmpty()) {
            return null;
        }
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            size--;
        }
        return res;
    }
    
    Node deleteFromTail() {
        Node res = tail;

        if (isEmpty()) {
            return null;
        }
        if (head == tail)
            head = tail = null;
        else {
            Node tmp = head;
            while (tmp.next != tail) {
                tmp = tmp.next;
            }
            tail=tmp;
            tail.next = null;
            size--;
        }
        return res;
    }
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
            size--;
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
    void deleteAll(String x) {
        Node p = head;
        while (p != null) {
            if (p.info.owner.compareTo(x) == 0) {
                deleteNode(p);
            }
            p = p.next;
        }
    }
    public void deleteFirstCondition(){
        Node p = head;
        while(p != null){
                if(p.info.price<6) dele(p);
                p=p.next;
        }
    }
    
    public ArrayList<Car> toArray(){
        ArrayList<Car> listCar = new ArrayList<>();
        Node p = head;
        while ( p != null ) 
        {
            listCar.add(p.info);
            p = p.next;
        }
        return listCar;
    }
    
    // sort
    public void sort(){
        Node pi,pj; Car x;
        pi=head;
        while(pi!=null){
                pj=pi.next;
                while(pj!=null){
                        if(pj.info.owner.compareTo(pi.info.owner)<0){
                                x=pi.info;pi.info=pj.info;pj.info=x;
                        }
                        pj=pj.next;
                }
                pi=pi.next;
        }
    }
    void display() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.info + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public void sort(int indexStart, int indexEnd) {
        if (isEmpty()) {
            return;
        }
        Node startNode = head;
        if (indexStart >= indexEnd) {
            return;
        }
        if (indexEnd > size) {
            return;
        }
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
                if (cur.info.price > after.info.price) {
                    Car tmp = cur.info;
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
    
    int max(int upper) {
        Node p = head;
        int value = -99;
        while (p != null) {
            if ((p.info.price > value) && (p.info.price < upper)) {
                value = p.info.price;
            }
            p = p.next;
        }
        return value;

    }

    int max() {
    
        Node p = head;
        int value = -9999;
        while (p != null) {
            if (p.info.price > value) 
                value = p.info.price;
                p = p.next;
            }
            return value;
        }

    void appendAnotherList(MyList h) {
        Node p = h.head;
        while (p != null) {
            addLast(p.info);
            p = p.next;
        }
    }
    
}
