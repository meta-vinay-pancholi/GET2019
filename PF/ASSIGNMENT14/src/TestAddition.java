import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestAddition {

	private int expectedResult[][];
	private static SparceMatrix SparceMatrix1;
	private int[][] inputmatrix;

	@Before
	public void initialize() {
		SparceMatrix1 = new SparceMatrix(new int[][] { {2,0,1},{0,1,2},{1,2,2} });
	}

	public TestAddition(int expectedResult[][], int[][] inputmatrix) {
		this.expectedResult = expectedResult;
		this.inputmatrix=inputmatrix;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays
				.asList(new Object[][] { {
						new int[][] { {0,0,4}, {0,2,2}, {1,1,2 },
								{1,2,4},{2,0,2},{2,1,4},{2,2,4} },
						new int[][] { {2,0,1},{0,1,2},{1,2,2} } } });
	}

	@Test
	public void testAddition() {
		assertArrayEquals(expectedResult, SparceMatrix1.addition(inputmatrix));
	}

}
