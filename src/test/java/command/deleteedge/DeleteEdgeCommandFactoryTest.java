package command.deleteedge;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static command.Mock.*;

public class DeleteEdgeCommandFactoryTest {

    private Mock mock;
    private DeleteEdgeCommandFactory factory;

    @Before
    public void setup() {
        factory = new DeleteEdgeCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("delete_edge"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "delete";
        String suffixCommand = "edge";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, suffixCommand);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.deleteEdgeTokens(GRAPH_NAME, EDGE_NAME);
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.deleteEdgeTokens(GRAPH_NAME, EDGE_NAME);
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
