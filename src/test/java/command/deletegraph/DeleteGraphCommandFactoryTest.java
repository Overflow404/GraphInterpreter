package command.deletegraph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.EXTRA;
import static command.Constants.GRAPH_NAME;

public class DeleteGraphCommandFactoryTest {

    private DeleteGraphCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new DeleteGraphCommandFactory();
        operation = "delete_graph";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "delete";
        String suffixCommand = "graph";
        List<String> unsupported = new ArrayList<>();
        unsupported.add(baseCommand + "-" + suffixCommand);
        unsupported.add((baseCommand + "_" + suffixCommand).toUpperCase());
        unsupported.add("");
        unsupported.add("    ");

        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = getDeleteGraphTokens();
        factory.parse(tokens);
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getDeleteGraphTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getDeleteGraphTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        return tokens;
    }

    private List<String> getDeleteGraphTokensWithExtra() {
        List<String> tokens = getDeleteGraphTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
