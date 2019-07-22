
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
public class BinarySearchTest {
	private int[] input1;
	private int input2;
	private int expectedResult;
	private Search search;

	@Before
	public void initialize() {
		search = new Search();
	}

	public BinarySearchTest(int expectedResult, int[] input1, int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 3},
				{ 7, new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7},
				{ 9, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 9 },
				{ -1, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 11 }
		});
	}

	@Test
	public void testBinarySearch() {
		assertEquals(expectedResult, search.binarySearch(input1, input2));
	}
}
