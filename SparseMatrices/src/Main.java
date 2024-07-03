import java.util.HashMap;
import java.util.Map;
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
	
	/**
	 * Method used to take Matrix input
	 * and store the non zero values using HashMap
	 * @param numOfRows
	 * @param numOfCols
	 * @return
	 */
	public static HashMap<Pair, Integer> takeMatrixInput(int numOfRows, int numOfCols) {
		HashMap<Pair, Integer> matrix = new HashMap<>();
		try {
			for(int i = 0; i < numOfRows; i++) {
				for(int j = 0; j < numOfCols; j++) {
					System.out.println("Enter the element at " + i + "th row and " + j + "th column : ");
					int x = takeIntInput();
					if(x != 0) {
						Pair curIndex = new Pair(i, j);
						matrix.put(curIndex, x);
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in takeMatrixInput method");
		}
		return matrix;
	}
	
	/**
	 * Method used to print the 2D matrix
	 * @param matrix
	 * @param numOfRows
	 * @param numOfCols
	 */
	public static void printMatrix(HashMap<Pair, Integer> matrix, int numOfRows, int numOfCols) {
		try {
			for(int i = 0; i < numOfRows; i++) {
				for(int j = 0; j < numOfCols; j++) {
					Pair curIndex = new Pair(i, j);
					if(matrix.containsKey(curIndex)) System.out.print(matrix.get(curIndex) + " ");
					else System.out.print(0 + " ");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in printMatrix method");
		}
	}
	
	/**
	 * Method to print the menu of operations
	 */
	public static void printMenu() {
		try {
			System.out.println(".........Main Menu.......");
			System.out.println("1 : find Transpose of a matrix");
			System.out.println("2 : check whether the matrix is a symmetrical or not");
			System.out.println("3 : add two matrices");
			System.out.println("4 : multiply two matrices");
			System.out.println("5 : EXIT");
		}
		catch(Exception e) {
			System.out.println("Exception occured in printMenu method");
		}
	}
	
	public static void main(String[] args) {
		int option;
		System.out.println("Enter the number of rows : ");
		int numOfRows = takeIntInput();
		System.out.println("Enter the number of columns : ");
		int numOfCols = takeIntInput();
		HashMap<Pair, Integer> matrix = takeMatrixInput(numOfRows, numOfCols);
		SparseMatrix matrix1 = new SparseMatrix(numOfRows, numOfCols, matrix);
		do {
			printMenu();
			option = takeIntInput();
			switch(option) {
				case 1 : {
					// case for transpose of a matrix
					
					System.out.println("Transpose of the matrix is : ");
					printMatrix(matrix1.MatrixTranspose(), numOfCols, numOfRows);
					break;
				}
				case 2 : {
					// case for symmetric matrix check
					
					if(matrix1.isSymmetric()) System.out.println("Yes, it is a symmetic matrix");
					else System.out.println("No, it is not a symmetic matrix");
					break;
				}
				case 3 : {
					// case for adding two matrices
					
					System.out.println("Enter the number of rows of the other matrix : ");
					int numOfRows2 = takeIntInput();
					System.out.println("Enter the number of columns of other matrix : ");
					int numOfCols2 = takeIntInput();
					System.out.println("Enter the second matrix : ");
					HashMap<Pair, Integer> matrixSecond = takeMatrixInput(numOfRows2, numOfCols2);
					SparseMatrix matrix2 = new SparseMatrix(numOfRows2, numOfCols2, matrixSecond);
					if(matrix1.getNumOfRows() != matrix2.getNumOfRows() || matrix1.getNumOfCols() != matrix2.getNumOfCols()) {
						System.out.println("Matrices must be of same dimension");
						break;
					}
					System.out.println("Resulting matrix is : ");
					printMatrix(matrix1.addMatrix(matrix2), numOfRows, numOfCols);
					break;
				}
				case 4 : {
					// case for multiply two matrices
					
					System.out.println("Enter the number of rows of the other matrix : ");
					int numOfRows2 = takeIntInput();
					System.out.println("Enter the number of columns of other matrix : ");
					int numOfCols2 = takeIntInput();
					System.out.println("Enter the second matrix : ");
					HashMap<Pair, Integer> matrixSecond = takeMatrixInput(numOfRows2, numOfCols2);
					SparseMatrix matrix2 = new SparseMatrix(numOfRows2, numOfCols2, matrixSecond);
					if(matrix1.getNumOfCols() != matrix2.getNumOfRows()) {
						System.out.println("Number of Columns in matrix1 must be equal to number of Rows in matrix2");
						break;
					}
					System.out.println("Resulting matrix is : ");
					printMatrix(matrix1.multiplyMatrix(matrix2), numOfRows, numOfCols2);
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
