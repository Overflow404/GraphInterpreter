package command.addnode;


import command.Command;
import command.ExecutionContext;

public class AddNodeCommand implements Command {

    private String graphName;
    private String nodeName;

    AddNodeCommand(String graphName, String nodeName) {
        this.graphName = graphName;
        this.nodeName = nodeName;
    }

    @Override
    public void execute(ExecutionContext context) {
        try {
            context.addNode(graphName, nodeName);
            System.out.println("Successfully executed add_node.");
        } catch (Exception e) {
            System.out.println("Graph doesn't exist or node already exist.");
        }
    }


}
