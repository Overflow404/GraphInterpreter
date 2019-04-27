package command.display;

import exception.InvalidSyntaxException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.EXTRA;
import static command.Constants.GRAPH_NAME;

public class DisplayCommandFactoryTest {

    private DisplayCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new DisplayCommandFactory();
        operation = "display";
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
        List<String> tokens = getDisplayTokens();
        factory.parse(tokens);
    }

	@Test(expected = InvalidSyntaxException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getDisplayTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getDisplayTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        return tokens;
    }

    private List<String> getDisplayTokensWithExtra() {
        List<String> tokens = getDisplayTokens();
        tokens.add(EXTRA);
        return tokens;
    }

}
