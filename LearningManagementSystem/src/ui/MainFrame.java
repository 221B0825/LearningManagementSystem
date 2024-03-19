package ui;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private MainPanel mainPanel;
	
	public MainFrame() {
		this.setTitle("Main Page");
		
		this.mainPanel = new MainPanel();
	}
}
