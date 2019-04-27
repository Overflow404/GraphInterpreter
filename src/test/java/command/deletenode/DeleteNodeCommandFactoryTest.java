package command.deletenode;

import exception.InvalidSyntaxException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.*;

public class DeleteNodeCommandFactoryTest {

    private DeleteNodeCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new DeleteNodeCommandFactory();
        operation = "delete_node";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "delete";
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
        List<String> tokens = getDeleteNodeTokens();
        factory.parse(tokens);
    }

	@Test(expected = InvalidSyntaxException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getDeleteNodeTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getDeleteNodeTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        tokens.add(NODE);
        return tokens;
    }

    private List<String> getDeleteNodeTokensWithExtra() {
        List<String> tokens = getDeleteNodeTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
