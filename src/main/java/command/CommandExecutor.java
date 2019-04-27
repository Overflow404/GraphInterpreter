package command;

public class CommandExecutor {

    private ExecutionContext context;

    public CommandExecutor() {
        context = new ExecutionContext();
    }

    public void execute(Command command) {
		try {
			command.execute(context);
			System.out.println("Successful command!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    public ExecutionContext getContext() {
        return context;
    }
}
