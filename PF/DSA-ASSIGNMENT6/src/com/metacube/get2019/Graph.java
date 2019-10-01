package com.metacube.get2019;

import java.util.List;

/**
 * It is an interface of graph.
 * @author Vinay
 *
 */
public interface Graph {

	boolean isConnected();
	Integer[] reachable(int node);
	List<Edge> minimumSpanningTree();
	int shortestPath(int vertex1, int vertex2);

}
