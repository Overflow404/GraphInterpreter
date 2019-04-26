package command.display;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static command.Mock.GRAPH_NAME;

public class DisplayCommandFactoryTest {

    private DisplayCommandFactory factory;
    private Mock mock;

    @Before
    public void setup() {
        factory = new DisplayCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("display"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "display";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, null);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.displayTokens(GRAPH_NAME);
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.displayTokens(GRAPH_NAME);
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
