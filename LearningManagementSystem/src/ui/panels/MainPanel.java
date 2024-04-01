package ui.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel {

	public MainPanel(String userName) {
		this.setLayout(new BorderLayout());
		
		// ----- TOP Panel -----
		JPanel pageStartPanel = new JPanel();
		pageStartPanel.setLayout(new BoxLayout(pageStartPanel, BoxLayout.Y_AXIS));

		UserPanel userPanel = new UserPanel(userName);
		//  > ---- align-items: center -----
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BannerPanel slidingBannerPannel = new BannerPanel();
		centerPanel.add(slidingBannerPannel);
		//  > ------------------------------
		pageStartPanel.add(userPanel);
		pageStartPanel.add(centerPanel);
		this.add(pageStartPanel, BorderLayout.PAGE_START);
		
		DirectoryPanel directoryPanel = new DirectoryPanel();
		this.add(directoryPanel, BorderLayout.CENTER);
	}
}
