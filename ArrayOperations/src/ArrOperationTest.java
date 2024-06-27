import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrOperationTest {
	
	ArrOperation obj = new ArrOperation();
	
	// positive test cases for method findLargestMirrorSection
	@Test
	void findLargestMirrorSectionTest() {
		assertEquals(3, obj.findLargestMirrorSection(new int[] {1, 2, 3, 8, 9, 3, 2, 1}, 8));
		assertEquals(2, obj.findLargestMirrorSection(new int[] {7, 1, 4, 9, 7, 4, 1}, 7));
		assertEquals(3, obj.findLargestMirrorSection(new int[] {1, 2, 1, 4}, 4));
		assertEquals(7, obj.findLargestMirrorSection(new int[] {1, 4, 5, 3, 5, 4, 1}, 7));
	}
	
	// negative test cases for method findLargestMirrorSection
	@Test
	void findLargestMirrorSectionTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.findLargestMirrorSection(new int[] {}, 0), 
							"Expected findLargestMirrorSection() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
	
	// ...............
	
	// positive test cases for method numberOfClumps
	@Test
	void numberOfClumpsTest() {
		assertEquals(2, obj.numberOfClumps(new int[] {1, 2, 2, 3, 4, 4}, 6));
		assertEquals(2, obj.numberOfClumps(new int[] {1, 1, 2, 1, 1}, 5));
		assertEquals(1, obj.numberOfClumps(new int[] {1, 1, 1, 1, 1}, 5));
	}
	
	// negative test cases for method numberOfClumps
	@Test
	void numberOfClumpsTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.numberOfClumps(new int[] {}, 0), 
							"Expected numberOfClumps() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
	
	// ...............
	
	// positive test cases for method fixXY
	@Test
	void fixXYTest() {
		assertArrayEquals(new int[] {9, 4, 5, 4, 5, 9}, obj.fixXY(new int[] {5, 4, 9, 4, 5, 9}, 4, 5, 6));
		assertArrayEquals(new int[] {1, 4, 5, 1}, obj.fixXY(new int[] {1, 4, 1, 5}, 4, 5, 4));
		assertArrayEquals(new int[] {1, 4, 5, 1, 1, 4, 5}, obj.fixXY(new int[] {1, 4, 1, 5, 5, 4, 1}, 4, 5, 7));
	}
	
	// negative test cases for method fixXY
	@Test
	void fixXYTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.fixXY(new int[] {}, 4, 5, 0), 
							"Expected fixXY() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
	
	// negative test cases for method fixXY
	@Test
	void fixXYTestUnequalXAndY() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.fixXY(new int[] {5, 4, 3, 4}, 4, 5, 4), 
							"Expected fixXY() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Number of X and Y in the array are not equal"));
	}
	
	// negative test cases for method fixXY
	@Test
	void fixXYTestXAtLastIndex() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.fixXY(new int[] {5, 4, 5, 4}, 4, 5, 4), 
							"Expected fixXY() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Position of X cannot be last index of the array"));
	}
	
	// negative test cases for method fixXY
	@Test
	void fixXYTestAdjacentX() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.fixXY(new int[] {4, 4, 5, 5}, 4, 5, 4), 
							"Expected fixXY() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Consecutive X exists in the array"));
	}
	
	// ...............
	
	// positive test cases for method splitArray
	@Test
	void splitArrayTest() {
		assertEquals(3, obj.splitArray(new int[] {1, 1, 1, 2, 1}, 5));
		assertEquals(-1, obj.splitArray(new int[] {2, 1, 1, 2, 1}, 5));
		assertEquals(1, obj.splitArray(new int[] {10, 10}, 2));
	}
	
	// negative test cases for method splitArray
	@Test
	void splitArrayTestEmptyArray() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.splitArray(new int[] {}, 0), 
							"Expected splitArray() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Array should not be empty"));
	}
}
