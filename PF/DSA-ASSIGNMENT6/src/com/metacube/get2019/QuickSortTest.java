package com.metacube.get2019;

import static org.junit.Assert.*;

import org.junit.Test;


public class QuickSortTest {
	
	@Test
	public void QuickSorttest() {
		
		LinkedList linkedlist=new LinkedList();
		
		Employee employee1=new Employee("Khushi",22,15000);
		Employee employee2=new Employee("Ayushi",22,41000);
		Employee employee3=new Employee("Amit",22,25000);
		Employee employee4=new Employee("Anu",21,25000);
		
		linkedlist.insert(employee1);
		linkedlist.insert(employee2);
		linkedlist.insert(employee3);
		linkedlist.insert(employee4);
		
		linkedlist.quickSort(linkedlist.head,linkedlist.lastNode);
		
		LinkedList expectedLinkedlist=new LinkedList();
		
		expectedLinkedlist.insert(employee2);
		expectedLinkedlist.insert(employee4);
		expectedLinkedlist.insert(employee3);
		expectedLinkedlist.insert(employee1);
		
		Node currentNodeExpected=expectedLinkedlist.head;
		Node currentNodeActual=linkedlist.head;
		
		while(currentNodeExpected!=null)
		{
			assertEquals(currentNodeExpected.data.getName(),currentNodeActual.data.getName());
			currentNodeExpected=currentNodeExpected.next;
			currentNodeActual=currentNodeActual.next;
		}
	}
	
	@Test(expected=AssertionError.class)
	public void testQuickSortForEmptyList() {
		LinkedList linkedlist=new LinkedList();
		linkedlist.quickSort(linkedlist.head,linkedlist.lastNode);
	}

}
