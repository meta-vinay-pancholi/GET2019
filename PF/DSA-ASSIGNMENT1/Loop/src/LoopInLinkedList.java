// Java program to detect loop in a linked list 
class LoopInLinkedList { 
	Node head; // head of list
	/* Linked list Node*/
	class Node { 
		int data; 
		Node next; 
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	/* Inserts a new Node at front of the list. */
	public  void push(int new_data[]) { 
		for(int i = 0; i < new_data.length ; i++) {
			Node new_node = new Node(new_data[i]); 
			new_node.next = head; 
			head = new_node; 
		}
		head.next.next.next.next = head; 
	   detectLoop(); 
	} 

	public boolean detectLoop() { 
		Node slow_p = head, fast_p = head; 
		while (slow_p != null && fast_p != null && fast_p.next != null) { 
			slow_p = slow_p.next; 
			fast_p = fast_p.next.next; 
			if (slow_p == fast_p) { 
				System.out.println("Found loop"); 
				return true; 
			} 
		} 
		return false; 
	} 
} 