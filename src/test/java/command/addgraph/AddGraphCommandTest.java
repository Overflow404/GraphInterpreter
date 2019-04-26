package command.addgraph;

import command.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.GRAPH_NAME;


public class AddGraphCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();
    }

    @Test
    public void successfulCommandAddGraphTest() {
        mock.createGraph(GRAPH_NAME);
        Assert.assertTrue(context.containsGraph(GRAPH_NAME));
    }

    @Test (expected = IllegalStateException.class)
    public void duplicateCommandAddGraphTest() {
        mock.createGraph(GRAPH_NAME);
        mock.createGraph(GRAPH_NAME);
    }
}
