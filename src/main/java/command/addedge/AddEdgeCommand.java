package command.addedge;

import command.Command;
import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;

public class AddEdgeCommand implements Command {

    private String graphName;
    private String edgeName;
    private String sourceNode;
    private String destinationNode;

    AddEdgeCommand(String graphName, String edgeName, String sourceNode, String destinationNode) {
        this.graphName = graphName;
        this.edgeName = edgeName;
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
    }

    @Override
    public void execute(ExecutionContext context) {
        GraphStorage storage = context.getStorage();
        if (!storage.exists(graphName)) {
            throw new IllegalStateException("Graph " + graphName + " does not exists!");
        }
        Graph graph = storage.get(graphName);
        if (!graph.containsNode(sourceNode)) {
            throw new IllegalStateException("Node " + sourceNode + " does not exists!");
        }
        if (!graph.containsNode(destinationNode)) {
            throw new IllegalStateException("Node " + destinationNode + " does not exists!");
        }
        if (graph.containsEdge(edgeName)) {
            throw new IllegalStateException("Edge " + edgeName + " in graph " + graphName + " already exists!");
        }
        graph.addEdge(edgeName, sourceNode, destinationNode);
    }
}
