package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private CLogin cLogin;

	private JTextField inputId;
	private JPasswordField inputPassword;
	
	public LoginFrame() {
		this.cLogin = new CLogin();
		
		this.setTitle("Login Page");
		this.setLayout(new FlowLayout());

		JLabel inputIdLabel = new JLabel("ID:");
		this.inputId = new JTextField();
		this.inputId.setPreferredSize(new Dimension(100,20));
		JLabel inputPasswordLabel = new JLabel("PW:");
		this.inputPassword = new JPasswordField();
		this.inputPassword.setPreferredSize(new Dimension(100,20));
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ButtonActionHandler());
		
		this.add(inputIdLabel);
		this.add(inputId);
		this.add(inputPasswordLabel);
		this.add(inputPassword);
		this.add(loginButton);
		
		this.pack();
		
		this.setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	private class ButtonActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(cLogin.authenticate(inputId.getText(), inputPassword.getText())) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, "login success :: Welcome!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "login fail :: User Not Found", "Login Fail", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
