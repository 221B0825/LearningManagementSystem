package ui.frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ui.panels.MainPanel;
import ui.panels.UserPanel;

public class MainFrame extends JFrame implements FrameImpl {
	private static final long serialVersionUID = 1L;
	public MainFrame(String userName) {
		this.setTitle("Main Page");
		
		MainPanel mainPanel = new MainPanel(userName);
		this.add(mainPanel);
		
		this.pack();
        this.setLocation(this.calculateLocation(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
