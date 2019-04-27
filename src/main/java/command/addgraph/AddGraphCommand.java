package command.addgraph;

import command.Command;
import command.ExecutionContext;
import exception.GraphAlreadyExistException;
import graph.GraphStorage;

public class AddGraphCommand implements Command {
	private String graph;

	AddGraphCommand(String graph) {
		this.graph = graph;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (storage.exists(graph)) {
			throw new GraphAlreadyExistException("Graph " + graph + " already exist!");
        }
		storage.add(graph);
    }
}
