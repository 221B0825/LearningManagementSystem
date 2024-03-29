package ui.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	public MainPanel() {
		this.setLayout(new BorderLayout());
		
		BannerPanel slidingBannerPannel = new BannerPanel();
		this.add(BorderLayout.NORTH,slidingBannerPannel);
		
		
		
	}

}
