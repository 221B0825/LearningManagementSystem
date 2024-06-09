package ui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import domain.Attributes;
import ui.MainLectureTable;

public class BasketPanel extends JPanel {
	
	private MainLectureTable basketTable;

	public BasketPanel(String userName) {
		this.setLayout(new BorderLayout());
		
		// ----- TOP Panel -----
		UserPanel userPanel = new UserPanel(userName);
		this.add(BorderLayout.PAGE_START, userPanel);
		
		// ----- CENTER Panel -----
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		this.basketTable = new MainLectureTable();
		JScrollPane basketScrollPane = new JScrollPane();
		basketScrollPane.setViewportView(this.basketTable);
		basketScrollPane.setPreferredSize(new Dimension(Attributes.COMMON_WIDTH.getValue(), Attributes.LECTURE_HEIGHT.getValue()));
		centerPanel.add(basketScrollPane);
		
		this.add(BorderLayout.CENTER,centerPanel);
	}

}
