package command.quit;

import command.Command;
import command.ExecutionContext;

public class QuitCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        try {
            context.quit();
            System.out.println("Successfully executed quit.");
        } catch (Exception e) {
            System.out.println("Error exiting the application.");
        }
    }
}
