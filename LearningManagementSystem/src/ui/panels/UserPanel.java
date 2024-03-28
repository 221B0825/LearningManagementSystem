package ui.panels;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel{
	
	public UserPanel(String userName) {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		ImageIcon icon = new ImageIcon("data\\user\\userIcon.png");
		JLabel userIcon = new JLabel(icon); 
		this.add(userIcon);
		
		JLabel nameLabel = new JLabel(userName);
		this.add(nameLabel);
	}

}
