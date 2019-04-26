package command.deletenode;

import command.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.GRAPH_NAME;
import static command.Mock.NODE_NAME;

public class DeleteNodeCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();
        mock.createGraph(GRAPH_NAME);
        mock.createNode(GRAPH_NAME, NODE_NAME);
    }

    @Test
    public void successfulCommandDeleteNodeTest() {
        mock.deleteNode(GRAPH_NAME, NODE_NAME);
        Assert.assertFalse(context.containsNode(GRAPH_NAME, NODE_NAME));
    }
}
