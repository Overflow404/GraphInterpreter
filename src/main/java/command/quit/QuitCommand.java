package command.quit;

import command.Command;
import command.ExecutionContext;

public class QuitCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        //TODO: graceful termination.
        System.exit(0);
    }
}
