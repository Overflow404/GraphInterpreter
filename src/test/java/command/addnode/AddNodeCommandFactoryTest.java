package command.addnode;

import exception.InvalidSyntaxException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.*;

public class AddNodeCommandFactoryTest {

    private AddNodeCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new AddNodeCommandFactory();
        operation = "add_node";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "add";
        String suffixCommand = "node";
        List<String> unsupported = new ArrayList<>();
        unsupported.add(baseCommand + "-" + suffixCommand);
        unsupported.add((baseCommand + "_" + suffixCommand).toUpperCase());
        unsupported.add("");
        unsupported.add("    ");

        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = getAddNodeTokens();
        factory.parse(tokens);
    }

	@Test(expected = InvalidSyntaxException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getAddNodeTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getAddNodeTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        tokens.add(NODE);
        return tokens;
    }

    private List<String> getAddNodeTokensWithExtra() {
        List<String> tokens = getAddNodeTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
