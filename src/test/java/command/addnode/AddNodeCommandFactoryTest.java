package command.addnode;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static command.Mock.GRAPH_NAME;
import static command.Mock.NODE_NAME;

public class AddNodeCommandFactoryTest {

    private Mock mock;
    private AddNodeCommandFactory factory;

    @Before
    public void setup() {
        factory = new AddNodeCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("add_node"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "add";
        String suffixCommand = "node";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, suffixCommand);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.addNodeTokens(GRAPH_NAME, NODE_NAME);
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.addNodeTokens(GRAPH_NAME, NODE_NAME);
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
