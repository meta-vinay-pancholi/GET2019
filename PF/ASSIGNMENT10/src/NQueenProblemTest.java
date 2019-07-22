import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NQueenProblemTest {

	private int[][] inputArray;
	private int[][] expectedResult;
	private NQueenProblem Nqueens;

	@Before
	public void initialize() {
		Nqueens = new NQueenProblem();
	}

	public NQueenProblemTest(int[][] expectedResult, int[][] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {
				new int[][] { { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 },
						{ 0, 0, 1, 0 } },
				new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 } } } });
	}

	@Test
	public void nQueen() {
		assertArrayEquals(expectedResult, Nqueens.printValue(inputArray));//print value function is calling first
	}
}
