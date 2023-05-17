package algs13;


import stdlib.*;

// PROBLEM 2.2.17
public class MyLinkedSort {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;
    Node first;
    
    public MyLinkedSort () {
        first = null;
        N = 0;
        checkInvariants ();
    }

    private void myassert (String s, boolean b) { if (!b) throw new Error ("Assertion failed: " + s); }
    private void checkInvariants() {
        myassert("Empty <==> first ==null", (N == 0) == (first == null));
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

    private static void print (String s, Node b) {
        StdOut.print (s + ": ");
        for (Node x = b; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println ();
    }
    private static void print (String s, Node b, double i) {
        StdOut.print (s + ": ");
        for (Node x = b; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println (": " + i);
    }

    static public Node sort(Node l ){
    	if (l.next == null){
	   // base case: list is of size 1. reurn
	   // otherwise use split to create two lists
	   // recursively sort each of them
	   // use merge to combine them, and return the result
	   return l;
    	}
    	 Node[] halves = split(l);//split the node
         halves[0] = sort(halves[0]);//first list
         halves[1] = sort(halves[1]); //second list
         Node n = merge(halves[0], halves[1]); //merging both the lists to get result.
         return n;	
	}
		 
	static public Node[] split(Node l){
		 Node r = l.next;
	        l.next = null;
	        Node c = r.next;
	        r.next = null;
	        while (c != null) {
	            Node t = c.next;
	            c.next = l;
	            Node t2 = r;
	            l = c;
	            r = l;
	            l = t2;
	            c = t;
	        }
      // parameter is a List
	  // it returns an array of size 2
	  // the 0th element is theleft ist
	  // the first element is the right list
		return new Node[] {l,r};
	  }
	
	static public Node merge(Node lt, Node rt){
		  Node n;
	        if (lt.item < rt.item) 
	        {
	            n = lt;
	            lt = lt.next;
	        }
	        else 
	        {
	            n = rt;
	            rt	= rt.next;
	        }	        Node c = n;
	        while (true) 
	        {
	            if (rt == null) 
	            {
	                c.next = lt;
	                return n;
	            }
	            if (lt == null) {
	                c.next = rt;
	                return n;
	            }
	            if (lt.item < rt.item) {
	                c.next = lt;
	                lt = lt.next;
	            } else {
	                c.next = rt;
	                rt = rt.next;
	            }
	            c = c.next;	
	// merge creates a new List
	// whose elements come from the lt and rt MyLinkedLists1
	        }
	}

    public static void main (String args[]) {
        int[] a1 = new int[20];
		for (int i = 0; i < a1.length; i++)
			a1[i] = i;
		StdRandom.shuffle (a1);
        MyLinkedSort b1 = new MyLinkedSort ();
        for (int i:a1) b1.add(i);
        MyLinkedSort.print("before sort",b1.first);
        Node res1 = MyLinkedSort.sort(b1.first);
        MyLinkedSort.print("after sort",res1);

        int[] a2 = new int[200];
		for (int i = 0; i < a2.length; i++)
			a2[i] = i;
		StdRandom.shuffle (a2);
        MyLinkedSort b2 = new MyLinkedSort ();
        for (int i:a1) b2.add(i);
        MyLinkedSort.print("before sort",b2.first);
        Node res2 = MyLinkedSort.sort(b2.first);
        MyLinkedSort.print("after sort",res2);

       // write code for a doubling Test
         
    }
}



