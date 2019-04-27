package command.addedge;

import exception.InvalidSyntaxException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.*;

public class AddEdgeCommandFactoryTest {

    private AddEdgeCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new AddEdgeCommandFactory();
        operation = "add_edge";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "add";
        String suffixCommand = "edge";
        List<String> unsupported = new ArrayList<>();
        unsupported.add(baseCommand + "-" + suffixCommand);
        unsupported.add((baseCommand + "_" + suffixCommand).toUpperCase());
        unsupported.add("");
        unsupported.add("    ");

        unsupported.forEach(command -> Assert.assertFalse(factory.isSupported(command)));
    }

    @Test
    public void successfulParseTest() {
        List<String> tokens = getAddEdgeTokens();

        factory.parse(tokens);
    }

	@Test(expected = InvalidSyntaxException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getAddEdgeTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getAddEdgeTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        tokens.add(EDGE);
        tokens.add(SOURCE_NODE);
        tokens.add(DESTINATION_NODE);
        return tokens;
    }

    private List<String> getAddEdgeTokensWithExtra() {
        List<String> tokens = getAddEdgeTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
