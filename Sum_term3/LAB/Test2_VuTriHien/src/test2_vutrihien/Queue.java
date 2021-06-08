/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_vutrihien;

public class Queue {
    Node front, rear;
    int size = 0; 
    public Queue()
    {
        this.front = this.rear = null;
        size = 0;
    }
    boolean isEmpty(){
        return (front == null);
    }
     // Method to add an key to the queue.
    void enqueue(Node temp)
    {
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    //get front && pop    
    Node dequeue()
    {
        if (this.front == null)
            return null ;
  
        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
        
        return temp;
    }
    
}
