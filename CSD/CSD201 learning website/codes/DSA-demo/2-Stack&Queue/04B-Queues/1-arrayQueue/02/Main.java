import java.util.*;
//-------------------------------
class ArrayQueue
  { protected Object [] a;
    protected int max;
    protected int first, last, count;

    public ArrayQueue() 
      { this(10);
      }
    public ArrayQueue(int max1) 
      { max = max1;
        a = new Object[max];
        first = last = -1;
        count=0;
      }

    public boolean isEmpty()
      { return(count == 0);}

    public boolean isFull()
      { return(count==max);
      }

    private void grow()
       { int i;
         int max1 = max + max/2;
         Object [] a1 = new Object[max1];
         for(i=0;i<count;i++) a1[i] = a[(first+i)%max];
         a = a1;
         max = max1;
       }

    Object front() throws Exception
      { if(isEmpty()) throw new Exception();
        return(a[first]);
      }

    void enqueue(Object x)
      { if(isFull()) grow();
        if(last == max-1 || last == -1)
           { a[0] = x;
             last=0;
             if(first==-1) first = 0;
           }
          else
         a[++last] = x;
        count++;
      }

    public Object dequeue() throws Exception
      { if(isEmpty()) throw new Exception();
        Object x = a[first];
        if(first == last)	// only one element
           {first = last = -1;}
           else if(first==max-1)
             first = 0;
             else
             first++;
        count--;
        return(x);
      }

    public void displayAll()
       { int i;
         for(i=0;i<count;i++)
                System.out.print(a[(first+i)%max] + "  ");
        System.out.println();
       }
  } 
//=============================
public class Main
  { public static void main(String [] args) throws Exception 
       { int choice; int  x, k;
         Scanner s = new Scanner(System.in);
         ArrayQueue q = new ArrayQueue();
         Integer X; 
         while(true)
            { System.out.println();
              System.out.println("1. Enqueue");
              System.out.println("2. View first");
              System.out.println("3. Dequeu");
              System.out.println("4. Display all elements of a queue");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be enqueued: ");
                                  x = s.nextInt();
                                  X = new Integer(x);
                                  q.enqueue(X);
                                  break;
                    case 2: System.out.println("The element at the front is  " + q.front());
                                  break;
                    case 3: System.out.println("The element dequeued  is  " + q.dequeue());
                                  break;
                    case 4: q.displayAll();
                                  break;
                  }
            }
        }
  }
