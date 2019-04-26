package command.deletegraph;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static command.Mock.GRAPH_NAME;

public class DeleteGraphCommandFactoryTest {

    private Mock mock;
    private DeleteGraphCommandFactory factory;

    @Before
    public void setup() {
        factory = new DeleteGraphCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("delete_graph"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "delete";
        String suffixCommand = "graph";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, suffixCommand);

        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.deleteGraphTokens(GRAPH_NAME);
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.deleteGraphTokens(GRAPH_NAME);
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
