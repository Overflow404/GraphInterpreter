package command.deleteedge;

import command.ExecutionContext;
import graph.Graph;
import graph.GraphStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static command.Constants.*;

public class DeleteEdgeCommandTest {
    private Graph graph;
    private ExecutionContext context;

    @Before
    public void setup() {
        context = new ExecutionContext();
        GraphStorage storage = context.getStorage();
        graph = storage.add(GRAPH_NAME);
        graph.addNode(SOURCE_NODE);
        graph.addNode(DESTINATION_NODE);
        graph.addEdge(EDGE, SOURCE_NODE, DESTINATION_NODE);

    }

    @Test
    public void successfulCommandDeleteNodeTest() {
        DeleteEdgeCommand command = new DeleteEdgeCommand(GRAPH_NAME, EDGE);
        command.execute(context);
        boolean graphHasNotEdge = !graph.containsEdge(EDGE);
        Assert.assertTrue(graphHasNotEdge);
    }

    @Test(expected = IllegalStateException.class)
    public void commandDeleteEdgeOnInexistentGraphTest() {
        DeleteEdgeCommand command = new DeleteEdgeCommand(INEXISTENT_GRAPH, EDGE);
        command.execute(context);
    }

    @Test(expected = IllegalStateException.class)
    public void commandDeleteEdgeWithEdgeThatNotExistTest() {
        DeleteEdgeCommand command = new DeleteEdgeCommand(GRAPH_NAME, EDGE);
        command.execute(context);
        command.execute(context);
    }
}
