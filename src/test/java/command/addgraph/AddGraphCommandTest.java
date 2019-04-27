package command.addgraph;

import command.Constants;
import command.ExecutionContext;
import exception.GraphAlreadyExistException;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.GRAPH_NAME;

public class AddGraphCommandTest {

    private ExecutionContext context;

    @Before
    public void setup() {
		context = new ExecutionContext();
    }

    @Test
    public void successfulCommandAddGraphTest() {
		AddGraphCommand command = new AddGraphCommand(Constants.GRAPH_NAME);
		command.execute(context);
		GraphStorage storage = context.getStorage();
		boolean graphWasAdded = storage.exists(GRAPH_NAME);
		Assert.assertTrue(graphWasAdded);
    }

	@Test(expected = GraphAlreadyExistException.class)
	public void addDuplicateGraphTest() {
		AddGraphCommand command = new AddGraphCommand(Constants.GRAPH_NAME);
		command.execute(context);
		command.execute(context);
    }
}
