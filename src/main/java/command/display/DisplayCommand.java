package command.display;

import command.Command;
import command.ExecutionContext;
import display.DisplayManager;
import exception.GraphNotFoundException;
import graph.Graph;
import graph.GraphStorage;

public class DisplayCommand implements Command {
	private String graph;

	DisplayCommand(String graph) {
		this.graph = graph;
    }

    @Override
    public void execute(ExecutionContext context) {
		GraphStorage storage = context.getStorage();
		if (!storage.exists(graph)) {
			throw new GraphNotFoundException("Graph " + graph + " does not exist!");
        }
		Graph graph = storage.get(this.graph);
		DisplayManager displayManager = context.getDisplayManager();
		displayManager.display(graph);
    }
}
