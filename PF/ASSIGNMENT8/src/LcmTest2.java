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
public class LcmTest2 {
	private int input1;
	private int input2;
	private int expectedResult;
	private MathOperation mathOperation;

	@Before
	public void initialize() {
		mathOperation = new MathOperation();
	}

	public LcmTest2(int expectedResult, int input1, int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 6, 2, 6 }, { 6, 2, 3 },
				{ 30, 10, 15 }, { 9, 3, 9 }, { 0, 0, 0 }, { 0, 7, 0 } });
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, mathOperation.lcmCalculate(input1, input2));
	}
}
