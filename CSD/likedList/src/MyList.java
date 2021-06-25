public class MyList {
    Node head;
    Node tail;
    int size = 0;
    //constructer
    public MyList() {
        head = null;
        tail = null;
        int size = 0;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    void deleteAll()
    {
        head = null;
        tail = null;
        int size = 0;
    }

    //1 
    void addToTail(int a) {
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

    //2
    void addToHead(int a) {
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

    //3
    void addNodeAfter(Node p, int x) {
        if (isEmpty()) {
            return;
        }
        
        if ( p == tail ) 
        {
            addToTail(x);
            return ; 
        }
        Node after = new Node();
        Node add = new Node(x);
        after = p.next;

        p.next = add;
        add.next = after; 
        
        size++;
    }

    //4
    void display() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.infor + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    //5
    int deleteFromHead() {
        int res = head.infor;
        if (isEmpty()) {
            return (Integer) null;
        }
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            size--;
        }
        return res;
    }

    //6
    int deleteFromTail() {
        int res = tail.infor;

        if (isEmpty()) {
            return (Integer) null;
        }
        if (head == tail)
            head = tail = null;
        else {
            Node tmp = new Node();
            tmp = head;
            while (tmp.next != tail) {
                tmp = tmp.next;
            }
            tail=tmp;
            tail.next = null;
            size--;
        }
        return res;
    }

    //7
    int deleteAfter(Node p) {
        if (isEmpty())
            return (Integer) null;
        Node tmp = new Node();
        tmp = p.next;
        if (tmp != null) {
            deleteNode(tmp);
            size--;
            return tmp.infor;
        }
        else
            return (Integer) null;
        
    }
    void deleteAll(int x)
    {
        Node p = head;
        while (p != null) 
        {
            if (p.infor == x)
                delete(p.infor);
            p = p.next;
        }
    }
    //8
    void delete(int x) {
        if (isEmpty())
            return;
        if ( head.infor == x ) 
        {
            deleteFromHead();
            return;
        }
        Node tmp = new Node();
        Node pre = new Node();
        tmp = head.next;
        pre = head;
        while (tmp != null && tmp.infor != x) {
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

    //9
    Node search(int x) {
        Node p = head;
        while (p != null) 
        {
            if (p.infor == x)
                return (p);
            p = p.next;
        }
        return (null);
    }

    //10
    int count() {
        return size;
    }

    //11
    void deleteByID(int index) {
        int count = 1;
        Node p = new Node();
        p = head;
        while (p != null) {
            if (count == index) {
                size--;
                deleteNode(p);
                break ;
            }
            p = p.next;
            count++;
        }
    }

    //12
    Node sortedMerge(Node a, Node b) {
        Node result = null;
        
        if (a == null)
            return b;
        if (b == null)
            return a;

       
        if (a.infor <= b.infor) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    //12
    void mergeSort()
    {
        mergeSort(head);
    }
    Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextofmiddle);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    //12
    Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //13
    void deleteNode( Node p) {
        if (isEmpty())
            return;
        if ( p == head ) 
        {
            deleteFromHead();
            return;
        }
        Node tmp = new Node();
        Node pre = new Node();
        tmp = head.next;
        pre = head;
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
    //14
    int[] toArray(){
        int[] res = {};
        int cnt = -1; 
        Node p = new Node();
        p = head ; 
        while ( p != null ) 
        {
            res[++cnt] = p.infor;
            p = p.next;
        }
        return res;
    }

    //15
    Node Merge_list(MyList l1 , MyList l2)
    {
        Node res = new Node();
        res = concatList(l1, l2);
        res = mergeSort(res);
        return res; 
    }

    //16
    void addBefore(Node p , int x ){
        if ( isEmpty() ) return;
        Node current = head;
        if ( p == head ) {
            addToHead(x);
            return ; 
        }
        while( current.next != null )
        {
            if( current.next == p )
            {
                Node n = new Node(x);
                n.next = current.next;
                current.next = n;
                size ++ ; 
                return;
            }
            current = current.next;
        }
    }

    //17
    Node concatList(MyList m1, MyList m2) {
        m1.tail.next = m2.head;
        m1.tail = m2.tail;
        m2.head = m1.head;
        return m1.head;
    }    
    
    //18
    int max() {
        int res = Integer.MIN_VALUE;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            res = Math.max(res, tmp.infor);
            tmp = tmp.next;
        }
        return res;
    }
    int maxSecond()
    {
        int max = max();
        int res = -100000000;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            if ( tmp.infor != max )
                res = Math.max(res, tmp.infor);
            tmp = tmp.next;
        }
        return res;
    }

    //19
    int min() {
        int res = Integer.MAX_VALUE;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            res = Math.min(res, tmp.infor);
            tmp = tmp.next;
        }
        return res;
    }

    //20
    int sum() {
        int sum = 0;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            sum += tmp.infor;
            tmp = tmp.next;
        }
        return sum;
    }

    //21
    int avg() {
        return sum() / size;
    }

    //22
    boolean isSorted(MyList origin) {
        MyList change = origin;
        change.head=change.mergeSort(change.head);

        Node tmp_change = new Node();
        tmp_change = change.head;
        Node tmp_origin = new Node();
        tmp_origin = origin.head;

        while (tmp_change != null) {
            if (tmp_change.infor != tmp_origin.infor)
                return false;
            tmp_change = tmp_change.next;
            tmp_origin = tmp_origin.next;
        }
        return true;
    }

    //23
    void insert(int x){
        addToHead(x);
        head = mergeSort(head); 
    }

    //24
    Node reverse(Node node)
    {
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

    //25
    public boolean checkSame(MyList l1 , MyList l2 ) {

        Node tmp_l1 = new Node();
        tmp_l1 = l1.head; 
        Node tmp_l2 = new Node();
        tmp_l2 = l2.head;

        while (tmp_l1 != null) {
            if (tmp_l1.infor != tmp_l2.infor)
                return false;
            tmp_l1 = tmp_l1.next;
            tmp_l2 = tmp_l2.next;
        }
        return true ; 
    }
    public void sort(int indexStart , int indexEnd)
    {
        if(isEmpty()) return ;
        Node startNode = head;
        if(indexStart>=indexEnd) return;
        if(indexEnd >size) return ;
        int cnt = 1;
        while(true)
        {
            if(cnt==indexStart) break;
            startNode = startNode.next;
            cnt++;
        }
        Node cur = startNode;
        Node after = null;
        indexEnd -= indexStart;
        while(true)
        {
            boolean swapped = false;
            cnt = 0;
            cur=startNode;
            while(cur!=null)
            {
                if(cnt+1 >indexEnd) break;
                after = cur.next;
                if(cur.infor>after.infor)
                {
                    int tmp = cur.infor;
                    cur.infor = after.infor;
                    after.infor = tmp;
                    swapped = true;
                }
                cnt++;
                cur = cur.next;
                if(cnt==indexEnd) break;
            }
            if(!swapped) break;
        }
    }
}