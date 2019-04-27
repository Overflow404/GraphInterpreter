package graph;

import org.graphstream.graph.Node;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import javax.swing.*;

public class Graph {
	private org.graphstream.graph.Graph graph;

	public Graph(org.graphstream.graph.Graph graph) {
		this.graph = graph;
	}

	public void addNode(String id) {
		Node node = graph.addNode(id);
		node.addAttribute("ui.label", id);
	}

	public void deleteNode(String id) {
		graph.removeNode(id);
	}

	public void addEdge(String id, String sourceNode, String destinationNode) {
		graph.addEdge(id, sourceNode, destinationNode);
	}

	public void deleteEdge(String id) {
		graph.removeEdge(id);
	}

	public boolean containsNode(String nodeId) {
		return graph.getNode(nodeId) != null;
	}

	public boolean containsEdge(String edgeId) {
		return graph.getEdge(edgeId) != null;
	}

	public JPanel getView() {
		Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
		viewer.enableAutoLayout();
		View view = viewer.addDefaultView(false);
		return view;
	}
}
