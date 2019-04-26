package command.addedge;

import command.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.*;

public class AddEdgeCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();

        mock.createGraph(GRAPH_NAME);
        mock.createNode(GRAPH_NAME, SOURCE_NODE);
        mock.createNode(GRAPH_NAME, DESTINATION_NODE);
    }


    @Test
    public void successfulCommandAddEdgeTest() {
        mock.createEdge(GRAPH_NAME, EDGE_NAME, SOURCE_NODE, DESTINATION_NODE);
        boolean graphHaveEdge = context.containsEdge(GRAPH_NAME, EDGE_NAME);
        Assert.assertTrue(graphHaveEdge);
    }
}
