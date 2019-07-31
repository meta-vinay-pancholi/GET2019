/**
 * @author Vinay
 * @date 30/7/19
 */
public class LinkedList {
	Node head; // head of list

	static class Node {
		int data;
		Node next;

		// Constructor
		Node(int d) {
			data = d;
			next = null;
		}
	}

	/**
	 * @param list of type linked list
	 * @param data
	 * @return list
	 * Method to insert a new node and returning a list of type LinkedList
	 */
	public static LinkedList insert(LinkedList list, int data[]) {
		// Create a new node with given data
		for (int i = 0; i < data.length; i++) {
			Node new_node = new Node(data[i]);
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
		}
		// Return the list by head
		return list;
	}

	/**
	 * @param list
	 * Method to print the LinkedList.
	 */
	public static void printList(LinkedList list) {
		Node currNode = list.head;
		System.out.print("LinkedList: ");
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
			// Go to next node
			currNode = currNode.next;
		}
	}

	/**
	 * This function is creating a sublist for rotation
	 * @param list
	 * @param left
	 * @param right
	 * @return subList of type LinkedList
	 */
	public static LinkedList subListCreation(LinkedList list, int left, int right) {
		Node currNode = list.head;
		Node leftNode;
		Node rightNode;
		LinkedList subList = new LinkedList();

		int i = 0;
		while (i != (left - 1)) {
			i++;
			currNode = currNode.next;
		}
		leftNode = currNode;
		leftNode.data = currNode.data;
		currNode = list.head;
		i = 0;
		while (i != (right - 1)) {
			i++;
			currNode = currNode.next;
		}
		rightNode = currNode;
		rightNode.data = currNode.data;
		i = 0;
		currNode = leftNode;
		int data[] = new int[right - left + 1];
		int j = 0;
		while (currNode != rightNode.next) {
			data[j] = currNode.data;
			currNode = currNode.next;
			j++;
		}
		insert(subList, data);
		return subList;
	}

	/**
	 * This function is used to rotate the subList for given numberOfRotation
	 * @param list
	 * @param left
	 * @param right
	 * @param numberOfRotation
	 * @return rotationArray
	 */
	public int[] rotation(LinkedList list, int left, int right, int numberOfRotation) {
		LinkedList subList = subListCreation(list, left, right);

		while (numberOfRotation != 0) {
			Node firstNode = subList.head;
			Node currNode = subList.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = firstNode;
			subList.head = firstNode.next;
			firstNode.next = null;
			numberOfRotation--;
		}
		LinkedList result = join(list, subList, left, right);	
		Node current =result.head ;
		int count = 0;//to count number of element in my list
		while(current.next != null){
			count++;
			current = current.next;
		}
		int rotationArray[] = new int[count+1];//created a array of size count +1
		int j = 0;
		current = result.head;
		while(current != null ){
			rotationArray[j] = current.data;
			current = current.next;
			j++;
		}
		return rotationArray;
	}

	/**
	 * This function is joining the subList back into main list
	 * @param mainList
	 * @param subList
	 * @param left
	 * @param right
	 * @return mainList
	 */
	public LinkedList join(LinkedList mainList, LinkedList subList, int left, int right) {
		Node head1 = mainList.head;
		Node head2 = subList.head;
		Node currNode1 = mainList.head;
		Node currNode2 = subList.head;

		int i = 0;
		if (left == 1) {
			mainList.head = head2;
			
			while (i != (right)) {
				i++;
				currNode1 = currNode1.next;
			}
			
			while (currNode2.next != null) {
				currNode2 = currNode2.next;
			}
			currNode2.next = currNode1;
			
		} else {
			i = 0;
			while (i != (right - 1)) {
				i++;
				head1 = head1.next;
			}
			
			i = 0;
			while (i != (left - 2)) {
				i++;
				currNode1 = currNode1.next;
			}
			
			currNode1.next = subList.head;
			
			while (currNode2.next != null) {
				currNode2 = currNode2.next;
			}
			currNode2.next = head1.next;
		}
		return mainList;
	}
}
