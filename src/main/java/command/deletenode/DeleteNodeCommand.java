package command.deletenode;

import command.Command;
import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;

public class DeleteNodeCommand implements Command {
	private String graphName;
	private String nodeName;

	DeleteNodeCommand(String graphName, String nodeName) {
		this.graphName = graphName;
		this.nodeName = nodeName;
	}

	@Override
	public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graphName)) {
			throw new IllegalStateException("Graph " + graphName + " does not exist!");
		}
		Graph graph = storage.get(graphName);
		if (!graph.containsNode(nodeName)) {
			throw new IllegalStateException("Node " + nodeName + " does not exist!");
		}
		graph.deleteNode(nodeName);
	}
}
