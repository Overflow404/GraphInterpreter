package command.display;

import command.Command;
import command.ExecutionContext;
import display.DisplayManager;
import graph.Graph;
import graph.GraphStorage;

public class DisplayCommand implements Command {

    private String graphName;

    DisplayCommand(String graphName) {
        this.graphName = graphName;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graphName)) {
			throw new IllegalStateException("Graph " + graphName + " does not exist!");
        }
		Graph graph = storage.get(graphName);
		DisplayManager displayManager = context.getDisplayManager();
		displayManager.display(graph);

    }
}
