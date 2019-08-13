public class ChildNodeList {

	private Node front = null;
	private Node rear = null;

	/** function to add node in linkedList
	 * @param data, integer type data 
	 * @return, true if node added
	 */
	public boolean addNode(TreeNode data) {

		if (front == null) {
			this.front = new Node(data);
			this.rear = this.front;
		} else {
			this.rear.next = new Node(data);
			this.rear = this.rear.next;
		}
		return true;
	}

	/**
	 * shows current linkedList 
	 */
	public void showList() {
		Node node = front;
		while (node != null) {
			System.out.print(node.getData() + " -> ");
			node = node.next;
		}
	}
	
	// getters and setter
	public Node getFront() {
		return front;
	}

	public Node getRear() {
		return rear;
	}
}
