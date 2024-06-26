import java.util.Scanner;

public class Main {
	
	/*
	 * Method to handle exception and validate string inputed
	 */
	private static String takeStringInput() {
		Scanner sc = new Scanner(System.in);
		String str;
		while(true) {
			try {
				str = sc.nextLine();
			}
			catch (Exception e){
				System.out.println("Please enter valid String : " + e.getMessage());
				continue;
			}
			if(checkLatinAlphabet(str)) break;
			else System.out.println("String must contain only latin alphabets");
		}
		return str;
	}
	
	/*
	 * Method to compare two strings if they are equal or not
	 * return - 1 : if they are equal,
	 * 		    0 : if not equal
	 * 
	 * @param : String firstString
	 * 			String secondString
	 */
	private static int compareStrings(String firstString, String secondString) {
		int len1 = firstString.length(), len2 = secondString.length();
		if(len1 != len2) return 0;
		for(int i = 0; i < len1; i++) {
			if(firstString.charAt(i) != secondString.charAt(i)) return 0;
		}
		return 1;
	}
	
	/*
	 * Method to reverse a string
	 * return : returns the reversed string
	 * 
	 * @param : String str
	 */
	private static String reverseString(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		return result;
	}
	
	/*
	 * Method to change the case(upper to lower and vice-versa) of a string
	 * return : returns the changed case string
	 * 
	 * @param : String str
	 */
	private static String changeAlphabetCase(String str) {
		String result = "";	
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int val;
			if(ch >= 'a' && ch <= 'z') {
				val = (int)(ch - 'a');
				result += (char)('A' + val);
			}
			else {
				val = (int)(ch - 'A');
				result += (char)('a' + val);
			}
		}
		return result;
	}
	
	/*
	 * Method to find the largest word in string(of multiple words)
	 * return : returns the largest word
	 * 
	 * @param : String str
	 */
	private static String largestWord(String str) {
		String result = "";
		int n = str.length();
		for(int i = 0; i < n; i++) {
			String curStr = "";
			while(i < n && str.charAt(i) != ' ') {
				curStr += str.charAt(i);
				i++;
			}
			if(result.length() <= curStr.length()) result = curStr;
		}
		return result;
	}
	
	/*
	 * Method to check if the string only conatins latin alphabets
	 * return : returns boolean value corresponding to the result
	 * 
	 * @param : String str
	 */
	private static boolean checkLatinAlphabet(String str) {
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) continue;
			return false;
		}
		return true;
	}
	
	/*
	 * Method to print the menu of different operations available
	 */
	private static void printMenu() {
		System.out.println(".........MAIN MENU.............");
		System.out.println("1 : Compare two strings if they are equal");
		System.out.println("2 : Reverse a string");
		System.out.println("3 : Change UpperCase to lowerCase and vice-versa");
		System.out.println("4 : Find the largest word of a String");
		System.out.println("5 : EXIT");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			printMenu();
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1 : {
					String firstString, secondString;
					System.out.println("Enter the first String : ");
					firstString = sc.nextLine();
					System.out.println("Enter the second String : ");
					secondString = sc.nextLine();
					System.out.println(compareStrings(firstString, secondString));
					break;
				}
				case 2 : {
					String str;
					System.out.println("Enter the string to be reversed : ");
					str = sc.nextLine();
					System.out.println("Reversed string is : " + reverseString(str));
					break;
				}
				case 3 : {
					String str;
					System.out.println("Enter the string : ");
					str = takeStringInput();
					System.out.println("Changed case string is : " + changeAlphabetCase(str));
					break;
				}
				case 4 : {
					String str;
					System.out.println("Enter the string : ");
					str = sc.nextLine();
					System.out.println("Largest word in the given string is : " + largestWord(str));
					break;
				}
				default : {
					if(option != 5) System.out.println("Please enter valid option");
					break;
				}
			}
		}while(option != 5);
	}

}
