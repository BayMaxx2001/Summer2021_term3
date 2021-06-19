
package queue;

public class QueueDemo {
    int l , r ;
    int[] a;
    int Maxsize = 100000;

    public QueueDemo() {
        a = new int[Maxsize];
    }
    public boolean isEmpty()
    {
        return (l==r);
    }
    public void clear()
    {
        l=0;
        r=0;
    }
    public void enqueue(int value)
    {
        a[r++] = value;
    }
    public int dequeue() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception();
        }
        return a[l++];
    }
    public int first() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception();
        }
        return a[l];
    }
    public void traverse()
    {
        for(int i=l;i<r;++i)
        {
            System.out.print(a[i]+" ");
        }
    }
}
