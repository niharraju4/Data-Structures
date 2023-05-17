package algs24;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * The {@code PMytrHeap} class is the priorityQ class from Question 2.4.24. It
 * represents a priority queue of generic keys.
 * 
 * It supports the usual <em>insert</em> and <em>delete-the-maximum</em>
 * operations, along with methods for peeking at the maximum key, testing if the
 * priority queue is empty, and iterating through the keys. For additional
 * documentation, see <a href="http://algs4.cs.princeton.edu/24pq">Section
 * 2.4</a> of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin
 * Wayne.
 */

public class MyPtrHeap<K extends Comparable<? super K>> {
	   private K[] pq; // for storing 1 to N
	    private int N;                       
	    private int MAXN;
	/** Create an empty priority queue */
	public MyPtrHeap (int initCapacity) {
		// TODO
	     MAXN = initCapacity;
	        pq = (K[]) new Comparable[initCapacity + 1];
	        N = 0;
	}

	/** Is the priority queue empty? */
	public boolean isEmpty () {
		// TODO
		 return N == 0;// because we are making it empty.
	}

	/** Return the number of items on the priority queue. */
	public int size () {
		// TODO
		return N;// to identify
	}

	/**
	 * Return the largest key on the priority queue. Throw an exception if the
	 * priority queue is empty.
	 */
	public K max () {
		// TODO
		 //if (isEmpty()) throw new Error("Priority queue underflow");
	        return pq[1];
	}

	/** Add a new key to the priority queue. */
	public void insert (K x) {
		// TODO
        pq[++N] = x;
		return;
	}

	/**
	 * Delete and return the largest key on the priority queue. Throw an
	 * exception if the pri ority queue is empty.
	 */
	public K delMax () {
		// TODO
	        K max = pq[1];
	        pq[N+1] = null;
	        return max;
	}

	private void showHeap () {
		// a method to print out the heap
		// useful for debugging
		 for (int i = 1; i <= N; i++)
	            StdOut.print (pq[i] + " ");
	        StdOut.println ();
	}

	public static void main (String[] args) {
		MyPtrHeap<String> pq = new MyPtrHeap<> (80);
		StdIn.fromString ("10 20 30 40 50 - - - 05 25 35 - - - 70 80 05 - - - - ");
		while (!StdIn.isEmpty ()) {
			StdOut.print ("pq:  ");
			pq.showHeap ();
			String item = StdIn.readString ();
			if (item.equals ("-")) StdOut.println ("max: " + pq.delMax ());
			else pq.insert (item);
		}
		StdOut.println ("(" + pq.size () + " left on pq)");

	}

}
