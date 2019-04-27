package command.addedge;

import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.*;

public class AddEdgeCommandTest {
	private Graph graph;
    private ExecutionContext context;
	private GraphStorage storage;

    @Before
    public void setup() {
		context = new ExecutionContext();
		storage = context.getStorage();
		graph = storage.add(GRAPH_NAME);
		graph.addNode(SOURCE_NODE);
		graph.addNode(DESTINATION_NODE);
    }

    @Test
    public void successfulCommandAddEdgeTest() {
		AddEdgeCommand command = new AddEdgeCommand(GRAPH_NAME, EDGE, SOURCE_NODE, DESTINATION_NODE);
		command.execute(context);
		boolean graphHasEdge = graph.containsEdge(EDGE);
		Assert.assertTrue(graphHasEdge);
	}

	@Test(expected = IllegalStateException.class)
	public void commandAddEdgeOnInexistentGraphTest() {
		AddEdgeCommand command = new AddEdgeCommand(
				INEXISTENT_GRAPH, EDGE, SOURCE_NODE, DESTINATION_NODE);
		command.execute(context);
	}

	@Test(expected = IllegalStateException.class)
	public void commandAddEdgeWithInexistentSourceNodeTest() {
		AddEdgeCommand command = new AddEdgeCommand(
				GRAPH_NAME, EDGE, INEXISTENT_SOURCE_NODE, DESTINATION_NODE);
		command.execute(context);
	}

	@Test(expected = IllegalStateException.class)
	public void commandAddEdgeWithInexistentDestinationNodeTest() {
		AddEdgeCommand command = new AddEdgeCommand(
				GRAPH_NAME, EDGE, SOURCE_NODE, INEXISTENT_DESTINATION_NODE);
		command.execute(context);
    }

	@Test(expected = IllegalStateException.class)
	public void commandAddEdgeWithEdgeThatAlreadyExistTest() {
		AddEdgeCommand command = new AddEdgeCommand(
				GRAPH_NAME, EDGE, SOURCE_NODE, DESTINATION_NODE);
		command.execute(context);
		command.execute(context);
	}


}
