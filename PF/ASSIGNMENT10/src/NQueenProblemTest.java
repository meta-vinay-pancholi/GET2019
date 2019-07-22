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
	private boolean expectedResult;
	private int row;
	private int numberOfQueen;
	private NQueenProblem Nqueens;

	@Before
	public void initialize() {
		Nqueens = new NQueenProblem();
	}

	public NQueenProblemTest(boolean expectedResult, int[][] inputArray, int row) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
		this.row = row;
		this.numberOfQueen = numberOfQueen;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ true, new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0 },
				{ true, new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } }, 0}

		});
	}

	@Test
	public void nQueen() {
		assertEquals(true, Nqueens.solveNQueen(inputArray, row));
	}
}