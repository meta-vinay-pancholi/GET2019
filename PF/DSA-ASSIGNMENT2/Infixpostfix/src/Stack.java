import java.util.NoSuchElementException;

//import PostfixEvaluation.Node;
/**
 * This program is simply converting infix string into postfix string
 * @author Vinay
 *
 */
public class Stack {
	Node top;

	class Node {
		char data;
		Node next;

		Node() {
			this.next = null;
		}
	}

	Stack() {
		this.top = null;
	}

	/**
	 * @param data
	 * Function to insert value into stack
	 */
	public void stackInsert(char data) {
		Node nptr = new Node();//creating new node
		nptr.data = data;//adding data into stack
		if (top == null)//if top is null
			top = nptr;//assign top = new node
		else {
			Node temp;
			temp = top;
			top = nptr;
			nptr.next = temp;
		}
	}

	/**
	 * @return last element
	 * function to retrieve last element from stack and to move top pointer
	 */
	public char pop() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node ptr = top;
		top = ptr.next;
		return ptr.data;
	}

	/**
	 * function returning top element
	 * @return top data
	 */
	public char peek() {
		if (top == null) {
			return ' ';
		} else
			return top.data;
	}

	/**
	 * function to check if Stack is empty or filled
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * @param i
	 * @return priority
	 * Function to check precedence of operator
	 */
	int Prec(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	/**
	 * to display stack element
	 */
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
	 * This function converting infix expression into post fix expression
	 * @param expr
	 * @return result
	 */
	public String infixToPostfix(String expr) {
		String result = new String("");
		Stack s = new Stack();
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				result += c;

			} else if (c == '(') {
				s.stackInsert(c);

			} else if (c == ')') {

				while (!s.isEmpty() && s.peek() != '(') {
					result = result + s.pop();
				}
				if (!s.isEmpty() && s.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					s.pop();
			} else {
				while (!s.isEmpty() && Prec(c) <= Prec(s.peek())) {
					if (s.peek() == '(')
						return "Invalid Expression";
					result += s.pop();
				}
				s.stackInsert(c);
			}
		}
		while (!s.isEmpty()) {
			if (s.peek() == '(')
				return "Invalid Expression";
			result += s.pop();
		}
		return result;
	}

}
