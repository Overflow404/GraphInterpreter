import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Test;

public class GraphExample {

    @Test
    public void example() throws InterruptedException {
        Graph graph = new SingleGraph("Example");

        graph.setStrict(false);
        graph.setAutoCreate(true);
        graph.display();
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("AB", "A", "B");

        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
        }

        Thread.sleep(5000);
    }
}
