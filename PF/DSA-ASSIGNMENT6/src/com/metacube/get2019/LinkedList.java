package com.metacube.get2019;

/**
 * This is a class to implement quick sort on linked list
 * @author Vinay
 *
 */
public class LinkedList {
	Node head;
	Node lastNode;
	
	/**
	 * It is a default constructor for linked list
	 */
	LinkedList()
	{}
	
	/**
	 * This is a method to insert a new data into the linked list
	 * @param data is the value of the new node to be added
	 */
	public void insert(Employee data) {
		Node newNode = new Node(data); 
		if (head == null) {
			head = newNode;
			lastNode = newNode;
		}
		lastNode.next = newNode;
		lastNode = newNode;
	}
	
	/**
	 * This method returns the correct position of the pivot element
	 * @param start is the first node of the list
	 * @param last is the last node of the list
	 * @return returns the pivot node that partitions the list
	 */
	public Node partition(Node start, Node last) {
		Node currentNode;
		Employee temp;
		if(this.head == start) {
			currentNode = null;
		} else {
			currentNode = this.head;
			while(currentNode.next != start){
				currentNode = currentNode.next;
			}
		}
		
		Node i = currentNode;
		Employee pivot = last.data;
		Node j = start;
		while (j != last) {
			if(j.data.getSalary() > pivot.getSalary()) {
				if (i == null) {
					i = start;
				} else {
					i = i.next;
				}
				temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
			j = j.next;
		}
		if (i == null) {
			i=start;
		} else {
			i = i.next;
		}
		temp = i.data;
		i.data = last.data;
		last.data = temp;
		return i;
	}
	
	/**
	 * It is a method to return head.
	 * @return head of linked list.
	 */
	public Node getHead() {
		return this.head;
	}
	
	/**
	 * It is a method to return lastNode.
	 * @return lastNode of linked list.
	 */
	public Node getLastNode() {
		return this.lastNode;
	}
	
	/**
	 * It is a method used to show elements of a linked list.
	 * @param Head of list
	 */
	public void show(Node temp) {
		if (temp != null){
			System.out.println(temp.data.getName() + "\t\t" + temp.data.getAge() + "\t\t" + temp.data.getSalary());
			temp = temp.next;
			show(temp);
		}
	}
	
	
	/**
	 * This is the recursive method to perform quick sort
	 * @param start start is the first element of the list
	 * @param last last is the last element of the list
	 */
	public void recursiveQuickSort(Node start, Node last) {
		if(start != null && last != null && last == start.next) {
			if(compare(start.data, last.data)) {
				Employee temp = start.data;
				start.data = last.data;
				last.data = temp;
			}
		} else if(start != null && last != start ){ 
			Node partition = partition(start, last); 
			Node currentNode = start;
			while (currentNode.next != partition) {
				currentNode = currentNode.next;
			}
			recursiveQuickSort(start, currentNode); 
			recursiveQuickSort(partition.next, last); 
		} 
	}
	
	/**
	 * This method is used to call the recursive quicksort method
	 * @param start is the first element of the list
	 * @param last is the last element of the list
	 */
	public void quickSort(Node start, Node last) {
		if(start == null) {
			throw new AssertionError("Empty linked list");
		} else {
			recursiveQuickSort(start, last);
		}
	}
	
	/**
	 * It is a method to compare 2 employees salary and age,
	 * @param e1 Employee object
	 * @param e2 Employee Object
	 * @return boolean value
	 */
	private boolean compare (Employee e1, Employee e2) {
		boolean result =  (e1.getSalary() < e2.getSalary() ||
				(e1.getSalary() == e2.getSalary() && e1.getAge() < e2.getAge()));
		return result;
	}
}
