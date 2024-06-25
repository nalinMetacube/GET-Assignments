import java.util.HashMap;

public class BaseConversion {
	
	/*
	 * To store the (Base to decimal) and (decimal to base) conversion values.
	 */
	static HashMap<Integer, Character> decimalToBase = new HashMap<Integer, Character>();
	static HashMap<Character, Integer> baseToDecimal = new HashMap<Character, Integer>();
	
	/*
	 * This method is used to compare two HEX values
	 * as both the HEX values are in 32 bit format
	 * we can directly compare them lexicographically
	 * 
	 * @param : String Operand1 : first HEX value
	 * 			String Operand2 : second HEX value
	 */
	public static boolean compareNumbers(String Operand1, String Operand2) {
		for(int i = 0; i < 32; i++) {
			if(Operand1.charAt(i) > Operand2.charAt(i)) return true;
			if(Operand1.charAt(i) < Operand2.charAt(i)) return false;
		}
		return false;
	}
	
	/*
	 * Method is used to compare if two HEX values
	 * are same or not
	 * as Both are in 32 bit format, we can directly compare them
	 */
	public static boolean isEqual(String Operand1, String Operand2) {
		return Operand1.equals(Operand2);
	}
	
	/*
	 * This method is used to initialize the conversion parameters
	 * i.e in base 16 : 10 is for 'A'
	 * 					11 is for 'B'
	 * 					12 is for 'C'
	 * 					......
	 */
	public static void compute() {
		char ch = 'A', ch2 = '0';
		for(int i = 0; i <= 16; i++) {
			if(i < 10) {
				decimalToBase.put(i, ch2);
				baseToDecimal.put(ch2, i);
				ch2++;
			}
			else {
				decimalToBase.put(i, ch);
				baseToDecimal.put(ch, i);
				ch++;
			}
		}
	}
	
	/*
	 * This method is used to convert the decimal representation
	 * of a number into its base representation
	 * 
	 * @param : number - number in decimal format
	 *          Base : Base used while converting
	 */
	
	public static String decimalToBaseRepresentation(int number, int base) {
		String BaseRepresentation = "";
		for(int i = 0; i < 32; i++) {
			int rem = number % base;
			BaseRepresentation = decimalToBase.get(rem) + BaseRepresentation;
			number /= base;
		}
		return BaseRepresentation;
	}
	
	/*
	 * This method is used to convert the Base representation
	 * of a number into its decimal representation
	 * 
	 * @param : BaseRepresentation - Base representation of number
	 *          Base : Base used while converting
	 */
	public static int baseToDecimalRepresentation(String BaseRepresentation, int base) {
		int number = 0;
		int power = 1;
		for(int i = 31; i >= 0; i--) {
			if(baseToDecimal.get(BaseRepresentation.charAt(i)) != 0) {
//				System.out.println("power " + i + " : " + (base << power));
				number += (baseToDecimal.get(BaseRepresentation.charAt(i)) * power);
			}
			power *= base;
		}
		return number;
	}
}
