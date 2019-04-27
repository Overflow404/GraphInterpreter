package command.deleteedge;

import command.Command;
import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;

public class DeleteEdgeCommand implements Command {

    private String graphName;
    private String edgeName;

    DeleteEdgeCommand(String graphName, String edgeName) {
        this.graphName = graphName;
        this.edgeName = edgeName;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graphName)) {
			throw new IllegalStateException("Graph " + graphName + " does not exist!");
        }
		Graph graph = storage.get(graphName);
		if (!graph.containsEdge(edgeName)) {
			throw new IllegalStateException("Edge " + edgeName + " does not exist!");
		}
		graph.deleteEdge(edgeName);
    }
}
