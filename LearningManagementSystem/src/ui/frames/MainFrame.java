package ui.frames;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import ui.panels.BasketPanel;
import ui.panels.MainPanel;

public class MainFrame extends JFrame implements FrameImpl {
	private static final long serialVersionUID = 1L;
	public MainFrame(String userName) {
		this.setTitle("Learning Management System");
		
		JTabbedPane tabbedPane = new JTabbedPane();
		MainPanel mainPanel = new MainPanel(userName);
		tabbedPane.addTab("Main Page",mainPanel);
		
		BasketPanel basketPanel = new BasketPanel(userName);
		tabbedPane.addTab("Basket Page",basketPanel);
		
		this.add(tabbedPane);
		
		this.pack();
        this.setLocation(this.calculateLocation(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
