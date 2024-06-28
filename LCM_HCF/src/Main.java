import java.util.Scanner;

public class Main {
	
	/*
	 * Method to handle exception and validate integer inputed
	 * 
	 * return : inputted integer
	 */
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
            if(value < 0) {
            	System.out.println("Integer must be a positive integer");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/*
	 * Method to print menu of all the operations available
	 */
	public static void printMenu() {
		try {
			System.out.println(".........Main Menu.......");
			System.out.println("1 : find LCM of two numbers");
			System.out.println("2 : find HCF of two numbers");
			System.out.println("3 : EXIT");
		}
		catch(Exception e) {
			System.out.println("Exception occured in printMenu method");
		}
	}
	
	/*
	 * Method to find HCF of two numbers
	 * using recursion(Euclid's algorithm)
	 * 
	 * @param : int x, int y
	 * 
	 * return : return the HCF of x and y
	 */
	public int CalculateHCF(int x, int y) {
		try {
			if(x < 0 || y < 0) throw new AssertionError("Number must be non negative integers");
			if(y == 0) return x;
		}
		catch(Exception e) {
			System.out.println("Exception occured in CalculateHCF method");
		}
		return CalculateHCF(y, x % y);
	}
	
	/*
	 * Method to find LCm of two numbers
	 * using HCF of those numbers
	 * 
	 * @param : int x, int y
	 * 
	 * return : return the LCM of x and y
	 */
	public int CalculateLCM(int x, int y) {
		try {
			if(x < 0 || y < 0) throw new AssertionError("Number must be non negative integers");
		}
		catch(Exception e) {
			System.out.println("Exception occured in CalculateLCM method");
		}
		return (x * y) / CalculateHCF(x, y);
	}

	public static void main(String[] args) {
		Main obj = new Main();
		int option, number1, number2;
		do {
			printMenu();
			option = takeIntInput();
			switch(option) {
				case 1 : {
					System.out.println("Enter the first number : ");
					number1 = takeIntInput();
					System.out.println("Enter the second number : ");
					number2 = takeIntInput();
					System.out.println("LCM of " + number1 + " and " + number2 + " : " + obj.CalculateLCM(number1, number2));
					break;
				}
				case 2 : {
					System.out.println("Enter the first number : ");
					number1 = takeIntInput();
					System.out.println("Enter the second number : ");
					number2 = takeIntInput();
					System.out.println("HCF of " + number1 + " and " + number2 + " : " + obj.CalculateHCF(number1, number2));
					break;
				}
				default : {
					if(option != 3) System.out.println("Please enter valid option");
					break;
				}
			}
		}while(option != 3);
	}

}
