import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

public class SparseMatrixTest {

    @Test
    public void testMatrixTranspose() {
        HashMap<Pair, Integer> matrix = new HashMap<>();
        matrix.put(new Pair(0, 1), 3);
        matrix.put(new Pair(1, 0), 2);

        SparseMatrix sparseMatrix = new SparseMatrix(2, 2, matrix);
        HashMap<Pair, Integer> transposed = sparseMatrix.MatrixTranspose();

        assertEquals(3, transposed.get(new Pair(1, 0)));
        assertEquals(2, transposed.get(new Pair(0, 1)));
        assertNull(transposed.get(new Pair(0, 0)));
        assertNull(transposed.get(new Pair(1, 1)));
    }

    @Test
    public void testIsSymmetric() {
        HashMap<Pair, Integer> matrix = new HashMap<>();
        matrix.put(new Pair(0, 1), 3);
        matrix.put(new Pair(1, 0), 3);

        SparseMatrix sparseMatrix = new SparseMatrix(2, 2, matrix);
        assertTrue(sparseMatrix.isSymmetric());

        matrix.put(new Pair(1, 1), 1);
        sparseMatrix = new SparseMatrix(2, 2, matrix);
        assertTrue(sparseMatrix.isSymmetric());
    }

    @Test
    public void testAddMatrix() {
        HashMap<Pair, Integer> matrix1 = new HashMap<>();
        matrix1.put(new Pair(0, 0), 1);
        matrix1.put(new Pair(1, 1), 2);

        SparseMatrix sparseMatrix1 = new SparseMatrix(2, 2, matrix1);

        HashMap<Pair, Integer> matrix2 = new HashMap<>();
        matrix2.put(new Pair(0, 0), 3);
        matrix2.put(new Pair(1, 0), 4);

        SparseMatrix sparseMatrix2 = new SparseMatrix(2, 2, matrix2);

        HashMap<Pair, Integer> result = sparseMatrix1.addMatrix(sparseMatrix2);

        assertEquals(4, result.get(new Pair(0, 0)));
        assertEquals(2, result.get(new Pair(1, 1)));
        assertEquals(4, result.get(new Pair(1, 0)));
        assertNull(result.get(new Pair(0, 1)));
    }

    @Test
    public void testMultiplyMatrix() {
        HashMap<Pair, Integer> matrix1 = new HashMap<>();
        matrix1.put(new Pair(0, 0), 1);
        matrix1.put(new Pair(0, 1), 2);
        matrix1.put(new Pair(1, 0), 3);
        matrix1.put(new Pair(1, 1), 4);

        SparseMatrix sparseMatrix1 = new SparseMatrix(2, 2, matrix1);

        HashMap<Pair, Integer> matrix2 = new HashMap<>();
        matrix2.put(new Pair(0, 0), 2);
        matrix2.put(new Pair(1, 0), 0);
        matrix2.put(new Pair(0, 1), 1);
        matrix2.put(new Pair(1, 1), 2);

        SparseMatrix sparseMatrix2 = new SparseMatrix(2, 2, matrix2);

        HashMap<Pair, Integer> result = sparseMatrix1.multiplyMatrix(sparseMatrix2);

        assertEquals(2, result.get(new Pair(0, 0)));
        assertEquals(5, result.get(new Pair(0, 1)));
        assertEquals(6, result.get(new Pair(1, 0)));
        assertEquals(11, result.get(new Pair(1, 1)));
    }
}