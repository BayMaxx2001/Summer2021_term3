/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test5;

/**
 *
 * @author BayMaxx
 */
public class MyListSong {
    Node head;
    Node tail;
    int size = 0;
    //constructer
    public MyListSong() {
        head = null;
        tail = null;
        int size = 0;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public void addToHead(Song x) {
        if (size == 0) {
            head = tail = new Node(x);
            size = 1;
        } else {
            Node p = new Node(x);
            p.next = head;
            head = p;
            size++;
        }
    }

    void addToTail(Song x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = p;
            tail = p;
            size = 1;
        } else {
            tail.next = p;
            tail = p;
            size++;
        }
    }

    public void traverse() {
        System.out.print("Display list: ");
        if (size == 0) {
            System.out.print("List is empty");
        } 
        else {
            Node curNode = head;
            while (curNode != null) {
                curNode.display();              
                curNode = curNode.next;
            }
            System.out.println("");
        }
    }
    public String saveFile() {
        String ans = "";
        ans = ans + "Display list: \n";
        
        if (size == 0) {
            ans = ans + "List is empty";
        } 
        else {
            Node curNode = head;
            while (curNode != null) {
                ans = ans + curNode.infor.songName + "|" + curNode.infor.Artist + "|" + curNode.infor.rated + "\n";              
                curNode = curNode.next;
            }
            ans = ans +"\n";
        }
        return ans; 
    }
    public void findMax(){
        int res = Integer.MIN_VALUE;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            res = Math.max(res, tmp.infor.rated);
            tmp = tmp.next;
        }
        tmp = head; 
        while ( tmp != null ) {
            if ( tmp.infor.rated == res) 
                tmp.display();
            tmp = tmp.next;
        }
    }
    void deleteFromHead() {
        
        if (isEmpty()) {
            return;
        }
        if (head == tail)
            head = tail = null;
        else {
            head = head.next;
            size--;
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
    public void deleteSecond(){
        int res = Integer.MIN_VALUE;
        Node tmp = new Node();
        tmp = head;
        while (tmp != null) {
            res = Math.max(res, tmp.infor.rated);
            tmp = tmp.next;
        }
        tmp = head; 
        int second = head.infor.rated;
        while (tmp != null) {
            if ( tmp.infor.rated != res) 
                second = Math.max(second, tmp.infor.rated);
            tmp = tmp.next;
        }
        //System.out.println(second + " |||" + res );
        tmp = head; 
        while ( tmp != null ) {
            if ( tmp.infor.rated == second) 
                deleteNode(tmp);
            tmp = tmp.next;
        }
    }
    
}
