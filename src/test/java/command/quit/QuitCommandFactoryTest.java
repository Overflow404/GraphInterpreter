package command.quit;

import command.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class QuitCommandFactoryTest {
    private QuitCommandFactory factory;
    private Mock mock;

    @Before
    public void setup() {
        factory = new QuitCommandFactory();
        mock = new Mock();
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported("quit"));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "quit";

        List<String> unsupported = mock.getUnsupportedCommands(baseCommand, null);
        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = mock.quitTokens();
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = mock.quitTokens();
        mock.addExtra(tokens);
        factory.parse(tokens);
    }
}
