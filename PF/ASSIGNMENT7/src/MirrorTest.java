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
public class MirrorTest {
	private int[] inputArray;
	private int expectedResult;
	private ArrOperation arrOperations;

	@Before
	public void initialize() {
		arrOperations = new ArrOperation();
	}

	public MirrorTest(int expectedResult, int[] inputArray) {
		this.expectedResult = expectedResult;
		this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {
						{ 3, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 } },
						{ 2, new int[] { 7, 1, 4, 9, 7, 4, 1 } },
						{ 3, new int[] { 1, 2, 1, 4 } },
						{ 7, new int[] { 1, 4, 5, 3, 5, 4, 1 } },
						{ 0, new int[] {} } });
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, arrOperations.maxMirror(inputArray));
	}
}
