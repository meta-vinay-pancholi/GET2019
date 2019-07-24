import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AddPolyTestCaseTest {
	private int expectedResult[];
	private static Polynomial Polynomial;
	private static Polynomial Polynomial1;

	@Before
	public void initialize() {
		Polynomial = new Polynomial(new int[] { 3, 2, 1, 1 }, new int[] { 3, 2,
				1, 0 });
		Polynomial1 = new Polynomial(new int[] { 4, 2, 1 },
				new int[] { 2, 1, 0 });
	}

	public AddPolyTestCaseTest(int expectedResult[], Polynomial Polynomial,
			Polynomial Polynomial1) {
		this.expectedResult = expectedResult;
		this.Polynomial = Polynomial;
		this.Polynomial1 = Polynomial1;

	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays.asList(new Object[][] { { new int[] { 6, 3, 2, 3 },
				Polynomial, Polynomial1 }, });
	}

	@Test
	public void testadd() {
		assertArrayEquals(expectedResult,
				Polynomial1.addPoly(Polynomial, Polynomial1));
	}
}
