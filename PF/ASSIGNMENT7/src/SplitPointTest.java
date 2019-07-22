import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Parameterized.class)
public class SplitPointTest {
	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public SplitPointTest(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 1, 1, 2, 1 } },
				{ -1, new int[] { 2, 1, 1, 2, 1 } },
				{ 1, new int[] { 10, 10 } }, { 0, new int[] {} } });
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, arrOperations.findSplitPoint(inputArray));
	}
}
