package ui.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import domain.Path;

public class BannerPanel extends JPanel implements ActionListener {
	private Timer timer;
	private int offsetX = 0;
	private int slideSpeed = 12;
	private ImageIcon[] banners = { new ImageIcon(Path.BANNER_IMAGE_1.getPath()),
			new ImageIcon(Path.BANNER_IMAGE_2.getPath()), new ImageIcon(Path.BANNER_IMAGE_3.getPath()) };

	private int currentImageIndex = 0;
	private boolean paused = true;

	public BannerPanel() {
		this.setPreferredSize(new Dimension(672	,128));
		
		// set the first delay: 3-second
		this.timer = new Timer(3000, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw current image
		if (banners[currentImageIndex] != null) {
			banners[currentImageIndex].paintIcon(this, g, offsetX, 0);
		}

		// draw next image
		int nextImageIndex = (currentImageIndex + 1) % banners.length;
		if (banners[nextImageIndex] != null) {
			// System.out.println("nextImageWidth: "+ (offsetX+this.getWidth()));
			banners[nextImageIndex].paintIcon(this, g, offsetX + this.getWidth(), 0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (!paused) {
	    	// offsetX is always negative number
	        offsetX = offsetX - slideSpeed;
	        if (offsetX <= -this.getWidth()) {
	        	//System.out.println(offsetX + " "+ this.getWidth());
	            offsetX = 0;
	            currentImageIndex = (currentImageIndex + 1) % banners.length;
	            paused = true;
	            // stop 3-second
	            timer.setDelay(3000);
	        }
	    } else {
	        // after delay 3-second
	        if (timer.getDelay() == 3000) {
	            // change delay (timer invoke actionPerformed() every 2 milliseconds)
	        	timer.setDelay(20);
	            paused = false;
	        }
	    }
	    
	    // call paintComponent();
	    repaint();
	}



}