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
public class LinearSearchTest {
	private int[] input1;
	private int input2;
	private int expectedResult;
	private Search search;

	@Before
	public void initialize() {
		search = new Search();
	}

	public LinearSearchTest(int expectedResult, int[] input1, int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 2, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 2 },
				{ -1, new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 7 },
				{ 9, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 9 } });
	}

	@Test
	public void testLinearSearch() {
		assertEquals(expectedResult, search.linearSearch(input1, input2));
	}
}
