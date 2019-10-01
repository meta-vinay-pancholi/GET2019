package com.metacube.get2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GraphMain {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		GraphImp graphObj = null;
		int noOfVertices;
		int noOfEdges;
		
		try {
			do {
				System.out.println("-----------------------------------");
				System.out.println("1. Create graph");
				System.out.println("2. Check whether graph is connected or not.");
				System.out.println("3. Find reachable nodes from a vertex");
				System.out.println("4. Find minimum spanning tree of graph.");
				System.out.println("5. Find length of shortest path of graph");
				System.out.println("6. Exit");
				System.out.println("-----------------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("-----------------------------------");
				switch(choice) {
				case 1 :
					System.out.print("Enter number of vertices in your graph : ");
					noOfVertices = sc.nextInt();
					System.out.println("-----------------------------------");
					graphObj = new GraphImp(noOfVertices);
					System.out.print("Enter number of edges in your graph : ");
					noOfEdges = sc.nextInt();
					System.out.println("-----------------------------------");
					for(int i = 0; i < noOfEdges; i++) {
						System.out.print("Enter source vertex : ");
						int source = sc.nextInt();
						System.out.print("Enter destination vertex : ");
						int destination = sc.nextInt();
						System.out.print("Enter weight of edge : ");
						int weight = sc.nextInt();
						graphObj.addEdge(source, destination, weight);
						System.out.println("-----------------------------------");
					}
						break;
				case 2:
					if (graphObj == null) {
						System.out.println("Please first create a graph!!!");
						break;
					}
					boolean isConnected = graphObj.isConnected();
					System.out.println("Graph is connected : "+ isConnected);
					System.out.println("-----------------------------------");
					break;
				case 3:
					if (graphObj == null) {
						System.out.println("Please first create a graph!!!");
						break;
					}
					Integer[] reachableNodes = new Integer[graphObj.getNumberOfVertices()];
					System.out.print("Enter the vertex whose reachable nodes you want to find  : ");
					int vertex = sc.nextInt();
					System.out.println("-----------------------------------");
					reachableNodes = graphObj.reachable(vertex);
					System.out.print("Reachable nodes from "+ vertex + " : ");
					for (int i = 0; i < reachableNodes.length; i++) {
						System.out.print(reachableNodes[i] + " ");
					}
					System.out.println("\n-----------------------------------");
					break;
				case 4 :
					if (graphObj == null) {
						System.out.println("Please first create a graph!!!");
						break;
					}
					List<Edge> edgeList = new ArrayList<Edge>();
					edgeList = graphObj.minimumSpanningTree();
					System.out.println("Minimum spanning tree : ");
					for (Edge e : edgeList) {
						System.out.print(e.getWeight() + "--->");
					}
					System.out.println("\n-----------------------------------");
					break;
				case 5 :
					if (graphObj == null) {
						System.out.println("Please first create a graph!!!");
						break;
					}
					System.out.print("Enter the source vertex : ");
					int source1 = sc.nextInt();
					System.out.print("Enter the destination vertex  : ");
					int dest = sc.nextInt();
					System.out.println("-----------------------------------");
					int distance = graphObj.shortestPath(source1, dest);
					System.out.println("Shortest path distance length between " + source1 + " and  " + dest + " : " + distance);
					System.out.println("-----------------------------------");
					break;
				case 6 :
					isExit = true;
					System.out.println("Successfully exit!!");
					System.out.println("-----------------------------------");
					break;
				default :
					System.out.println("Invalid choice");
					System.out.println("-----------------------------------");
				}
			} while(!isExit);
		} catch(InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
