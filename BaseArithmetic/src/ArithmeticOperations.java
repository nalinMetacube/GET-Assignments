
public class ArithmeticOperations {
	
	/*
	 * To add two HEX values
	 * 
	 * @param : String Operand1 : first HEX value
	 * 			String Operand2 : second HEX value
	 */
	public static String addition(String operand1, String operand2, int base) {
		int firstOperand = BaseConversion.baseToDecimalRepresentation(operand1, base);
		int secondOperand = BaseConversion.baseToDecimalRepresentation(operand2, base);
		return BaseConversion.decimalToBaseRepresentation(firstOperand + secondOperand, base);
	}
	
	/*
	 * To subtract two HEX values
	 * 
	 * @param : String Operand1 : first HEX value
	 * 			String Operand2 : second HEX value
	 */
	public static String subtraction(String operand1, String operand2, int base) {
		int firstOperand = BaseConversion.baseToDecimalRepresentation(operand1, base);
		int secondOperand = BaseConversion.baseToDecimalRepresentation(operand2, base);
		return BaseConversion.decimalToBaseRepresentation(firstOperand - secondOperand, base);
	}
	
	/*
	 * To multiply two HEX values
	 * 
	 * @param : String Operand1 : first HEX value
	 * 			String Operand2 : second HEX value
	 */
	public static String  multiplication(String operand1, String operand2, int base) {
		int firstOperand = BaseConversion.baseToDecimalRepresentation(operand1, base);
		int secondOperand = BaseConversion.baseToDecimalRepresentation(operand2, base);
		return BaseConversion.decimalToBaseRepresentation(firstOperand * secondOperand, base);
	}
	
	/*
	 * To divide two HEX values
	 * 
	 * @param : String Operand1 : first HEX value
	 * 			String Operand2 : second HEX value
	 */
	public static String  divide(String operand1, String operand2, int base) {
		int firstOperand = BaseConversion.baseToDecimalRepresentation(operand1, base);
		int secondOperand = BaseConversion.baseToDecimalRepresentation(operand2, base);
		return BaseConversion.decimalToBaseRepresentation(firstOperand / secondOperand, base);
	}
}
