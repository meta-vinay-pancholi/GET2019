import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MultiplyPolyTestCases {
	private String expectedResult;
	private static Polynomial Polynomial;
	private static Polynomial Polynomial1;

	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[] { 3, 2, 1, 1 }, new int[] { 2, 1,
				0, 0 });
		Polynomial1 = new Polynomial(new int[] { 3, 2, 1, 1 }, new int[] { 2,
				1, 0, 0 });
	}

	public MultiplyPolyTestCases(String expectedResult, Polynomial Polynomial,
			Polynomial Polynomial1) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { { "9x^4 12x^3 16x^2 8x^1 4x^0 ",
				Polynomial, Polynomial1 } });
	}

	@Test
	public void testIntSet1() {
		assertEquals(expectedResult,
				Polynomial1.multiPoly(Polynomial, Polynomial1));
	}

}
