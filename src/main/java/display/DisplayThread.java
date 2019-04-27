package display;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class DisplayThread implements Runnable {
	private JPanel view;
	private JFrame frame;

	public DisplayThread(JPanel view) {
		this.view = view;
    }

    @Override
    public void run() {
		frame = new JFrame();
        frame.add(view);
        frame.setSize(600,600);
        frame.setVisible(true);
    }

    public void stop() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
