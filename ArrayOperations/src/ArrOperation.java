import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrOperation {
	
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
            	break;
            }
            catch(Exception e) {
                System.out.println("Please enter a integer value");
                sc.nextLine();
                continue;
            }
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
	public static int[] takeArrayInput(int n) {
		int[] arr = new int[n];
		try {
			for(int i = 0; i < n; i++) {
				System.out.println("Enter the " + (i + 1) + " of the array : ");
				arr[i] = takeIntInput();
			}
		}
		catch(Exception e) {
			System.out.println("Error occured while taking array input");
		}
		return arr;
	}
	
	/*
	 * Method to find size of largest mirror section in an array
	 *  @param : arr - array to work on, n - size of the array
	 *  
	 *  return : size of largest mirror section
	 */
	public int findLargestMirrorSection(int[] arr, int n) {
		if(n == 0) {
			throw new AssertionError("Array should not be empty");
		}
		int ans = 0;
		try {
			for(int start = 0; start < n; start++) {
				// using binary search to find largest section starting at index start
				int l = 1, r = n - start;
				while(l <= r) {
					int mid = l + (r - l) / 2;
					boolean flag = false;
					for(int mirrorStart = n - 1; mirrorStart >= mid - 1; mirrorStart--) {
						if(isMirrorSubString(arr, start, mid, mirrorStart)) {
							flag = true;
							break;
						}
					}
					if(flag) {
						ans = Math.max(ans, mid);
						l = mid + 1;
					}
					else r = mid - 1;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in findLargestMirrorSection " + e.getMessage());
		}
		return ans;
	}
	
	/*
	 * Helper function to find size of largest mirror section
	 * 
	 * @param : int[] arr, int start, int length, int mirrorStart
	 * 
	 * return : boolean
	 */
	public boolean isMirrorSubString(int[] arr, int start, int length, int mirrorStart) {
		try {
			int i = start, j = mirrorStart;
			while(length > 0) {
				if(arr[i] != arr[j]) return false;
				i++;
				j--;
				length--;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in isMirrorSubString " + e.getMessage());
		}
		return true;
	}
	
	/*
	 * Method to find number of clumps in an array
	 * 
	 * @param : int[] arr, int n
	 * 
	 * return : number of clumps
	 */
	public int numberOfClumps(int[] arr, int n) {
		if(n == 0) {
			throw new AssertionError("Array should not be empty");
		}
		int ans = 0;
		try {
			for(int i = 0; i < n; i++) {
				int cnt = 0, num = arr[i];
				while(i < n && arr[i] == num) {
					cnt++;
					i++;
				}
				i--;
				if(cnt > 1) ans++;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in numberOfClumps " + e.getMessage());
		}
		return ans;
	}
	
	/*
	 * Method to apply fixXY on the given array
	 * 
	 * @param : int[] arr, int X, int Y, int n
	 * 
	 * return : array after applying fixXY operation
	 */
	public int[] fixXY(int[] arr, int X, int Y, int n) {
		if(n == 0) {
			throw new AssertionError("Array should not be empty");
		}
		ArrayList<Integer> XPosition = new ArrayList<Integer>();
		ArrayList<Integer> YPosition = new ArrayList<Integer>();
		
		try {
			for(int i = 0; i < n; i++) {
				if(arr[i] == X) XPosition.add(i);
				if(arr[i] == Y) YPosition.add(i);
			}
			if(XPosition.size() != YPosition.size()) {
				throw new AssertionError("Number of X and Y in the array are not equal");
			}
			for(int i = 0; i < XPosition.size(); i++) {
				if(XPosition.get(i) == n - 1) {
					throw new AssertionError("Position of X cannot be last index of the array");
				}
				if(i > 0 && (XPosition.get(i) == XPosition.get(i - 1) + 1)) {
					throw new AssertionError("Consecutive X exists in the array");
				}
			}
			Iterator it = YPosition.iterator();
			for(Integer posX : XPosition) {
				int temp = arr[posX + 1];
				int posY = (int) it.next();
				arr[posX + 1] = arr[posY];
				arr[posY] = temp;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in fixXY " + e.getMessage());
		}
		return arr;
	}
	
	/*
	 * Method to find index of splitArray
	 * 
	 * @param : int[] arr, int n
	 * 
	 * return : index at which array left sum equals right sum
	 */
	public int splitArray(int[] arr, int n) {
		if(n == 0) {
			throw new AssertionError("Array should not be empty");
		}
		try {
			for(int i = 1; i < n; i++) {
				arr[i] += arr[i - 1];
			}
			for(int i = 0; i < n; i++) {
				if(arr[i] == (arr[n - 1] - arr[i])) return i + 1;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in splitArray " + e.getMessage());
		}
		return -1;
	}
	
	/*
	 * Method to print menu of all the operations available
	 */
	public static void printMenu() {
		System.out.println(".........Main Menu.......");
		System.out.println("1 : size of the largest mirror section in the array");
		System.out.println("2 : number of clumps in the array");
		System.out.println("3 : fixXY problem");
		System.out.println("4 : splitArray");
		System.out.println("5 : EXIT");
	}
	
	/*
	 * Method to print the array
	 * 
	 * @ param : int[] arr, int n
	 */
	public static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrOperation obj = new ArrOperation();
		int option, n, X, Y;
		int[] arr;
		do {
			printMenu();
			option = takeIntInput();
			switch(option) {
				case 1 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput();
					arr = takeArrayInput(n);
					System.out.println("Size of the largest mirror section is : " + obj.findLargestMirrorSection(arr, n));
					break;
				}
				case 2 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput();
					arr = takeArrayInput(n);
					System.out.println("Number of clumps in the array are : " + obj.numberOfClumps(arr, n));
					break;
				}
				case 3 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput();
					arr = takeArrayInput(n);
					System.out.println("Enter X : ");
					X = takeIntInput();
					System.out.println("Enter Y : ");
					Y = takeIntInput();
					arr = obj.fixXY(arr, X, Y, n);
					System.out.println("Fixed array : ");
					printArray(arr, n);
					break;
				}
				case 4 : {
					System.out.println("Enter the size of the array : ");
					n = takeIntInput();
					arr = takeArrayInput(n);
					int result = obj.splitArray(arr, n);
					if(result != -1) System.out.println("Position at which split is possible : " + result);
					else System.out.println("No split is possible");
					break;
				}
				default : {
					if(option != 5) System.out.println("Please enter a valid option");
				}
			}
		}while(option != 5);
	}

}
