import java.util.Scanner;

public class NQueenClass {
	
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
            if(value <= 0) {
            	System.out.println("Dimension of the board must be a positive integer");
            	continue;
            }
            else break;
        }
        return value;
    }
	
	/**
	 * method to initialize the board with zero
	 * @param board
	 * @param queen
	 * @param n
	 */
	public void initializeBoard(int[][] board, int[] queen, int n) {
		try {
			for(int i = 0; i < n; i++) {
				queen[i] = -1;
				for(int j = 0; j < n; j++) {
					board[i][j] = 0;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in initializeBoard method");
		}
	}
	
	/**
	 * Method to check that no previous queens placed
	 * in the previous rows are attacking the current position
	 * @param queen
	 * @param curRow
	 * @param curCol
	 * @param n
	 * @return true/false
	 */
	public boolean checkAttacking(int[] queen, int curRow, int curCol, int n) {
		try {
			for(int i = 0; i < curRow; i++) {
				if(queen[i] == curCol || Math.abs(curRow - i) == Math.abs(curCol - queen[i])) return false;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in checkAttacking method");
		}
		return true;
	}
	
	/**
	 * Method to find a possible positioning
	 * of the n queens on the n x n board
	 * such that no two queen are attacking each other
	 * @param board
	 * @param queen
	 * @param curRow
	 * @param n
	 * @return
	 */
	public boolean nQueen(int[][] board, int[] queen, int curRow, int n) {
		try {
			if(curRow == n) return true;
			for(int col = 0; col < n; col++) {
				if(checkAttacking(queen, curRow, col, n)) {
					board[curRow][col] = 1;
					queen[curRow] = col;
					if(nQueen(board, queen, curRow + 1, n)) return true;
					else {
						board[curRow][col] = 0;
						queen[curRow] = -1;
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in nQueen method");
		}
		return false;
	}
	
	/**
	 * Method to print the borad
	 * representing the queens positioning
	 * @param board
	 * @param n
	 */
	public void printBoard(int[][] board, int n) {
		try {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in printBoard method");
		}
	}

	public static void main(String[] args) {
		NQueenClass obj = new NQueenClass();
		int n;
		System.out.println("Enter the dimension of the board");
		n = takeIntInput();
		int[][] board = new int[n][n];
		int[] queen = new int[n];
		obj.initializeBoard(board, queen, n);
		if(obj.nQueen(board, queen, 0, n)) {
			obj.printBoard(board, n);
		}
	}

}
