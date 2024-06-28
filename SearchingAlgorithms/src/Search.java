import java.util.Scanner;

public class Search {
	
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
            if(value <= 0 && type == 1) {
            	System.out.println("Value must be a positive integer");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/*
	 * Method to take Integer array input
	 * 
	 * @param : n - size of the array
	 * 
	 * return : inputted array
	 */
	public static int[] takeArrayInput(int n, int type) {
		int[] arr = new int[n];
		try {
			for(int i = 0; i < n; i++) {
				System.out.println("Enter the " + (i + 1) + " element of the array : ");
				if(i > 0 && type == 1) {
					while(true) {
						arr[i] = takeIntInput(0);
						if(arr[i] < arr[i - 1]) {
							System.out.println("Array must be in sorted order");
							continue;
						}
						else break;
					}
				}
				else arr[i] = takeIntInput(0);
			}
		}
		catch(Exception e) {
			System.out.println("Error occured while taking array input");
		}
		return arr;
	}
	
	/**
	 * Method to find the position of an element
	 * in an array using linearSearch
	 * @param arr
	 * @param n
	 * @param curIndex
	 * @param value
	 * @return : position of the element in the array if exists
	 */
	public int linearSearch(int[] arr, int n, int curIndex, int value) {
		try {
			if(n <= 0) throw new AssertionError("Array should not be empty");
			if(curIndex == n) return -1;
			if(arr[curIndex] == value) return curIndex + 1;
		}
		catch(Exception e) {
			System.out.println("Exception occured in linearSearch method");
		}
		return linearSearch(arr, n, curIndex + 1, value);
	}
	
	/**
	 * Method to find the position of an element
	 * in an array using binarySearch
	 * @param arr
	 * @param n
	 * @param l
	 * @param r
	 * @param value
	 * @return : position of the element in the array if exists
	 */
	public int binarySearch(int[] arr, int n, int l, int r, int value) {
		try {
			if(n <= 0) throw new AssertionError("Array should not be empty");
			if(!checkIsArraySorted(arr, n)) throw new AssertionError("Array must be sorted");
			if(l > r) return -1;
			int mid = l + (r - l) / 2;
			if(arr[mid] == value) return mid + 1;
			if(arr[mid] > value) r = mid - 1;
			else l = mid + 1;
		}
		catch(Exception e) {
			System.out.println("Exception occured in binarySearch method");
		}
		return binarySearch(arr, n, l, r, value);
	}
	
	/**
	 * to check if an array is sorted or not
	 * @param arr
	 * @param n
	 * @return
	 */
	public boolean checkIsArraySorted(int[] arr, int n) {
		try {
			for(int i = 0; i < n; i++) {
				if(i > 0 && arr[i] < arr[i - 1]) return false;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in checkIsArraySorted method");
		}
		return true;
	}
	/**
	 * to print all the operations available
	 */
	public static void printMenu() {
		try {
			System.out.println(".......Main Menu.......");
			System.out.println("1 : find an element in an array using linear search");
			System.out.println("2 : find an element in an array using binary search");
			System.out.println("3 : EXIT");
		}
		catch(Exception e) {
			System.out.println("Exception occured in printMenu method");
		}
	}

	public static void main(String[] args) {
		Search obj = new Search();
		int option, n, val;
		int[] arr;
		do {
			printMenu();
			option = takeIntInput(1);
			switch(option) {
				case 1 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput(1);
					System.out.println("Enter the elements of the array : ");
					arr = takeArrayInput(n, 0);
					System.out.println("Enter the value to be find in the array : ");
					val = takeIntInput(0);
					int result = obj.linearSearch(arr, n, 0, val);
					if(result != -1) System.out.println("Position of " + val + " in the array is : " + result);
					else System.out.println("Value not present in the array");
					break;
				}
				case 2 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput(1);
					System.out.println("Enter the elements of the array in sorted order : ");
					arr = takeArrayInput(n, 1);
					System.out.println("Enter the value to be find in the array : ");
					val = takeIntInput(0);
					int result = obj.binarySearch(arr, n, 0, n - 1, val);
					if(result != -1) System.out.println("Position of " + val + " in the array is : " + result);
					else System.out.println("Value not present in the array");
					break;
				}
				default : {
					System.out.println("Please enter valid option");
					break;
				}
			}
		}while(option != 3);
	}

}
