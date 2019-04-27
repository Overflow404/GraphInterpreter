package command.deleteedge;

import command.Command;
import command.ExecutionContext;
import exception.EdgeNotFoundException;
import exception.GraphNotFoundException;
import graph.Graph;
import graph.GraphStorage;

public class DeleteEdgeCommand implements Command {
	private String graph;
	private String edge;

	DeleteEdgeCommand(String graph, String edge) {
		this.graph = graph;
		this.edge = edge;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graph)) {
			throw new GraphNotFoundException("Graph " + graph + " does not exist!");
        }
		Graph graph = storage.get(this.graph);
		if (!graph.containsEdge(edge)) {
			throw new EdgeNotFoundException("Edge " + edge + " does not exist!");
		}
		graph.deleteEdge(edge);
    }
}
