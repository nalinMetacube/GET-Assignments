import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {
	
	Main obj = new Main();
	
	// positive test cases for method CalculateLCM
	@Test
	void CalculateLCMTest() {
		assertEquals(60, obj.CalculateLCM(12, 15));
		assertEquals(72, obj.CalculateLCM(8, 9));
		assertEquals(35, obj.CalculateLCM(5, 7));
		assertEquals(24, obj.CalculateLCM(6, 8));
		assertEquals(1, obj.CalculateLCM(1, 1));
	}
	
	// negative test cases for method CalculateLCM
	@Test
	void CalculateLCMTestNegativeInputs() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.CalculateLCM(23, -8), 
							"Expected CalculateLCM() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Number must be non negative integers"));
	}
	
	// positive test cases for method CalculateHCF
	@Test
	void CalculateHCFTest() {
		assertEquals(3, obj.CalculateHCF(12, 15));
		assertEquals(1, obj.CalculateHCF(8, 9));
		assertEquals(5, obj.CalculateHCF(25, 35));
		assertEquals(14, obj.CalculateHCF(14, 28));
		assertEquals(1, obj.CalculateHCF(1, 1));
	}
	
	// negative test cases for method CalculateHCF
	@Test
	void CalculateHCFTestNegativeInputs() {
		AssertionError thrown = assertThrows(
							AssertionError.class,
							() -> obj.CalculateHCF(14, -3), 
							"Expected CalculateHCF() to throw Assertion Error, but it didn't");
		assertTrue(thrown.getMessage().contains("Number must be non negative integers"));
	}
}
