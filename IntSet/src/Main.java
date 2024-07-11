import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	/*
	 * Method to handle exception and validate integer inputed
	 * 
	 * return : inputted integer
	 */
	public static int takeIntInput(int type) {
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
            if(type == 1) {
            	if(value > 1000) System.out.println("Set size must be less or equal to 1000");
            	else if(value < 0) System.out.println("Set size must be positive");
            	else break;
            	continue;
            }
            if(value > 1000 || value < 1) {
            	System.out.println("Integer in the set must be between 1 and 1000");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/**
	 * Method to input/create a set
	 * @return
	 */
	public static ArrayList<Integer> getSetInput() {
		ArrayList<Integer> inputSet = new ArrayList<>();
		try {
			System.out.println("Enter the size of the set : ");
			int n = takeIntInput(1);
			for(int i = 0; i < n; i++) {
				System.out.println("Enter the " + i + "th element of the set : ");
				int x = takeIntInput(0);
				while(inputSet.indexOf(x) != -1) {
					System.out.println(x + " is already present in the set");
					x = takeIntInput(0);
				}
				inputSet.add(x);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getSetInput method");
		}
		return inputSet;
	}
	
	/**
	 * Method to print a set of integers
	 * @param listOfIntegers
	 */
	public static void printSet(ArrayList<Integer> listOfIntegers) {
		try {
			for(int i = 0; i < listOfIntegers.size(); i++) {
				System.out.print(listOfIntegers.get(i) + " ");
			}
			System.out.println();
		}
		catch(Exception e) {
			System.out.println("Exception occured in printSet method");
		}
	}
	
	/**
	 * Method to print all the available operations
	 */
	public static void printMenu() {
		System.out.println(".........Main Menu............");
		System.out.println("1 : check if a number is member of the set");
		System.out.println("2 : get size of the set");
		System.out.println("3 : get complement of the set");
		System.out.println("4 : check if a set is the subset of the your set");
		System.out.println("5 : find Union of the sets");
		System.out.println("6 : find Intersection of the sets");
		System.out.println("7 : find the difference of the sets");
		System.out.println("8 : EXIT");
	}

	public static void main(String[] args) {
		ArrayList<Integer> integerList = getSetInput();
		IntegerSet firstSet = new IntegerSet(integerList);
		int option;
		do {
			printMenu();
			option = takeIntInput(0);
			switch(option) {
				case 1 : {
					System.out.println("Enter the number : ");
					int number = takeIntInput(0);
					if(firstSet.isMember(number)) System.out.println("Yes, it is a member of the set");
					else System.out.println("No, it is not a member of the set");
					break;
				}
				case 2 : {
					int setSize = firstSet.getSize();
					if(setSize == 0) System.out.println("Set is empty");
					else System.out.println("Size of the set is : " + setSize);
					break;
				}
				case 3 : {
					System.out.println("Complement of the set is : ");
					printSet(firstSet.getComplement());
					break;
				}
				case 4 : {
					ArrayList<Integer> intList = getSetInput();
					IntegerSet secondSet = new IntegerSet(intList);
					if(firstSet.isSubset(secondSet)) System.out.println("Yes, it a subset of the set");
					else System.out.println("No, it is not a subset of the set");
					break;
				}
				case 5 : {
					ArrayList<Integer> intList = getSetInput();
					IntegerSet secondSet = new IntegerSet(intList);
					System.out.println("The Union of the sets is : ");
					printSet(firstSet.getUnion(secondSet));
					break;
				}
				case 6 : {
					ArrayList<Integer> intList = getSetInput();
					IntegerSet secondSet = new IntegerSet(intList);
					System.out.println("The Intersection of the sets is : ");
					printSet(firstSet.getIntersection(secondSet));
					break;
				}
				case 7 : {
					ArrayList<Integer> intList = getSetInput();
					IntegerSet secondSet = new IntegerSet(intList);
					System.out.println("The Difference of the sets is : ");
					printSet(firstSet.getDifference(secondSet));
					break;
				}
				default : {
					if(option != 8) System.out.println("Please enter a valid option");
				}
			}
		}while(option != 8);
	}

}
