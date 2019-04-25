package executor;

import operations.Operations;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.Viewer;
import tokenizer.Token;
import validator.ValidatorResult;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutor implements Executor {

    private Map<String, Graph> graphs;
    private ExecutorService displayExecutor;

    public SimpleExecutor() {
        graphs = new Hashtable<>();
        displayExecutor = Executors.newCachedThreadPool();
    }

    @Override
    public ExecutorResult execute(ValidatorResult result) {
        Operations operation = Operations.valueOf(result.getOperation());
        try {
            return executeOperation(operation, result);
        } catch (Exception e) {
            return ExecutorResult.createUnsuccessfulResult();
        }
    }

    private ExecutorResult executeOperation(Operations operation, ValidatorResult result) {
        List<Token> tokens = result.getTokens();

        switch (operation) {
            case ADD_NODE: {
                return executeAddNode(tokens);
            }
            case REMOVE_NODE: {
                return executeRemoveNode(tokens);
            }
            case ADD_EDGE: {
                return executeAddEdge(tokens);
            }
            case REMOVE_EDGE: {
                return executeRemoveEdge(tokens);
            }
            case NEW_GRAPH: {
                return executeNewGraph(tokens);
            }
            case DISPLAY: {
                return executeDisplay(tokens);
            }
            case HELP: {
                return executeHelp();
            }
            case QUIT: {
                return executeQuit();
            }
            default:
                return ExecutorResult.createUnsuccessfulResult();
        }
    }

    private ExecutorResult executeQuit() {
        displayExecutor.shutdownNow();
        return ExecutorResult.createQuitResult();
    }

    private ExecutorResult executeHelp() {
        System.out.println("new_graph [graph_id]");
        System.out.println("add_node [graph_id] [node_id]");
        System.out.println("remove_node [graph_id] [node_id]");
        System.out.println("add_edge [graph_id] [edge_id] [first_node_id] [second_node_id]");
        System.out.println("remove_edge [graph_id] [edge_id]");
        System.out.println("display [graph_id]");
        System.out.println("quit(to do)");
        return ExecutorResult.createSuccessfulResult();
    }

    private ExecutorResult executeRemoveEdge(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();
        String edgeName = tokens.get(2).getTokenString();

        if (graphs.containsKey(graphId)) {
            graphs.get(graphId).removeEdge(edgeName);
            return ExecutorResult.createSuccessfulResult();
        }
        return ExecutorResult.createUnsuccessfulResult();
    }

    private ExecutorResult executeRemoveNode(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();
        String nodeToRemove = tokens.get(2).getTokenString();

        if (graphs.containsKey(graphId)) {
            Graph graph = graphs.get(graphId);
            graph.removeNode(nodeToRemove);
            return ExecutorResult.createSuccessfulResult();
        }

        return ExecutorResult.createUnsuccessfulResult();
    }

    private ExecutorResult executeDisplay(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();

        if (graphs.containsKey(graphId)) {
            Graph toDisplay = graphs.get(graphId);

            for (Node node : toDisplay) {
                node.addAttribute("ui.label", node.getId());
            }

            Viewer viewer = new Viewer(toDisplay, Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
            Displayer displayer = new Displayer(viewer);
            displayExecutor.execute(displayer);
            return ExecutorResult.createSuccessfulResult();
        }
        return ExecutorResult.createUnsuccessfulResult();
    }

    private ExecutorResult executeNewGraph(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();
        if (!graphs.containsKey(graphId)) {
            Graph graph = new SingleGraph(graphId);
            graphs.put(graphId, graph);
            return ExecutorResult.createSuccessfulResult();
        }
        return ExecutorResult.createUnsuccessfulResult();
    }

    private ExecutorResult executeAddEdge(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();
        String edgeName = tokens.get(2).getTokenString();
        String firstNodeName = tokens.get(3).getTokenString();
        String secondNodeName = tokens.get(4).getTokenString();

        if (graphs.containsKey(graphId)) {
            graphs.get(graphId).addEdge(edgeName, firstNodeName, secondNodeName);
            return ExecutorResult.createSuccessfulResult();
        }
        return ExecutorResult.createUnsuccessfulResult();
    }

    private ExecutorResult executeAddNode(List<Token> tokens) {
        String graphId = tokens.get(1).getTokenString();
        String firstNodeName = tokens.get(2).getTokenString();

        if (graphs.containsKey(graphId)) {
            graphs.get(graphId).addNode(firstNodeName);
            return ExecutorResult.createSuccessfulResult();
        }
        return ExecutorResult.createUnsuccessfulResult();
    }

}
