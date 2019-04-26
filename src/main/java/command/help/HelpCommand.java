package command.help;

import command.Command;
import command.ExecutionContext;

public class HelpCommand implements Command {
    @Override
    public void execute(ExecutionContext context) {
        System.out.println("\tadd_graph [graph_id]");
        System.out.println("\tdelete_graph [graph_id]");
        System.out.println("\tadd_node [graph_id] [node_id]");
        System.out.println("\tdelete_node [graph_id] [node_id]");
        System.out.println("\tadd_edge [graph_id] [edge_id] [first_node_id] [second_node_id]");
        System.out.println("\tdelete_edge [graph_id] [edge_id]");
        //System.out.println("\tneighbours [graph_id] [node_id]");
        //System.out.println("\tbfs [graph_id] [source_node_id]");
        //System.out.println("\tdfs [graph_id] [source_node_id]");
        System.out.println("\tdisplay [graph_id]");
        System.out.println("\thelp");
        //System.out.println("\tquit");
    }
}
