package command;

import command.display.DisplayThread;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.swingViewer.Viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionContext {

    private Map<String, Graph> graphs;
    private ExecutorService executor;
    private List<DisplayThread> threads;

    public ExecutionContext() {
        graphs = new HashMap<>();
        executor = Executors.newFixedThreadPool(4);
        threads = new ArrayList<>();
    }

    public boolean containsGraph(String graphName) {
        return graphs.containsKey(graphName.toLowerCase());
    }

    public void remove(String graphName) {
        graphs.remove(graphName);
    }

    public void put(String graphName, Graph graph) {
        graphs.put(graphName.toLowerCase(), graph);
    }


    public void addNode(String graphName, String nodeName) {
        graphs.get(graphName).addNode(nodeName);
        Node addedNode = graphs.get(graphName).getNode(nodeName);
        addedNode.addAttribute("ui.label", addedNode.getId());
    }

    public void deleteNode(String graphName, String nodeName) {
        graphs.get(graphName).removeNode(nodeName);
    }

    public void addEdge(String graphName, String edgeName, String sourceNode, String destinationNode) {
        graphs.get(graphName).addEdge(edgeName, sourceNode, destinationNode);
    }

    public void deleteEdge(String graphName, String edgeName) {
        graphs.get(graphName).removeEdge(edgeName);
    }

    public boolean containsNode(String graphName, String nodeName) {
        return graphs.get(graphName).getNode(nodeName) != null;
    }

    public boolean containsEdge(String graphName, String edgeName) {
        return graphs.get(graphName).getEdge(edgeName) != null;
    }

    public void display(String graphName) {
        Graph toDisplay = graphs.get(graphName);
        Viewer viewer = new Viewer(toDisplay, Viewer.ThreadingModel.GRAPH_IN_SWING_THREAD);
        DisplayThread thread = new DisplayThread(viewer);
        threads.add(thread);
        executor.execute(thread);
    }

    public void quit() {
        for (DisplayThread thread : threads) {
            thread.stop();
        }
        executor.shutdown();
        System.exit(0);
    }
}
