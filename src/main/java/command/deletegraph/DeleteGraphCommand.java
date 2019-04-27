package command.deletegraph;

import command.Command;
import command.ExecutionContext;
import graph.GraphStorage;

public class DeleteGraphCommand implements Command {

    private String graphName;

    DeleteGraphCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graphName)) {
			throw new IllegalStateException("Graph " + graphName + " does not exist!");
        }
		storage.remove(graphName);
    }
}
