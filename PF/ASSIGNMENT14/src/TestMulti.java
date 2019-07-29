import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestMulti {

	private int expectedResult[][];
	private static SparceMatrix SparceMatrix1;
	private int[][] inputmatrix;

	@Before
	public void initialize() {
		SparceMatrix1 = new SparceMatrix(new int[][] { { 0, 10, 12 },
				{ 1, 0, 2 } });
	}

	public TestMulti(int expectedResult[][], SparceMatrix SparceMatrix1 ,int[][] inputmatrix) {
		this.expectedResult = expectedResult;
		this.inputmatrix = inputmatrix;
		this.SparceMatrix1 = SparceMatrix1;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { {
				new int[][] { { 96, 0, 10 }, { 18, 5, 0 } },SparceMatrix1,
				new int[][] { { 2, 5, 0 }, { 0, 1, 0 }, { 8, 0, 0 } } } });
	}

	@Test
	public void testMulti() {
		assertArrayEquals(expectedResult,SparceMatrix1.multiplication(inputmatrix));
	}

}
