package display;

import graph.Graph;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisplayManager {
	private ExecutorService executor;
	private List<DisplayThread> threads;

	public DisplayManager() {
		executor = Executors.newFixedThreadPool(4);
		threads = new ArrayList<>();
	}

	public void display(Graph graph) {
		JPanel view = graph.getView();
		DisplayThread thread = new DisplayThread(view);
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
