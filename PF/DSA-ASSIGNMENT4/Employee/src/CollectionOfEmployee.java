import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollectionOfEmployee {
	ArrayList<Employee> emp = new ArrayList<Employee>();//creating array list of Employee
	Set<Integer> empId = new HashSet<Integer>();//creating set employee Id's
	Scanner sc = new Scanner(System.in);

	public void addEmployee(int size) {
		int id = 0;
		String name = null;
		String address = null;
		for (int i = 0; i < size; i++) {
			System.out.println("Enter name");
			name = sc.nextLine();
			System.out.println("Enter id");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter address");
			address = sc.nextLine();
			if (empId.contains(id)) {
				System.out.println("Employee Id already exist");
			} else {
				empId.add(id);
				emp.add(addEmployee(id, name, address));
			}
		}
	}

	public void sortingById() {
		for (int i = 0; i < emp.size() - 1; i++) {
			for (int j = 0; j < emp.size() - i - 1; j++)
				if (emp.get(j).empId > emp.get(j + 1).empId) {
					Employee temp1 = emp.get(j);
					Employee temp2 = emp.get(j + 1);
					emp.set(j, temp2);
					emp.set(j + 1, temp1);
				}
		}

	}

	public void sortingByName() {
		for (int i = 0; i < emp.size() - 1; i++) {
			for (int j = 0; j < emp.size() - i - 1; j++)
				if ((emp.get(j).name).compareTo(emp.get(j + 1).name) > 0) {
					Employee temp1 = emp.get(j);
					Employee temp2 = emp.get(j + 1);
					emp.set(j, temp2);
					emp.set(j + 1, temp1);
				}
		}
	}

	public void show() {
		System.out.println("Id \t\t\t Name \t\t\t Address");
		for (int i = 0; i < emp.size(); i++) {
			System.out.println(emp.get(i).empId + "\t\t\t" + emp.get(i).name
					+ "     \t\t\t" + emp.get(i).adress);
		}
	}

	private Employee addEmployee(int key, String name, String address) {
		return new Employee(key, name, address);
	}

	public static void main(String... args) {
		CollectionOfEmployee employee = new CollectionOfEmployee();
		employee.addEmployee(5);
		employee.show();
		System.out.println("ID sorting");
		employee.sortingById();
		employee.show();
		System.out.println("Name Sorting");
		employee.sortingByName();
		employee.show();
	}
}
