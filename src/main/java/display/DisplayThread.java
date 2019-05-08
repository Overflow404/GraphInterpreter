package display;

import javax.swing.*;

public class DisplayThread implements Runnable {
    private JPanel view;

    DisplayThread(JPanel view) {
        this.view = view;
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.add(view);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
