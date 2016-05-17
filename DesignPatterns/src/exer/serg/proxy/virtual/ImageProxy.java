package exer.serg.proxy.virtual;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;

class ImageProxy implements Icon {
	
	private Icon currentState;
	
	public ImageProxy(URL url) {
		currentState = new IconDownloadingState(this, url);
	}
	
	@Override
	public int getIconWidth() {
		return currentState.getIconWidth();
	}
	
	@Override
	public int getIconHeight() {
		return currentState.getIconHeight();
	}
	
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		currentState.paintIcon(c, g, x, y);
	}
	
	public void setState(Icon state) {
		currentState = state;
	}


}