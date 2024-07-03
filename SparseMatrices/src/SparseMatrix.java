import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * class representing pair of integers
 */
class Pair {
	private int rowNum;
	private int colNum;
	
	/**
	 * Constructor setting up the values
	 * of the rowNum and colNum
	 * @param rowNum
	 * @param colNum
	 */
	public Pair(int rowNum, int colNum) {
		this.rowNum = rowNum;
		this.colNum = colNum;
	}
	
	/**
	 * Overriding the equals method of the Object class
	 */
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Pair p = (Pair) obj;
		return rowNum == p.rowNum && colNum == p.colNum;
	}
	
	public int hashCode() {
		return Objects.hash(rowNum, colNum);
	}
}

public final class SparseMatrix {
	private final int numOfRows;
	private final int numOfCols;
	
	private final HashMap<Pair, Integer> elementsOfMatrix;
	
	/**
	 * Constructor to set up the data members
	 * of the SparseMatrix data members
	 * @param numOfRows
	 * @param numOfCols
	 * @param matrix
	 */
	public SparseMatrix(int numOfRows, int numOfCols, HashMap<Pair, Integer> matrix) {
		this.numOfRows = numOfRows;
		this.numOfCols = numOfCols;
		
		HashMap<Pair, Integer> temp = new HashMap<>();
		
		for(Map.Entry<Pair, Integer> entry : matrix.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		
		this.elementsOfMatrix = temp;
	}
	
	/**
	 * getter for numOfRows
	 * @return
	 */
	public int getNumOfRows() {
		return numOfRows;
	}
	
	/**
	 * getter for numOfCols
	 * @return
	 */
	public int getNumOfCols() {
		return numOfCols;
	}
	
	/**
	 * getter for elementsOfMatrix
	 * @return
	 */
	public HashMap<Pair, Integer> getElementsOfMatrix()
    {
		HashMap<Pair, Integer> temp = new HashMap<>();
		try {
			for(Map.Entry<Pair, Integer> entry : elementsOfMatrix.entrySet()) {
				temp.put(entry.getKey(), entry.getValue());
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in getElementsOfMatrix method");
		}
        return temp;
    }
	
	/**
	 * Method to find transpose of a matrix
	 * @return
	 */
	public HashMap<Pair, Integer> MatrixTranspose() {
		HashMap<Pair, Integer> temp = new HashMap<>();
		
		try {
			for(int i = 0; i < numOfRows; i++) {
				for(int j = 0; j < numOfCols; j++) {
					Pair curIndex = new Pair(i, j);
					Pair transposeIndex = new Pair(j, i);
					if(elementsOfMatrix.containsKey(curIndex)) {
						temp.put(transposeIndex, elementsOfMatrix.get(curIndex));
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in MatrixTranspose method");
		}
		return temp;
	}
	
	/**
	 * Method to find if a matrix is symmetric or not
	 * @return
	 */
	public boolean isSymmetric() {
		HashMap<Pair, Integer> transposeMatrix = MatrixTranspose();
		try {
			for(Map.Entry<Pair, Integer> entry : elementsOfMatrix.entrySet()) {
				if(transposeMatrix.containsKey(entry.getKey())) {
					if(transposeMatrix.get(entry.getKey()) != entry.getValue()) return false;
				}
				else return false;
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in isSymmetric method");
		}
		return true;
	}
	
	/**
	 * Method to add two matrices
	 * @param secondMatrix
	 * @return
	 */
	public HashMap<Pair, Integer> addMatrix(SparseMatrix secondMatrix) {
		HashMap<Pair, Integer> result = new HashMap<>();
		HashMap<Pair, Integer> otherMatrix = secondMatrix.getElementsOfMatrix();
		// check that both matrices must be of same dimensions
		if(numOfRows != secondMatrix.getNumOfRows() || numOfCols != secondMatrix.getNumOfCols()) {
			throw new AssertionError("Matrices must be of same dimension");
		}
		try {
			for(int i = 0; i < numOfRows; i++) {
				for(int j = 0; j < numOfCols; j++) {
					Pair curIndex = new Pair(i, j);
					int value = 0;
					if(elementsOfMatrix.containsKey(curIndex)) value += elementsOfMatrix.get(curIndex);
					if(otherMatrix.containsKey(curIndex)) value += otherMatrix.get(curIndex);
					if(value != 0) result.put(curIndex, value);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in addMatrix method");
		}
		return result;
	}
	
	/**
	 * Method to multiply two matrices
	 * @param secondMatrix
	 * @return
	 */
	public HashMap<Pair, Integer> multiplyMatrix(SparseMatrix secondMatrix) {
		HashMap<Pair, Integer> result = new HashMap<>();
		HashMap<Pair, Integer> otherMatrix = secondMatrix.getElementsOfMatrix();
		int secNumCols = secondMatrix.getNumOfCols();
		// check dimensions conditions for matrix multiplication
		if(numOfCols != secondMatrix.getNumOfRows()) {
			throw new AssertionError("Number of Columns in matrix1 must be equal to number of Rows in matrix2");
		}
		try {
			for(int i = 0; i < numOfRows; i++) {
				for(int j = 0; j < secNumCols; j++) {
					Pair curIndex = new Pair(i, j);
					int value = 0;
					for(int k = 0; k < numOfCols; k++) {
						Pair curIndexMatrix1 = new Pair(i, k);
						Pair curIndexMatrix2 = new Pair(k, j);
						if(elementsOfMatrix.containsKey(curIndexMatrix1) && otherMatrix.containsKey(curIndexMatrix2)) {
							value += (elementsOfMatrix.get(curIndexMatrix1) * otherMatrix.get(curIndexMatrix2));
						}
					}
					if(value != 0) result.put(curIndex, value);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured in multiplyMatrix method");
		}
		return result;
	}
}
