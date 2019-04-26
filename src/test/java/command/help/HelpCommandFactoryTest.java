package command.help;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HelpCommandFactoryTest {

    private HelpCommandFactory factory;
    private Mock mock;

    @Before
    public void setup() {
        factory = new HelpCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("help"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "help";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, null);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.helpTokens();
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.helpTokens();
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
