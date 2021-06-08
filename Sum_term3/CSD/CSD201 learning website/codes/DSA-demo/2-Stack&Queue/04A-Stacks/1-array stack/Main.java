import java.util.*;
//-------------------------------
class ArrayStack
  { protected  Object [] a; int top, max;

    public ArrayStack() 
      { this(50);
      }

    public ArrayStack(int max1) 
      { max = max1;
        a =  new Object[max];
        top = -1;
      }
    
    protected  boolean grow()
      { int max1 = max + max/2;
        Object [] a1 = new Object[max1];
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

    public void push(Object x)
      { if(isFull() && !grow()) return;
        a[++top] = x; 
      }

    Object top() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        return(a[top]);
      }

    public Object pop() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        Object x = a[top];
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
       { int choice; int  x, k;
         Scanner s = new Scanner(System.in);
         ArrayStack d = new ArrayStack();
         Integer X; 
         while(true)
            { System.out.println();
              System.out.println("1. Push");
              System.out.println("2. Top");
              System.out.println("3. Pop");
              System.out.println("4. Display all");
              System.out.println("0. Exit");
              System.out.print("    Your selection (0 -> 4):  ");
              choice = s.nextInt();
              if(choice==0) break;
              switch(choice)
                  { case 1: System.out.print("Enter the value to be pushed: ");
                                  x = s.nextInt();
                                  X = new Integer(x);
                                  d.push(X);
                                  break;
                    case 2: System.out.println("The element at the top is  " + d.top());
                                  break;
                    case 3: System.out.println("The element poped  is  " + d.pop());
                                  break;
                    case 4: d.displayAll();
                                  break;
                  }
            }
        }
  }
