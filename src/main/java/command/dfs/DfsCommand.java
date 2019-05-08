package command.dfs;

import command.Command;
import command.ExecutionContext;
import exception.GraphNotFoundException;
import exception.NodeNotFoundException;
import graph.Graph;
import graph.GraphStorage;

import java.util.Iterator;

public class DfsCommand implements Command {
    private String graph;
    private String sourceNode;

    DfsCommand(String graph, String sourceNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
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
        Iterator iterator = graph.dfs(sourceNode);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
