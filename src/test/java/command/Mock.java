package command;

import java.util.ArrayList;
import java.util.List;

public class Mock {

    private CommandParser parser;
    private CommandExecutor executor;

    public static final String GRAPH_NAME = "test";
    public static final String NODE_NAME = "node_name";
    public static final String EDGE_NAME = "edge_name";
    public static final String SOURCE_NODE = "source_node";
    public static final String DESTINATION_NODE = "destination_node";
    public static final String INEXISTENT_GRAPH_NAME = "inexistent_graph";

    public Mock() {
        parser = new CommandParser();
        executor = new CommandExecutor();
    }

    public void createNode(String graphName, String nodeName) {
        List<String> tokens = new ArrayList<>();

        String operation = "add_node";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(nodeName);

        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public void deleteNode(String graphName, String nodeName) {
        List<String> tokens = new ArrayList<>();

        String operation = "delete_node";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(nodeName);

        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public List<String> addNodeTokens(String graphName, String nodeName) {
        List<String> tokens = new ArrayList<>();

        String operation = "add_node";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(nodeName);

        return tokens;
    }
    public List<String> deleteNodeTokens(String graphName, String nodeName) {
        List<String> tokens = new ArrayList<>();

        String operation = "delete_node";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(nodeName);

        return tokens;
    }

    public void createGraph(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "add_graph";

        tokens.add(operation);
        tokens.add(graphName);

        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public void deleteGraph(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "delete_graph";

        tokens.add(operation);
        tokens.add(graphName);

        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public List<String> addGraphTokens(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "add_graph";

        tokens.add(operation);
        tokens.add(graphName);

        return tokens;
    }
    public List<String> deleteGraphTokens(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "delete_graph";

        tokens.add(operation);
        tokens.add(graphName);

        return tokens;
    }

    public void createEdge(String graphName, String edgeName, String sourceNode, String destinationNode) {
        List<String> tokens = addEdgeTokens(graphName, edgeName, sourceNode, destinationNode);
        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public void deleteEdge(String graphName, String edgeName) {
        List<String> tokens = deleteEdgeTokens(graphName, edgeName);
        Command command = parser.parse(tokens);
        executor.execute(command);
    }
    public List<String> addEdgeTokens(String graphName, String edgeName, String sourceNode, String destinationNode) {
        List<String> tokens = new ArrayList<>();

        String operation = "add_edge";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(edgeName);
        tokens.add(sourceNode);
        tokens.add(destinationNode);

        return tokens;
    }
    public List<String> deleteEdgeTokens(String graphName, String edgeName) {
        List<String> tokens = new ArrayList<>();

        String operation = "delete_edge";

        tokens.add(operation);
        tokens.add(graphName);
        tokens.add(edgeName);

        return tokens;
    }

    public List<String> displayTokens(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "display";

        tokens.add(operation);
        tokens.add(graphName);

        return tokens;
    }
    public void display(String graphName) {
        List<String> tokens = new ArrayList<>();

        String operation = "display";

        tokens.add(operation);
        tokens.add(graphName);

        Command command = parser.parse(tokens);
        executor.execute(command);
    }

    public List<String> helpTokens() {
        List<String> tokens = new ArrayList<>();

        String operation = "help";

        tokens.add(operation);

        return tokens;
    }
    public List<String> quitTokens() {
        List<String> tokens = new ArrayList<>();

        String operation = "quit";

        tokens.add(operation);

        return tokens;
    }

    public List<String> getUnsupportedCommands(String baseCommand, String suffixCommand) {
        List<String> command = new ArrayList<>();

        if (suffixCommand == null) {
            command.add(baseCommand.toUpperCase());
            return command;
        } else {
            command.add(baseCommand + '-' + suffixCommand);
            command.add(baseCommand.toUpperCase() + '_' + suffixCommand.toUpperCase());
        }

        command.add("");
        command.add("    ");

        return command;
    }
    public ExecutionContext getContext() {
        return executor.getContext();
    }
    public void addExtra(List<String> tokens) {
        String extra = "extra";
        tokens.add(extra);
    }


}
