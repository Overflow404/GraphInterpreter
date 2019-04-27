package command.display;

import command.ExecutionContext;
import graph.GraphStorage;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.GRAPH_NAME;
import static command.Constants.INEXISTENT_GRAPH;

public class DisplayCommandTest {

    private ExecutionContext context;
    @Before
    public void setup() {
		context = new ExecutionContext();
		GraphStorage storage = context.getStorage();
		storage.add(GRAPH_NAME);
    }

	@Test(expected = IllegalStateException.class)
    public void unsuccessfulCommandDisplayTest() {
		new DisplayCommand(INEXISTENT_GRAPH).execute(context);
    }
}
