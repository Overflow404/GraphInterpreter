package executor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tokenizer.Token;
import syntaxvalidator.ValidatorResult;

import java.util.ArrayList;
import java.util.List;

public class SimpleExecutorTest {

    private SimpleExecutor executor;
    private ExecutorResult successful;
    private ExecutorResult unsuccessful;

    @Before
    public void setup() {
        executor = new SimpleExecutor();
        successful = ExecutorResult.createSuccessfulResult();
        unsuccessful = ExecutorResult.createUnsuccessfulResult();
    }

    @Test
    public void successfulGraphCreationExecutionTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("new_graph"));
        tokens.add(new Token("graph_name1"));

        ValidatorResult result = ValidatorResult.createSuccessfulResult(tokens);

        Assert.assertEquals(successful, executor.execute(result));
    }

    @Test
    public void duplicateGraphCreationExecutionTest() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token("new_graph"));
        tokens.add(new Token("graph_name1"));

        ValidatorResult result = ValidatorResult.createSuccessfulResult(tokens);

        Assert.assertEquals(successful, executor.execute(result));

        tokens.clear();
        tokens.add(new Token("new_graph"));
        tokens.add(new Token("graph_name1"));

        Assert.assertEquals(unsuccessful, executor.execute(result));
    }

}
