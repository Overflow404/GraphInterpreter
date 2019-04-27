package command.help;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.EXTRA;

public class HelpCommandFactoryTest {

    private HelpCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new HelpCommandFactory();
        operation = "help";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        List<String> unsupported = new ArrayList<>();
        unsupported.add(operation + "-");
        unsupported.add(operation.toUpperCase());
        unsupported.add("");
        unsupported.add("    ");

        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = getHelpTokens();
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getHelpTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getHelpTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        return tokens;
    }

    private List<String> getHelpTokensWithExtra() {
        List<String> tokens = getHelpTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
