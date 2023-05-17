package algs11;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HW2bTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@Test
	public void test01AddElementToEmpty() {
		ArrayIntSet s1 = new ArrayIntSet(4);
		ArrayIntSet s2 = new ArrayIntSet(4);

		assertTrue(s1.addElement(1));
		assertEquals(1, s1.size());
		assertEquals(0, s2.size());
		assertTrue(s1.contains(1));
		assertFalse(s2.contains(1));

		assertTrue(s2.addElement(1));
		assertEquals(1, s1.size());
		assertEquals(1, s2.size());
		assertTrue(s1.contains(1));
		assertTrue(s2.contains(1));
	}

	@Test
	public void test01AddElementToNonEmpty() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		ArrayIntSet s1 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s2.addElement(-4);
		s2.addElement(2);
		s2.addElement(9);

		// Check s1
		assertTrue(s1.addElement(-5));
		assertEquals(4, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(-5));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));
		assertFalse(s1.contains(-4));

		// Check s2
		assertEquals(3, s2.size());
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));
		assertFalse(s2.contains(-5));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(-0));
		assertFalse(s2.contains(1));
	}

	@Test
	public void test03AddElementDuplicate() {
		// s1 = {9, -3, 2, 1, 4};
		ArrayIntSet s1 = new ArrayIntSet(20);
		assertTrue(s1.addElement(9));
		assertTrue(s1.addElement(-3));
		assertTrue(s1.addElement(2));
		assertTrue(s1.addElement(1));
		assertTrue(s1.addElement(4));
		assertEquals(5, s1.size());

		// try adding 9
		assertFalse(s1.addElement(9));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());

		// try adding 4
		assertFalse(s1.addElement(4));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());

		// try adding 2
		assertFalse(s1.addElement(2));
		assertTrue(s1.contains(9));
		assertTrue(s1.contains(-3));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(4));
		assertEquals(5, s1.size());
	}

	@Test
	public void test01removeEmpty() {
		ArrayIntSet s1 = new ArrayIntSet(10);
		assertFalse(s1.removeElement(-4));
		assertEquals(0, s1.size());
		assertFalse(s1.removeElement(1));
		assertEquals(0, s1.size());
		assertFalse(s1.removeElement(0));
		assertEquals(0, s1.size());
	}

	@Test
	public void test01removeSingle() {
		// s1 = {5}
		// s2 = {5}
		ArrayIntSet s1 = new ArrayIntSet(10);
		s1.addElement(5);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s2.addElement(5);
		assertTrue(s1.removeElement(5));
		assertEquals(0, s1.size());
		assertEquals(1, s2.size());
		assertFalse(s1.contains(5));
		assertTrue(s2.contains(5));

		assertTrue(s2.removeElement(5));
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(5));
	}

	@Test
	public void test01removeMultiple() {
		// s1 = {1, 3, 5}
		// s2 = {2, 3, 4}
		ArrayIntSet s1 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(3);
		s1.addElement(5);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s2.addElement(2);
		s2.addElement(3);
		s2.addElement(4);

		assertTrue(s2.removeElement(3));
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertTrue(s1.contains(5));
		assertEquals(2, s2.size());
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(5));
		assertEquals(2, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(3));
		assertEquals(1, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));

		assertTrue(s1.removeElement(1));
		assertEquals(0, s1.size());
		assertFalse(s1.contains(1));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(3));
		assertFalse(s1.contains(4));
		assertFalse(s1.contains(5));
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));
	}

	@Test
	public void test01removeMissing() {
		// s1 = {1, 3, 5}
		// s2 = {2, 4, 6}
		ArrayIntSet s1 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(3);
		s1.addElement(5);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s2.addElement(2);
		s2.addElement(4);
		s2.addElement(6);
		
		assertFalse(s2.removeElement(1));
		assertFalse(s1.removeElement(2));
		assertFalse(s2.removeElement(3));
		assertFalse(s1.removeElement(4));
		assertFalse(s2.removeElement(5));
		assertFalse(s1.removeElement(6));
		
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
		assertTrue(s1.contains(3));
		assertFalse(s1.contains(4));
		assertTrue(s1.contains(5));
		assertFalse(s1.contains(6));
		
		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertTrue(s2.contains(2));
		assertFalse(s2.contains(3));
		assertTrue(s2.contains(4));
		assertFalse(s2.contains(5));
		assertTrue(s2.contains(6));
	}

	@Test
	public void tes01tUnionEmpty() {
		ArrayIntSet s1 = new ArrayIntSet(10);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s1.union(s2);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
	}

	@Test
	public void test01UnionNoDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		ArrayIntSet s1 = new ArrayIntSet(10);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);
		s2.union(s1);

		assertEquals(6, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));

		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		s1 = new ArrayIntSet(10);
		s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);
		s1.union(s2);

		assertEquals(6, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(-4));
		assertTrue(s1.contains(2));
		assertTrue(s1.contains(9));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));
	}

	@Test
	public void test01UnionSomeDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {0, 2, 1};
		ArrayIntSet s1 = new ArrayIntSet(10);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s1.union(s2);
		assertEquals(4, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(2));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(2));
	}

	@Test
	public void test01UnionEqualSets() {
		// s1 = {1, -1, 0};
		// s1 = {1, -1, 0};
		ArrayIntSet s1 = new ArrayIntSet(10);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(1);
		s2.addElement(-1);
		s2.addElement(0);

		s1.union(s2);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));

		s2.union(s1);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
	}

	@Test
	public void test01IntersectEmpty() {
		// s1 = {}
		// s2 = {}
		ArrayIntSet s1 = new ArrayIntSet(5);
		ArrayIntSet s2 = new ArrayIntSet(5);

		s1.intersect(s2);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());

		s2.intersect(s1);
		assertEquals(0, s1.size());
		assertEquals(0, s2.size());
	}

	@Test
	public void test01IntersectNoDuplicates() {
		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		ArrayIntSet s1 = new ArrayIntSet(10);
		ArrayIntSet s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);

		s1.intersect(s2);
		assertEquals(0, s1.size());
		assertFalse(s1.contains(1));
		assertFalse(s1.contains(-1));
		assertFalse(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertTrue(s2.contains(-4));
		assertTrue(s2.contains(2));
		assertTrue(s2.contains(9));

		// s1 = {1, -1, 0};
		// s2 = {-4, 2, 9};
		s1 = new ArrayIntSet(10);
		s2 = new ArrayIntSet(10);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-4);
		s2.addElement(9);
		s2.addElement(2);

		s2.intersect(s1);
		assertEquals(0, s2.size());
		assertFalse(s2.contains(1));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(0));
		assertFalse(s2.contains(-4));
		assertFalse(s2.contains(2));
		assertFalse(s2.contains(9));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-4));
		assertFalse(s1.contains(2));
		assertFalse(s1.contains(9));
	}

	@Test
	public void test01IntersectSomeDuplicates() {
		// s1= { 1, -1, 0 };
		// s2 = { 0, 2, 1 };
		ArrayIntSet s1 = new ArrayIntSet(5);
		ArrayIntSet s2 = new ArrayIntSet(5);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s1.intersect(s2);
		assertEquals(2, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(0));
		assertFalse(s1.contains(-1));
		assertFalse(s1.contains(2));

		assertEquals(3, s2.size());
		assertFalse(s2.contains(-1));
		assertTrue(s2.contains(0));
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(2));

		// s1= { 1, -1, 0 };
		// s2 = { 0, 2, 1 };
		s1 = new ArrayIntSet(5);
		s2 = new ArrayIntSet(5);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(0);
		s2.addElement(2);
		s2.addElement(1);

		s2.intersect(s1);
		assertEquals(2, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(0));
		assertFalse(s2.contains(-1));
		assertFalse(s2.contains(2));

		assertEquals(3, s1.size());
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));
		assertTrue(s1.contains(1));
		assertFalse(s1.contains(2));
	}

	@Test
	public void test01IntersectEqualSets() {
		// s1 = { 1, -1, 0 };
		// s2 = { 1, -1, 0 };
		ArrayIntSet s1 = new ArrayIntSet(5);
		ArrayIntSet s2 = new ArrayIntSet(5);
		s1.addElement(1);
		s1.addElement(-1);
		s1.addElement(0);
		s2.addElement(-1);
		s2.addElement(0);
		s2.addElement(1);

		s1.intersect(s2);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));

		s2.intersect(s1);
		assertEquals(3, s1.size());
		assertTrue(s1.contains(1));
		assertTrue(s1.contains(-1));
		assertTrue(s1.contains(0));

		assertEquals(3, s2.size());
		assertTrue(s2.contains(1));
		assertTrue(s2.contains(-1));
		assertTrue(s2.contains(0));
	}

	}