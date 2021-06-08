import java.util.*;
//-------------------------------
class PriorityQueue
  { protected  float [] a; int top, max;

    public PriorityQueue() 
      { this(50);
      }

    public PriorityQueue(int max1) 
      { max = max1;
        a =  new float[max];
        top = -1;
      }
    
    protected  boolean grow()
      { int max1 = max + max/2;
        float [] a1 = new float[max1];
        if(a1 == null) return(false);
        for(int i =0; i<=top; i++)
             a1[i] = a[i];
         a = a1;
        return(true);
      }

    public boolean isEmpty()
      { return(top==-1);}

    public boolean isFull()
      { return(top==max-1);}

    public void clear()
      { top=-1;}

    public void enqueue(float x)
      { if(isFull() && !grow()) return;
        if(top==-1)
           { a[0] = x;
             top = 0;
             return;
           }
        int i = top; 
        while(i>=0 && x<a[i]) 
           {  a[i+1] = a[i];
              i--;
            }      
        a[i+1] = x;
        top++;
      }

    float front() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        return(a[top]);
      }

    public float dequeue() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        float x = a[top];
        top--;
        return(x);
      }

    public void displayAll()
      { System.out.println("Elements in the list are:");
        for(int i = 0; i<=top; i++) System.out.print(a[i] + "  ");
        System.out.println();
      }
 
  }

//=============================
public class Main
  { public static void main(String [] args)
       { int choice; float x;
         Scanner s = new Scanner(System.in);
         PriorityQueue q = new PriorityQueue();
         while(true)
            { System.out.println();
              System.out.println("1. Enqueue");
              System.out.println("2. View front");
              System.out.println("3. Dequeue");
              System.out.println("4. Display all");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be enqueued: ");
                                  x = s.nextFloat();
                                  q.enqueue(x);
                                  break;
                    case 2: System.out.println("The element at the top is  " + q.front());
                                  break;
                    case 3: System.out.println("The element dequeued  is  " + q.dequeue());
                                  break;
                    case 4: q.displayAll();
                                  break;
                  }
            }
        }
  }
