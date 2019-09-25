package com.metacube.get2019;

import java.util.Comparator;

/**
 * It is a class edge used to represent an edge.
 * @author Vinay
 *
 */
public class Edge implements Comparator<Edge>{
	
	private int vertex1;
	private int vertex2;
	private int weight;
	
	/**
	 * It is a constructor used to initialize edge attributes.
	 * @param vertex1 representing 1st vertex of edge. 
	 * @param vertex2 representing 2nd vertex of edge.
	 * @param weight weight of edge.
	 */
	public Edge(int vertex1, int vertex2,int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	/**
	 * It is a getter method to return vertex1
	 * @return vertex1
	 */
	public int getVertex1() {
		return vertex1;
	}

	/**
	 * It is a setter method to set value of vertex1
	 * @param vertex1  representing 1st vertex of edge.
	 */
	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	/**
	 * It is a getter method to return vertex2
	 * @return vertex2
	 */
	public int getVertex2() {
		return vertex2;
	}

	/**
	 * It is a setter method to set value of vertex2
	 * @param vertex2  representing 2nd vertex of edge.
	 */
	public void setVertex2(int vertex2) {
		this.vertex2 = vertex2;
	}

	/**
	 * It is a getter method to return weight
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * It is a setter method to set value of weight
	 * @param weight representing weight of edge.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	
	/**
	 * Comparator for sorting edge collection based on edge's weight
	 */
	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
			return e1.getWeight() - e2.getWeight();
		}
	};

	@Override
	public int compare(Edge o1, Edge o2) {
		return 0;
	}

}
