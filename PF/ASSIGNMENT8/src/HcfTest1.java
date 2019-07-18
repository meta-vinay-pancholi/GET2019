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
public class HcfTest1 {
	private int input1;
	private int input2;
	private int expectedResult;
	private MathOperation mathOperation;

	@Before
	public void initialize() {
		mathOperation = new MathOperation();
	}

	public HcfTest1(int expectedResult, int input1, int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 2, 2, 6 }, { 1, 2, 3 },
				{ 15, 30, 15 }, { 0, 0, 0 } });
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, mathOperation.hcfCalculate(input1, input2));
	}
}
