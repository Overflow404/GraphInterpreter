package command.printneighbours;

import command.Command;
import command.ExecutionContext;
import exception.GraphNotFoundException;
import exception.NodeNotFoundException;
import graph.Graph;
import graph.GraphStorage;

import java.util.Iterator;

public class PrintNeighboursCommand implements Command {

	private String graph;
	private String node;

	public PrintNeighboursCommand(String graph, String node) {
		this.graph = graph;
		this.node = node;
	}

	@Override
	public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graph)) {
			throw new GraphNotFoundException("Graph " + graph + " does not exists!");
		}
		Graph graph = storage.get(this.graph);

		if (!graph.containsNode(node)) {
			throw new NodeNotFoundException("Node " + node + " does not exists!");
		}

		Iterator iterator = graph.neighbours(node);

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
