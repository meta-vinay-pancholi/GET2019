import static org.junit.Assert.*;
import org.junit.Test;

public class TestEmployee {
	@Test
	public void testRotation1() {
		Employee employee = new Employee();
		Employee.insert(employee, 12, 10990, "Vikas");
		Employee.insert(employee, 0, 100001, "Vinay");
		Employee.insert(employee, 11, 10030, "Vinod");
		Employee.insert(employee, 12, 11000, "Rivak");
		Employee.insert(employee, 9, 13020, "Bhupendra");
		Employee.insert(employee, 41, 10000, "Vartika");
		Employee.insert(employee, 8, 10000, "Surendra");
		Employee.insert(employee, 1, 11000, "Ajay");
		Employee.insert(employee, 6, 11000, "Manoj");
		employee.sortSalary();
		String[] result = Employee.printList(employee);
		String[] expectedData = { "Vinay", "Bhupendra", "Ajay", "Manoj", "Rivak", "Vikas", "Vinod", "Surendra", "Vartika" };
		assertArrayEquals(expectedData, result);
	}
}
