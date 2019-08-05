import static org.junit.Assert.*;
import org.junit.Test;

public class TestLoop {
	@Test
	public void testRotation1() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		LoopInLinkedList list = new LoopInLinkedList();
		list.push(data);
		boolean result = list.detectLoop();
		boolean expectedData = true;
		assertEquals(expectedData, result);
	}
}
