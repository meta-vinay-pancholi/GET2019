import static org.junit.Assert.*;
import org.junit.Test;

public class TestPriorityQueue {
	@Test
	public void testAddElement() {
		PriorityQueue queueObj = new PriorityQueue(6);
		int[] data = { 10, 11, 12, 13, 14, 15};
		int[] priority = { 7, 8, 1, 82, 65, 35};
		for(int i = 0; i < 6 ; i++) {
			queueObj.enque(data[i], priority[i]);
		}
		int[] result = queueObj.show();
		int[] expectedData = {10, 11, 12, 13, 14, 15};
		assertArrayEquals(expectedData, result);
	}
	
	@Test
	public void testDequeue() {
		PriorityQueue queueObj1 = new PriorityQueue(6);
		int[] data = { 10, 11, 12, 13, 14, 15};
		int[] priority = { 7, 8, 1, 82, 65, 35};
		for(int i = 0; i < 6 ; i++) {
			queueObj1.enque(data[i], priority[i]);
		}
	     queueObj1.deque();
	     queueObj1.deque();
		int[] result1 = queueObj1.show();
		int[] expectedData = { 10, 11, 12, 15};
		assertArrayEquals(expectedData, result1);
	}
	
}
