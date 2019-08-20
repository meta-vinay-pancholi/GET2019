import java.util.ArrayList;

public class Employee {
	public Node head;

	public static class Node {
		int age;
		float salary;
		String name;
		Node next;

		public Node(int age, float salary, String name) {
			super();
			this.age = age;
			this.salary = salary;
			this.name = name;
		}
	}

	/**
	 * @param list of type linked list
	 * @param data
	 * @return list Method to insert new Employee into linked list
	 */
	public static Employee insert(Employee list, int age, float salary,
			String name) {
		// Create a new node with given data
		Node new_node = new Node(age, salary, name);
		new_node.next = null;
		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			// Insert the new_node at last node
			last.next = new_node;
		}
		// Return the list by head
		return list;
	}

	/**
	 * @param method to print the LinkedList.
	 */
	public static String[] printList(Employee list) {
		Node currNode = list.head;
		String[] nameofemp = new String[9];
		// Traverse through the LinkedList
		int i=0;
		while (currNode != null) {
			// Print the data at current node
			nameofemp[i]=currNode.name;
			currNode = currNode.next;
			i++;
		}
		return nameofemp;
	}

	/* To sort the linked list */
	void sortSalary() {
		Node start = this.head;
		Node traverse;
		Node max;

		while (start.next != null) {
			max = start;
			traverse = start.next;
			while (traverse != null) {
				/* Find max element */
				if (max.salary < traverse.salary
						|| (max.salary == traverse.salary && max.age > traverse.age)) {
					max = traverse;
				}
				traverse = traverse.next;
			}
			swap(start, max); // Put max element on starting location
			start = start.next;
		}
	}
	
	/* swap data field of linked list */
	void swap(Node p1, Node p2) {
		float temp = p1.salary;
		p1.salary = p2.salary;
		p2.salary = temp;

		String temp1 = p1.name;
		p1.name = p2.name;
		p2.name = temp1;

		int temp3 = p1.age;
		p1.age = p2.age;
		p2.age = temp3;

	}
}
