import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestTranspose {
	private int expectedResult[][];
	private static SparceMatrix SparceMatrix1;

	@Before
	public void initialize() {
		SparceMatrix1 = new SparceMatrix(new int[][] { {2,0,1},{0,1,2},{1,2,2} });
	}

	public TestTranspose(int expectedResult[][], int[][] inputmatrix) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays
				.asList(new Object[][] { {
						new int[][] { { 0, 0 ,2}, {2, 0 ,1}, { 1, 1 ,1 },
								{2, 1 ,2},{ 0 ,2 ,1},{1 ,2 ,2},{2, 2 ,2}},SparceMatrix1 }});
	}

	@Test
	public void testTranspose() {
		assertArrayEquals(expectedResult, SparceMatrix1.transpose());
	}

}
