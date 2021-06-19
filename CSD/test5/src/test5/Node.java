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
public class Node {
    Song infor ;
    Node next;
    public Node(){

    }
    public Node(Song infor, Node next) {
        this.infor = infor;
        this.next = next;
    }


    public Node(Song x) {
        this.infor = x ;
        next = null ; 
    }

    void display() {
        System.out.println(infor.songName + "|" + infor.Artist + "|" + infor.rated);
    }
    
}
