package command.display;

import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import javax.swing.*;

public class DisplayThread implements Runnable {

    private Viewer viewer;

    public DisplayThread(Viewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);

        frame.add(view);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public void stop() {
        System.exit(0);
    }
}
