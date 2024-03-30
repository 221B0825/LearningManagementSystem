package ui.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	public MainPanel(String userName) {
		this.setLayout(new BorderLayout());
		UserPanel userPanel = new UserPanel(userName);
		this.add(userPanel, BorderLayout.NORTH);
		
		// ---- align-items: center -----
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BannerPanel slidingBannerPannel = new BannerPanel();
		centerPanel.add(slidingBannerPannel);
		this.add(centerPanel, BorderLayout.CENTER);
		// ------------------------------
		
		DirectoryPanel directoryPanel = new DirectoryPanel();
		this.add(directoryPanel, BorderLayout.SOUTH);
		
	}
}
