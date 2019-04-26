package command.display;

import command.ExecutionContext;
import command.Mock;
import org.junit.Before;
import org.junit.Test;

import static command.Mock.INEXISTENT_GRAPH_NAME;

public class DisplayCommandTest {

    private Mock mock;
    private ExecutionContext context;

    @Before
    public void setup() {
        mock = new Mock();
        context = mock.getContext();
    }

    @Test
    public void unsuccessfulCommandDisplayTest() {
        mock.display(INEXISTENT_GRAPH_NAME);
    }
}
