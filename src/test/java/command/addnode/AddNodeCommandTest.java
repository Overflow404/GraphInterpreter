package command.addnode;

import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.*;

public class AddNodeCommandTest {
	private Graph graph;
    private ExecutionContext context;

    @Before
    public void setup() {
		context = new ExecutionContext();
		GraphStorage storage = context.getStorage();
		graph = storage.add(GRAPH_NAME);
    }

    @Test
    public void successfulCommandAddNodeTest() {
		AddNodeCommand command = new AddNodeCommand(GRAPH_NAME, NODE);
		command.execute(context);
		boolean graphHasNode = graph.containsNode(NODE);
		Assert.assertTrue(graphHasNode);
	}

	@Test(expected = IllegalStateException.class)
	public void commandAddNodeOnInexistentGraphTest() {
		AddNodeCommand command = new AddNodeCommand(INEXISTENT_GRAPH, NODE);
		command.execute(context);
	}

	@Test(expected = IllegalStateException.class)
	public void commandAddNodeWithNodeThatAlreadyExistTest() {
		AddNodeCommand command = new AddNodeCommand(GRAPH_NAME, NODE);
		command.execute(context);
		command.execute(context);
    }

}
