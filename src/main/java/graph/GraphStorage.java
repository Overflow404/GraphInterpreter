package graph;

import org.graphstream.graph.implementations.SingleGraph;

import java.util.HashMap;
import java.util.Map;

public class GraphStorage {
	private Map<String, Graph> graphs;

	public GraphStorage() {
		this.graphs = new HashMap<>();
	}

	public Graph add(String id) {
		SingleGraph g = new SingleGraph(id);
		Graph graph = new Graph(g);
		graphs.put(id, graph);
		return graph;
	}

	public void remove(String id) {
		this.graphs.remove(id);
	}

	public boolean exists(String id) {
		return this.graphs.containsKey(id);
	}

	public Graph get(String id) {
		return graphs.get(id);
	}
}
