package command.deleteedge;

import command.ExecutionContext;
import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.*;

public class DeleteEdgeCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();

        mock.createGraph(GRAPH_NAME);
        mock.createNode(GRAPH_NAME, SOURCE_NODE);
        mock.createNode(GRAPH_NAME, DESTINATION_NODE);
        mock.createEdge(GRAPH_NAME, EDGE_NAME, SOURCE_NODE, DESTINATION_NODE);
    }

    @Test
    public void successfulCommandDeleteNodeTest() {
        Assert.assertTrue(context.containsEdge(GRAPH_NAME, EDGE_NAME));
        mock.deleteEdge(GRAPH_NAME, EDGE_NAME);
        Assert.assertFalse(context.containsEdge(GRAPH_NAME, EDGE_NAME));
    }
}
