import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static int takeIntInput() {
        Scanner sc = new Scanner(System.in);
        Integer value;
        while(true) {
            try {
            	value = sc.nextInt();
            }
            catch(Exception e) {
                System.out.println("Please enter a integer value");
                sc.nextLine();
                continue;
            }
            break;
        }
        return value;
    }
	
	/*
	 * Method to print options corresponding to different
	 * operations available
	 */
	private static void printMenu() {
		System.out.println(".....Enter the option for the corresponding opertions........");
		System.out.println("1 : Add the two numbers");
		System.out.println("2 : Subtract the two numbers");
		System.out.println("3 : Multilpy the two numbers");
		System.out.println("4 : Divide the two numbers");
		System.out.println("5 : Check if the numbers are equal");
		System.out.println("6 : Check if the first number is greater than the second");
		System.out.println("7 : Check if the first number is smaller than the second");
		System.out.println("8 : Convert the decimal representation into base representatin");
		System.out.println("9 : Convert the base representation into decimal representatin");
		System.out.println("10 : EXIT");
	}
	
	/*
	 * Method to remove extra '0' bits present in a HEX value
	 * 
	 * @param : String str - HEX value
	 */
	private static String trimString(String str) {
		boolean flag = false;
		String result = "";
		for(int i = 0; i < 32; i++) {
			if(str.charAt(i) != '0') flag = true;
			if(flag) result += str.charAt(i);
		}
		return result;
	}
	
	/*
	 * Method to convert the HEX value
	 * in the 32 bit format, so that while
	 * comparing two HEX, we can directly compare them
	 * lexicographically
	 */
	private static String convertTo32Bit(String str) {
		int loop = 32 - str.length();
		while(loop > 0)  {
			str = '0' + str;
			loop--;
		}
		return str;
	}
	
	/*
	 * Method to check if the HEX string inputed is valid
	 * 
	 * i.e, given the base, the HEX value is according to it.
	 */
	private static boolean checkValidString(String str, int base) {
		int minm = Math.min(9, base);
		char MINM = (char)('0' + minm);
		int maxm = Math.max(-1, base - 10);
		char MAXM;
		if(maxm >= 0) MAXM = (char)('A' + maxm);
		else MAXM = '@';  // because ASCII of '@' is 64
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				if(ch > MINM) {
					System.out.println("Please enter valid string");
					return false;
				}
			}
			else {
				if(ch > MAXM) {
					System.out.println("Please enter valid string");
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * to check upper limit of base
	 */
	private static boolean baseUpperlimit(int base) {
		return base <= 16;
	}

	public static void main(String[] args) {
		BaseConversion.compute();
		Scanner sc = new Scanner(System.in);
		int base, option;
		String firstOperand, secondOperand;
		do {
			printMenu();
			option = takeIntInput();
			switch(option) {
				
				//  to add two HEX values
				case 1: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					System.out.println(trimString(ArithmeticOperations.addition(firstOperand, secondOperand, base)));
					break;
				}
				
				//  to subtract two HEX values
				case 2: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					System.out.println(trimString(ArithmeticOperations.subtraction(firstOperand, secondOperand, base)));
					break;
				}
				
				//  to multiply two HEX values
				case 3: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					System.out.println(trimString(ArithmeticOperations.multiplication(firstOperand, secondOperand, base)));
					break;
				}
				
				//  to divide two HEX values
				case 4: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					// place the check for divide by zero(0)
					if(BaseConversion.baseToDecimalRepresentation(secondOperand, base) == 0) {
						System.out.println("The Divisor cannot be zero");
						break;
					}
					System.out.println(trimString(ArithmeticOperations.divide(firstOperand, secondOperand, base)));
					break;
				}
				
				//  to check if two HEX values are equal or not
				case 5: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					if(BaseConversion.isEqual(firstOperand, secondOperand)) System.out.println("Yes, they are equal");
					else System.out.println("No, they are not equal");
					break;
				}
				
				// to check if first HEX value is greater than second
				case 6: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					if(BaseConversion.compareNumbers(firstOperand, secondOperand)) System.out.println("Yes, first number is greater than the second number");
					else System.out.println("No, first number is not greater than the second number");
					break;
				}
				
				// to check if first HEX value is smaller than second
				case 7: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the first operand (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println("Enter the second operand (in base representation) : ");
					secondOperand = sc.nextLine();
					if(!checkValidString(secondOperand, base)) break;
					secondOperand = convertTo32Bit(secondOperand);
					if(!BaseConversion.compareNumbers(firstOperand, secondOperand)) System.out.println("Yes, first number is smaller than the second number");
					else System.out.println("No, first number is not smaller than the second number");
					break;
				}
				
				// to convert decimal value into its base representation
				case 8: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					System.out.println("Enter the number (in decimal representation) : ");
					int number;
					number = takeIntInput();
					System.out.println(trimString(BaseConversion.decimalToBaseRepresentation(number, base)));
					break;
				}
				
				// to convert base value into its decimal representation
				case 9: {
					System.out.println("Enter the base you want to work with : ");
					base = takeIntInput();
					if(!baseUpperlimit(base)) break;
					sc.nextLine();
					System.out.println("Enter the number (in base representation) : ");
					firstOperand = sc.nextLine();
					if(!checkValidString(firstOperand, base)) break;
					firstOperand = convertTo32Bit(firstOperand);
					System.out.println(BaseConversion.baseToDecimalRepresentation(firstOperand, base));
					break;
				}
				default: {
					if(option != 10) {
						System.out.println("Please enter the valid option");
					}
					break;
				}
			}
		}while(option != 10);
	}

}
