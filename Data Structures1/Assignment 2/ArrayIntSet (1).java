package algs11;

import stdlib.StdOut;
import java.util.Arrays;


public class ArrayIntSet {
	private int[] data;
	private int size;

	public ArrayIntSet(int capacity) {
		data = new int[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(int i) {
		for (int index = 0; index < size; index++) {
			if (data[index] == i)
				return true;
		}
		return false;
	}

      // Ignore this equals method. Used for testing.
	public boolean equals(Object otherObject) {
		ArrayIntSet other = (ArrayIntSet) otherObject;
		return this.equals(other);
	}



	/***************************** NEW METHODS ************************************/

	/**
	 * Adds <code>element</code> to this set if it is not already present and
	 * returns <code>true</code>. If <code>element</code> is already present, the
	 * set is unchanged and <code>false</code> is returned.
	 * 
	 * @param element the element to be added
	 * @return <code>true</code> if the element was added and <code>false</code>
	 *         otherwise.
	 */
	public boolean addElement(int element) {
        if (size == data.length) 
        {
 // create a new Temp array and copy variables from old array and replace to the old array of the Data
              int temp[] = new int[size * 2];
              for (int i = 0; i < size; i++) {
                    temp[i] = data[i];
              }
              data = temp;
        }
        data[size++] = element;//checking to add a variable to the index size i.e, and increment it by 1
        return true; 
  }

	/**
	 * Removes an element from the set.
	 * 
	 * @param element the element to be removed
	 * @return <code>ture</code> if the element was removed and <code>false</code>
	 *         otherwise.
	 */
	public boolean removeElement(int element) {
		// Replace the line below with your answer
		  for (int index = 0; index < size; index++) //using a for loop to identify the elemnts
		  {
              if (data[index] == element)
              {
                    data[index] = data[size - 1];//find the data and update it with the element by using size
                    size--;
                    return true; //if its found true
              }
        }
        return false; //if its found false
  }

	/**
	 * Returns true if <code>this</code> and <code>other</code> have the same
	 * elements and false otherwise.
	 * 
	 * @param other the set to compare against for equality
	 * @return true if <code>this</code> and <code>other</code> have the same
	 *         elements and false otherwise.
	 */
	public boolean equals(ArrayIntSet other) {
		 if (size != other.size) 
		 {
             return false; //if it dosent match then you better return it ha!
       }
       for (int index = 0; index < size; index++) {
             if (!other.contains(data[index])) {
                   return false;//checks weather it matchees the data of the size or if it dosent
             }
       }
       return true;
	}

	/**
	 * Changes the set so that it is equal the union of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to union with
	 */
	public void union(ArrayIntSet other) {
		// Replace the line below with your answer
		 for (int index = 0; index < other.size; index++) 
		 {//checking if there are any similar ones or they are different to add to a set of a union
             addElement(other.data[index]);
       }//then add element
	}
	/**
	 * Changes the set so that is equal the intersection of itself and
	 * <code>other</code>.
	 * 
	 * @param other the set to intersect with
	 */
	public void intersect(ArrayIntSet other) {
		// Replace the line below with your answer
		  for (int i = size; i >= 0; i--)
		  {
              if (!other.contains(data[i]))
              {
                    removeElement(data[i]);//check if it is present of not then remove it from this set of data

              }

        }	
	}
}
