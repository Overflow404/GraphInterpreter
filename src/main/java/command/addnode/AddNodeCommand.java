package command.addnode;

import command.Command;
import command.ExecutionContext;
import exception.GraphNotFoundException;
import exception.NodeAlreadyExistException;
import graph.Graph;
import graph.GraphStorage;

public class AddNodeCommand implements Command {
    private String graph;
    private String node;

    AddNodeCommand(String graph, String node) {
        this.graph = graph;
        this.node = node;
    }

    @Override
    public void execute(ExecutionContext context) {
        GraphStorage storage = context.getStorage();
        if (!storage.exists(graph)) {
            throw new GraphNotFoundException("Graph " + graph + " does not exist!");
        }
        Graph graph = storage.get(this.graph);
        if (graph.containsNode(node)) {
            throw new NodeAlreadyExistException("Node " + node + " already exists!");
        }
        graph.addNode(node);
    }
}
