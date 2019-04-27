package command.quit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.EXTRA;

public class QuitCommandFactoryTest {
    private QuitCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new QuitCommandFactory();
        operation = "quit";
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
        List<String> tokens = getQuitTokens();
        factory.parse(tokens);
    }

    private List<String> getQuitTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        return tokens;
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getQuitTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getQuitTokensWithExtra() {
        List<String> tokens = getQuitTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
