package command.deletegraph;

import command.ExecutionContext;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.GRAPH_NAME;
import static command.Constants.INEXISTENT_GRAPH;

public class DeleteGraphCommandTest {
    private ExecutionContext context;

    @Before
    public void setup() {
		context = new ExecutionContext();
		GraphStorage storage = context.getStorage();
		storage.add(GRAPH_NAME);
    }

    @Test
    public void successfulCommandDeleteGraphTest() {
		DeleteGraphCommand command = new DeleteGraphCommand(GRAPH_NAME);
		command.execute(context);
		GraphStorage storage = context.getStorage();
		boolean graphRemoved = (!storage.exists(GRAPH_NAME));
		Assert.assertTrue(graphRemoved);
    }

    @Test (expected = IllegalStateException.class)
	public void commandDeleteGraphOnInexistentGraphTest() {
		DeleteGraphCommand command = new DeleteGraphCommand(INEXISTENT_GRAPH);
		command.execute(context);
    }

}
