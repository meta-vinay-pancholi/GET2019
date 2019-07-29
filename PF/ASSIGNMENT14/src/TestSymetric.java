import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestSymetric {

	private boolean expectedResult;
	private static SparceMatrix SparceMatrix1;

	@Before
	public void initialize() {
		SparceMatrix1 = new SparceMatrix(new int[][] { {2,0,1},{0,1,2},{1,2,2} });
	}

	public TestSymetric(boolean expectedResult, SparceMatrix SparceMatrix1) {
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
		return Arrays
				.asList(new Object[][] { {false, SparceMatrix1}});
	}

	@Test
	public void testSymetric() {
		assertEquals(expectedResult, SparceMatrix1.symetric());
	}

}

