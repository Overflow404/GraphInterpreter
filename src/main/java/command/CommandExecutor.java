package command;

public class CommandExecutor {

    private ExecutionContext context;

    public CommandExecutor() {
        context = new ExecutionContext();
    }

    public void execute(Command command) {
        command.execute(context);

    }

    public ExecutionContext getContext() {
        return context;
    }
}
