package display;

import graph.Graph;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisplayManager {
    private ExecutorService executor;

    public DisplayManager() {
        executor = Executors.newFixedThreadPool(4);
    }

    public void display(Graph graph) {
        JPanel view = graph.getView();
        DisplayThread thread = new DisplayThread(view);
        executor.execute(thread);
    }
}
