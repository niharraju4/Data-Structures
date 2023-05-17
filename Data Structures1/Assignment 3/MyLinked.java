package algs13;
import stdlib.*;

public class MyLinked {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;
    Node first;
    
    public MyLinked () {
        first = null;
        N = 0;
        checkInvariants ();
    }

    private void myassert (String s, boolean b) { if (!b) throw new Error ("Assertion failed: " + s); }
    private void checkInvariants() {
        myassert("Empty <==> first==null", (N == 0) == (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                throw new Error ("List too short!");
            }
            x = x.next;
        }
        myassert("EndOfList == null", x == null);
    }

    public boolean isEmpty () { return first == null; }
    public int size () { return N; }
    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }

    // return Double.NEGATIVE_INFINITY if the linked list is empty
    public double max () { return max (first); }
    private static double max (Node x) {
        // TODO 1.3.27
    	 if (x == null) {
    	        return Double.NEGATIVE_INFINITY;
    	    }
    	 else 
    	 {
    	        double maxNumber = max(x.next);
    	        if (x.item > maxNumber)
    	            maxNumber = x.item;
    	        return maxNumber;
    	    }
    }

    public double maxRecursive () { return maxRecursive (first, Double.NEGATIVE_INFINITY); }
    private static double maxRecursive (Node x, double result) {
        // TODO 1.3.28
    	   if (x == null) {
    	        return result;
    	    } else {
    	        if (x.item > result) {
    	            result = x.item;
    	        }
    	        return maxRecursive(x.next, result);
    	    }
    }

    // delete the kth element
    public void delete (int k) {
        if (k < 0 || k >= N) throw new IllegalArgumentException ();
        // TODO 1.3.20
        if(k==0)
        {
            first=first.next;
            N--;
        }
        else
        {
            Node temp=first;
            int i=0;
            while(i<k-1)
            {
                temp=temp.next;
                i++;
            }
            //change the next of k-1th node
            Node next=temp.next.next;
            temp.next=next;
            N--;
        }
        checkInvariants ();
    }

    // reverse the list "in place"... without creating any new nodes
    public void reverse () {
        // TODO 1.3.30
    	 if(first==null||first.next==null)
    	       return;
    	       Node list_to_do=first.next;
    	       Node reversed=first;
    	       reversed.next=null;
    	       while(list_to_do!=null)
    	       {
    	           Node temp=list_to_do;
    	           list_to_do=list_to_do.next;
    	           temp.next=reversed;
    	           reversed=temp;
    	       }
    	       first=reversed;
        checkInvariants ();
    }

    // remove 
    public void remove (double item) {
        // TODO 1.3.26
    	   if(N == 0) { 
    		   return;
    	   }
           Node prev = first;
           Node current = first.next;
    	   
           while(current != null) {
               if(current.item == item) {
                   prev.next = current.next;
                   N--;
               } else {
                   prev = current;
               }
               current = current.next;
           }
           if(first.item == item) {
               N--;
               first = first.next;
        checkInvariants ();
           }
    }


    private static void print (String s, MyLinked b) {
        StdOut.print (s + ": ");
        for (Node x = b.first; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println ();
    }
    private static void print (String s, MyLinked b, double i) {
        StdOut.print (s + ": ");
        for (Node x = b.first; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println (": " + i);
    }

    private static void testMax () {
        MyLinked b = new MyLinked ();
        print ("empty", b, b.max());
        b.add (-1);
        print ("singleton", b, b.max());
        b.add (-2);
        b.add (-3);
        b.add (-4);
        print ("at end", b, b.max());
        b.add (5);
        print ("at beginning", b, b.max());
        b.add (3);
        b.add (2);
        b.add (4);
        print ("in the middle", b, b.max());
    }
    private static void testMaxRecursive () {
        MyLinked b = new MyLinked ();
        print ("empty", b, b.maxRecursive());
        b.add (-1);
        print ("singleton", b, b.maxRecursive());
        b.add (-2);
        b.add (-3);
        b.add (-4);
        print ("at end", b, b.maxRecursive());
        b.add (5);
        print ("at beginning", b, b.maxRecursive());
        b.add (3);
        b.add (2);
        b.add (4);
        print ("in the middle", b, b.maxRecursive());
    }
    private static void testDelete () {
        MyLinked b = new MyLinked ();
        b.add (1);
        print ("singleton", b);
        b.delete (0);
        print ("deleted", b);
        for (double i = 1; i < 13; i++) {
            b.add (i);
        }
        print ("bigger list", b);
        b.delete (0);
        print ("deleted at beginning", b);
        b.delete (10);
        print ("deleted at end", b);
        b.delete (4);
        print ("deleted in middle", b);
    }
    private static void testReverse () {
        MyLinked b = new MyLinked ();
        b.reverse ();
        print ("reverse empty", b);
        b.add (1);
        print ("singleton", b);
        b.reverse ();
        print ("reverse singleton", b);
        b.add (2);
        print ("two", b);
        b.reverse ();
        print ("reverse two", b);
        b.reverse ();
        print ("reverse again", b);
        for (double i = 3; i < 7; i++) {
            b.add (i);
            b.add (i);
        }
        print ("bigger list", b);
        b.reverse ();
        print ("reversed", b);
    }
    private static void testRemove () {
        MyLinked b = new MyLinked ();
        b.remove (4);
        print ("removed 4 from empty", b);
        b.add (1);
        b.remove (4);
        print ("removed 4 from singelton", b);
        b.remove (1);
        print ("removed 1 from singelton", b);
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
        }
        for (double i = 1; i < 5; i++) {
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
            b.add (i);
        }
        print ("longer list", b);
        b.remove (9);
        print ("removed all 9s", b); // does nothing
        b.remove (3);
        print ("removed all 3s", b);
        b.remove (1);
        print ("removed all 1s", b);
        b.remove (4);
        print ("removed all 4s", b);
        b.remove (2);
        print ("removed all 2s", b); // should be empty
    }

    public static void main (String args[]) {
        testMax ();
        //        testMaxRecursive ();
        //        testDelete ();
        //        testReverse ();
        //        testRemove ();
    }
}

































