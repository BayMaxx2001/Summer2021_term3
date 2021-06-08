import java.util.*;
//-------------------------------
class ArrayQueue
  { protected Object [] a;
    protected int max;
    protected int first, last;

    public ArrayQueue() 
      { this(10);
      }
    public ArrayQueue(int max1) 
      { max = max1;
        a = new Object[max];
        first = last = -1;
      }

    public boolean isEmpty()
      { return(first==-1);}

    public boolean isFull()
      { return((first == 0 && last == max-1) || first == last+1);
      }

    private boolean grow()
       { int i,j;
         int max1 = max + max/2;
         Object [] a1 = new Object[max1];
         if(a1 == null) return(false);
         if(last>=first)
           for(i=first;i<=last;i++) a1[i-first]=a[i];
           else
           { for(i=first;i<max;i++) a1[i-first]=a[i];
             for(j=0;j<=last;j++) a1[i+j]=a[j];
           }
         a = a1;
         max = max1;
         int count;
         if(first<=last)
           count = last - first +1;
           else
           count = max - first + last;
           first = 0;         
           last = count-1;
           return(true); 
       }

    void enqueue(Object x)
      { if(isFull() && !grow()) return;
        if(last == max-1 || last == -1)
           { a[0] = x;
             last=0;
             if(first==-1) first = 0;
           }
          else
         a[++last] = x;
      }


    Object front() throws Exception
      { if(isEmpty()) throw new Exception();
        return(a[first]);
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
        return(x);
      }

    public void displayAll()
       { int i,j;
         if(first<=last)
           for(i=first;i<=last;i++) 
              System.out.print(a[i] + "   ");
           else
           { for(i=first;i<max;i++)
                System.out.print(a[i] + "   ");
             for(i=0;i<=last;i++)
                System.out.print(a[i] + "   ");
           }
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
