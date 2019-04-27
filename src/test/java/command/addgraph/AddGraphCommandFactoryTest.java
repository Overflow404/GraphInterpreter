package command.addgraph;

import exception.InvalidSyntaxException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static command.Constants.EXTRA;
import static command.Constants.GRAPH_NAME;

public class AddGraphCommandFactoryTest {

    private AddGraphCommandFactory factory;
	private String operation;

    @Before
    public void setup() {
        factory = new AddGraphCommandFactory();
		operation = "add_graph";
    }

    @Test
    public void isSupportedCommandTest() {
		Assert.assertTrue(factory.isSupported(operation));
    }

    @Test
    public void isNotSupportedCommandTest() {
        String baseCommand = "add";
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
		List<String> tokens = getAddGraphTokens();
        factory.parse(tokens);
    }

	@Test(expected = InvalidSyntaxException.class)
    public void unsuccessfulParseTest() {
		List<String> tokens = getAddGraphTokensWithExtra();
        factory.parse(tokens);
    }

	private List<String> getAddGraphTokens() {
		List<String> tokens = new ArrayList<>();
		tokens.add(operation);
		tokens.add(GRAPH_NAME);
		return tokens;
	}

	private List<String> getAddGraphTokensWithExtra() {
		List<String> tokens = getAddGraphTokens();
		tokens.add(EXTRA);
		return tokens;
	}
}
