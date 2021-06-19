class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}
  void add(int x)
   {if(isEmpty())
     head=tail=new Node(x,null);
     else
     {Node q =new Node(x,null);
      tail.next=q;
      tail=q;
     }
   }
  void traverse()
   {if(isEmpty())
     {System.out.println(" The list is empty");
      return;
     }
    Node p=head;
    while(p!=null)
     {System.out.print(" " + p.info);
      p=p.next;
     }
    System.out.println();
   }
  Node search(int x)
   {Node p = head;
    while(p!=null)
     {if(p.info==x) return(p);
      p=p.next;
     }
    return(null);
   }
  void dele(int x)
   {if(isEmpty())
     {System.out.println("\n The list is empty");
      return;
     }
    if(head.info==x)
      {head=head.next;
       if(head==null) tail=null;
       return;
      }
    Node f,p;f=null; p = head;
    while(p!=null && p.info!=x)
     {f=p;
      p=p.next;
     }
    if(p!=null)
     {f.next=p.next;
     }
     else
     System.out.println(x + " is not found in the list, no deletion");
   }
 }
