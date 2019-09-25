package com.metacube.get2019;

import java.util.LinkedList;
import java.util.List;

/**
 * It is a class which is representing a vertex of graph.
 * @author Vinay
 *
 */
public class Vertex {
	
	private List<Neighbour> neighbours = new LinkedList<Neighbour>();

	Vertex(){}

	/**
	 * It is a method to add neighbour of calling vertex.
	 * @param vertex neighbour vertex.
	 * @param edgeWeight edge weight of neighbour vertex.
	 */
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour neighbour = new Neighbour(vertex, edgeWeight);
		this.neighbours.add(neighbour);
	}

	/**
	 * It is a method to return list of neighbour
	 * @return list of neighbour.
	 */
	public List<Neighbour> getNeighbourList() {
		return this.neighbours;
	}
}
