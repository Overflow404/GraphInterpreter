package command.addgraph;

import command.Command;
import command.ExecutionContext;
import graph.GraphStorage;

public class AddGraphCommand implements Command {

    private String graphName;

    AddGraphCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (storage.exists(graphName)) {
			throw new IllegalStateException("Graph " + graphName + " already exist!");
        }
		storage.add(graphName);
    }
}
