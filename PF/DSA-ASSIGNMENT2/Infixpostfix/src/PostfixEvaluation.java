/**
 * This class evaluating the post fix expression
 * @author Vinay
 */
public class PostfixEvaluation {
	static Node top;

	static class Node {
		int data;
		Node next;

		Node() {
			this.next = null;
		}
	}

	public static void stackInsert(int data) {
		Node nptr = new Node();
		nptr.data = data;
		if (top == null)
			top = nptr;
		else {
			Node temp;
			temp = top;
			top = nptr;
			nptr.next = temp;
		}
	}

	public static int pop() {
		if (isEmpty())
			return 0;
		int data = top.data;
		top = top.next;
		return data;
	}

	public static int peek() {
		if (top == null) {
			return 0;
		} else
			return top.data;
	}

	public static boolean isEmpty() {
		return top == null;
	}

	public void display() {
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow");
		} else {
			Node temp = top;
			while (temp != null) {
				System.out.printf("%d->", temp.data);
				temp = temp.next;
			}
		}
	}

	/**
	 * @param exp
	 * @return last
	 * This function is used to evaluate the postfix expression
	 */
	static int evaluatePostfix(String exp) {
		
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				stackInsert(c - '0');
			}
			else {
				int val1 = pop();
				int val2 = pop();
				switch (c) {
				case '+':
					int ans = val2 + val1;
					stackInsert(ans);
					break;
				case '-':
					int ans1 = val2 - val1;
					stackInsert(ans1);
					break;
				case '/':
					int ans3 = val2 / val1;
					stackInsert(ans3);
					break;
				case '*':
					int ans4 = val2 * val1;
					stackInsert(ans4);
					break;
				case '^':
					int ans5 = (int) Math.pow(val2, val1);
					stackInsert(ans5);
					break;
				}
			}
		}
		int last = pop();
		return last;
	}
}
