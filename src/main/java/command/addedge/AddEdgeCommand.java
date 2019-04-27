package command.addedge;

import command.Command;
import command.ExecutionContext;
import exception.EdgeAlreadyExistException;
import exception.GraphNotFoundException;
import exception.NodeNotFoundException;
import graph.Graph;
import graph.GraphStorage;

public class AddEdgeCommand implements Command {
	private String graph;
	private String edge;
    private String sourceNode;
    private String destinationNode;

	AddEdgeCommand(String graph, String edge, String sourceNode, String destinationNode) {
		this.graph = graph;
		this.edge = edge;
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
    }

    @Override
    public void execute(ExecutionContext context) {
        GraphStorage storage = context.getStorage();
		if (!storage.exists(graph)) {
			throw new GraphNotFoundException("Graph " + graph + " does not exists!");
        }
		Graph graph = storage.get(this.graph);

        if (!graph.containsNode(sourceNode)) {
			throw new NodeNotFoundException("Node " + sourceNode + " does not exists!");
        }

        if (!graph.containsNode(destinationNode)) {
			throw new NodeNotFoundException("Node " + destinationNode + " does not exists!");
        }
		if (graph.containsEdge(edge)) {
			throw new EdgeAlreadyExistException("Edge " + edge + " in graph " + this.graph + " already exists!");
        }
		graph.addEdge(edge, sourceNode, destinationNode);
    }
}
