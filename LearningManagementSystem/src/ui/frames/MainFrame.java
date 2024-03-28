package ui.frames;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import control.CDirectory;
import entity.EDirectory;

public class MainFrame extends JFrame implements FrameImpl {
	private static final long serialVersionUID = 1L;
	public MainFrame() {
		this.setTitle("Main Page");
		this.setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.add(new DirectoryPanel("data\\lecture\\root.txt"));
		this.add(BorderLayout.CENTER, centerPanel);
		
		this.pack();
        this.setLocation(this.calculateLocation(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class DirectoryPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CDirectory cDirectory;
		private String filePath;
		
		private DefaultListModel<EDirectory> listModel;
		
		public DirectoryPanel(String filePath) {
			this.filePath = filePath;
			this.cDirectory = new CDirectory();
			
			this.listModel = new DefaultListModel<>();
			JList list = new JList<>(listModel);
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.add(list);
		}
	}
}
