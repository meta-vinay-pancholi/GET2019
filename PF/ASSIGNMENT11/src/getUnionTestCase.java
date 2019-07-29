import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class getUnionTestCase {

	private int expectedResult[];
	private static IntSet IntSet1;
	private static IntSet IntSet2;

	@Before
	public void initialize() {
		IntSet1 = new IntSet(new int[] { 1, 2, 3, 7, 8, 9, });
		IntSet2 = new IntSet(new int[] { 1, 2, 3, 6, 10 });
	}

	public getUnionTestCase(int expectedResult[], IntSet s1, IntSet s2) {
		this.expectedResult = expectedResult;
		this.IntSet1 = s1;
		this.IntSet2 = s2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { {
				new int[] { 1, 2, 3, 7, 8, 9, 6, 10 }, IntSet1, IntSet2 } });
	}

	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, IntSet1.getUnion(IntSet1, IntSet2));
	}

}
