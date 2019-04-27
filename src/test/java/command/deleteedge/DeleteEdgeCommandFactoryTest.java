package command.deleteedge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.*;

public class DeleteEdgeCommandFactoryTest {

    private DeleteEdgeCommandFactory factory;
    private String operation;

    @Before
    public void setup() {
        factory = new DeleteEdgeCommandFactory();
        operation = "delete_edge";
    }

    @Test
    public void isSupportedCommandTest() {
        Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "delete";
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
        List<String> tokens = getDeleteEdgeTokens();
        factory.parse(tokens);
    }

    private List<String> getDeleteEdgeTokens() {
        List<String> tokens = new ArrayList<>();
        tokens.add(operation);
        tokens.add(GRAPH_NAME);
        tokens.add(EDGE);
        return tokens;
    }

    @Test (expected = IllegalStateException.class)
    public void unsuccessfulParseTest() {
        List<String> tokens = getDeleteEdgeTokensWithExtra();
        factory.parse(tokens);
    }

    private List<String> getDeleteEdgeTokensWithExtra() {
        List<String> tokens = getDeleteEdgeTokens();
        tokens.add(EXTRA);
        return tokens;
    }
}
