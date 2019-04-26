package command.deletegraph;

import command.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.GRAPH_NAME;
import static command.Mock.INEXISTENT_GRAPH_NAME;

public class DeleteGraphCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();
        mock.createGraph(GRAPH_NAME);
    }

    @Test
    public void successfulCommandDeleteGraphTest() {
        mock.deleteGraph(GRAPH_NAME);
        Assert.assertFalse(context.containsGraph(GRAPH_NAME));
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulCommandDeleteGraphTest() {
        mock.deleteGraph(INEXISTENT_GRAPH_NAME);
    }

    @Test (expected = IllegalStateException.class)
    public void doubleCommandDeleteGraphTest() {
        mock.deleteGraph(GRAPH_NAME);
        mock.deleteGraph(GRAPH_NAME);
    }
}
