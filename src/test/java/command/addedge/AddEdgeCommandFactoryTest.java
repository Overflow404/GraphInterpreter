package command.addedge;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static command.Mock.*;

public class AddEdgeCommandFactoryTest {

    private Mock mock;
    private AddEdgeCommandFactory factory;

    @Before
    public void setup() {
        factory = new AddEdgeCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("add_edge"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "add";
        String suffixCommand = "edge";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, suffixCommand);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens =
                mock.addEdgeTokens(GRAPH_NAME, EDGE_NAME, SOURCE_NODE, DESTINATION_NODE);
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens =
                mock.addEdgeTokens(GRAPH_NAME, EDGE_NAME, SOURCE_NODE, DESTINATION_NODE);
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
