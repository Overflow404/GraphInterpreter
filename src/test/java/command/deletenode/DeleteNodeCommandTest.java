package command.deletenode;

import command.ExecutionContext;
import exception.GraphNotFoundException;
import exception.NodeNotFoundException;
import graph.Graph;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.*;

public class DeleteNodeCommandTest {

    private ExecutionContext context;
	private Graph graph;

    @Before
    public void setup() {
		context = new ExecutionContext();
		GraphStorage storage = context.getStorage();
		graph = storage.add(GRAPH_NAME);
		graph.addNode(NODE);
    }

    @Test
    public void successfulCommandDeleteNodeTest() {
		DeleteNodeCommand command = new DeleteNodeCommand(GRAPH_NAME, NODE);
		command.execute(context);
		boolean nodeRemoved = (!graph.containsNode(NODE));
		Assert.assertTrue(nodeRemoved);
	}

	@Test(expected = GraphNotFoundException.class)
	public void commandDeleteNodeOnInexistentGraphTest() {
		DeleteNodeCommand command = new DeleteNodeCommand(INEXISTENT_GRAPH, NODE);
		command.execute(context);
	}

	@Test(expected = NodeNotFoundException.class)
	public void commandDeleteNodeOnInexistentNodeTest() {
		DeleteNodeCommand command = new DeleteNodeCommand(GRAPH_NAME, INEXISTENT_NODE);
		command.execute(context);
    }
}
