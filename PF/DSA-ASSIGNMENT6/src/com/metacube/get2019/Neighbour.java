package com.metacube.get2019;

/**
 * It is a class neighbour to represent neighbour vertex.
 * @author Vinay
 *
 */
public class Neighbour {
	private int neighbourVertex;
	private int edgeWeight;

	/**
	 * It is a constructor to initialize neighbour class attributes.
	 * @param vertex neighbour vertex.
	 * @param edgeWeight edge weight of neighbour vertex.
	 */
	Neighbour(int vertex, int edgeWeight) {
		this.neighbourVertex = vertex;
		this.edgeWeight = edgeWeight;
	}

	/**
	 * It is a getter method to get neighbour vertex.
	 * @return neighbour vertex.
	 */
	public int getNeighbourVertex() {
		return this.neighbourVertex;
	}

	/**
	 * It is a getter method to return edge weight of neighbour vertex. 
	 * @return edge weight
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}
