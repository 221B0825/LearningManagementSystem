package ui.panels;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Path;

public class UserPanel extends JPanel{
	
	public UserPanel(String userName) {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel nameLabel = new JLabel(userName);
		this.add(nameLabel);
		
		ImageIcon icon = new ImageIcon(Path.USER_ICON.getPath());
		ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH));
		JLabel userIcon = new JLabel(resizedIcon);
		this.add(userIcon);
		
		
	}

}
