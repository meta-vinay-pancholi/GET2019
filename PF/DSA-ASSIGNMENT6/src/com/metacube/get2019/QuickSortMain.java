package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Vinay
 *
 */
public class QuickSortMain {

	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;	
		LinkedList quickSortObj = new LinkedList();
		try {
			do {
				System.out.println("---------------------------");
				System.out.println("1. Insert a employee into linked list.");
				System.out.println("2. Apply quickSort on linked list.");
				System.out.println("3. Show linked list.");
				System.out.println("4. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("---------------------------");
				sc.nextLine();
				switch(choice) {
				case 1 : 
					System.out.print("Enter the name of employee : ");
					String empName = sc.nextLine();
					System.out.print("Enter the age of employee : ");
					int age = sc.nextInt();
					System.out.print("Enter the salary of employee : ");
					int salary = sc.nextInt();
					System.out.println("-------------------------------");
					quickSortObj.insert(new Employee(empName, age, salary));
					break;
				case 2 :
					Node start = quickSortObj.getHead();
					Node end = quickSortObj.getLastNode(); 
					quickSortObj.quickSort(start, end);
					break;
				case 3:
					Node head = quickSortObj.getHead();
					System.out.println("---------------------------------------");
					System.out.print("LINKED LIST : \n");
					quickSortObj.show(head);
					System.out.println("\n---------------------------------------");
					break;
				case 4 :
					isExit = false;
					System.out.println("Successfully exit!!");
					System.out.println("---------------------------");
					break;
				default :
					System.out.println("Invalid choice!!");
					System.out.println("---------------------------");
				}
				
			}while(!isExit);
			
		} catch(InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}finally {
			sc.close();
		}
	}
}
