package command.deletenode;

import command.Command;
import command.ExecutionContext;

public class DeleteNodeCommand implements Command {

    private String graphName;
    private String nodeName;

    DeleteNodeCommand(String graphName, String nodeName) {
        this.graphName = graphName;
        this.nodeName = nodeName;
    }

    @Override
    public void execute(ExecutionContext context) {
        try {
            context.deleteNode(graphName, nodeName);
            System.out.println("Successfully executed delete_node.");
        } catch (Exception e) {
            System.out.println("Graph or node doesn't exist.");
        }
    }
}
