package command.addnode;

import command.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.GRAPH_NAME;
import static command.Mock.NODE_NAME;

public class AddNodeCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();
        mock.createGraph(GRAPH_NAME);
    }

    @Test
    public void successfulCommandAddNodeTest() {
        mock.createNode(GRAPH_NAME, NODE_NAME);
        Assert.assertTrue(context.containsNode(GRAPH_NAME, NODE_NAME));
    }

}
