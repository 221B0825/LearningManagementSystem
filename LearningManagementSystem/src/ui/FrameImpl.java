package ui;

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

public interface FrameImpl {
	
	public default Point calculateLocation(JFrame Frame) {
		Point centerPoint = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int frameX = centerPoint.x - Frame.getWidth() / 2;
        int frameY = centerPoint.y - Frame.getHeight() / 2;
        return new Point(frameX, frameY);
	}
}
