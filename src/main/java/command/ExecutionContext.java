package command;

import display.DisplayManager;
import graph.GraphStorage;

public class ExecutionContext {
	private GraphStorage graphs;
	private DisplayManager displayManager;

	public ExecutionContext() {
		graphs = new GraphStorage();
		displayManager = new DisplayManager();
	}

	public GraphStorage getStorage() {
		return graphs;
	}

	public DisplayManager getDisplayManager() {
		return displayManager;
	}

}
