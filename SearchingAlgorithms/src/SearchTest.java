import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {
	
	Search obj = new Search();

	// positive test cases for method linearSearch
	@Test
	void linearSearchTest() {
		assertEquals(4, obj.linearSearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 10));
		assertEquals(1, obj.linearSearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 2));
		assertEquals(-1, obj.linearSearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 1));
		assertEquals(5, obj.linearSearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 40));
	}
	
	// negative test cases for method linearSearch
	@Test
	void linearSearchTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.linearSearch(new int[] {}, 0, 0, 10), 
							"Expected linearSearch() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
	
	// positive test cases for method binarySearch
	@Test
	void binarySearchTest() {
		assertEquals(4, obj.binarySearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 4, 10));
		assertEquals(1, obj.binarySearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 4, 2));
		assertEquals(-1, obj.binarySearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 4, 1));
		assertEquals(5, obj.binarySearch(new int[] {2, 3, 4, 10, 40}, 5, 0, 4, 40));
	}
	
	// negative test cases for method binarySearch
	@Test
	void binarySearchTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.binarySearch(new int[] {}, 0, 0, 0, 10), 
							"Expected binarySearch() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
	
	// negative test cases for method binarySearch
	@Test
	void binarySearchTestSortedArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.binarySearch(new int[] {2, 4, 10, 40, 3}, 5, 0, 4, 10), 
							"Expected binarySearch() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array must be sorted"));
	}
}
