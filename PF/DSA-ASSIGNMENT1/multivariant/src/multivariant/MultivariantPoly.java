package multivariant;
/**
 * @author Vinay
 * @date 31/7/19
 * This class is creating link list and returning maximum degree of pollynomial
 */
public class MultivariantPoly {
	Node head = null;

	class Node {
		int data;
		Node next;
		Node down;

		Node(int data) {
			this.data = data;
			this.down = null;
			this.next = null;
		}
	}

	/**
	 * @param coff
	 * @param exponent
	 * Helper method to call createLinkList function()
	 */
	public void helper(int coff[], int exponent[][]) {
		int expo[] = new int[exponent[0].length];
		for (int i = 0; i < coff.length; i++) {
			for (int j = 0; j < exponent[0].length; j++) {
				expo[j] = exponent[i][j];
			}
			createLinkList(coff[i], expo);
		}
	}

	/**
	 * @param coeff
	 * @param expoArr
	 * This method is creating linked list
	 */
	public void createLinkList(int coeff, int[] expoArr) {
		Node newNode = new Node(coeff);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		for (int i = 0; i < expoArr.length; i++) {
			Node newNode1 = new Node(expoArr[i]);
			newNode.down = newNode1;
			newNode = newNode1;
		}
	}

	/**
	 * @return max
	 * It is a method used to find max degree of the polynomial.
	 */
	public int findDegree() {
		int max = 0;
		if (head == null) {
			System.out.println("No items in the list!!!");
			return 0;
		}
		Node temp = head;
		while (temp != null) {
			int sum = 0;
			Node temp1 = temp;
			while (temp1.down != null) {
				sum = sum + temp1.down.data;
				temp1 = temp1.down;
			}
			if (sum > max) {
				max = sum;
			}
			temp = temp.next;
		}
		return max;
	}
}