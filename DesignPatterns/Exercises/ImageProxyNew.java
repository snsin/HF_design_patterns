import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class ImageProxy implements Icon {
	
	private Icon downloadingState;
	private Icon downloadedState;
	private Icon currentState;
	
	public ImageProxy(URL url) {
		currentState = new IconDownloadingState(this, url);
	}
	
	@Override
	public int getIconWidth() {
		return currentState.getIconWidth();
	}
	
	@Override
	public int getIconHeigth() {
		currentState.getIconHeight();
	}
	
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		currentState.paintIcon(c, g, x, y);
	}
	
	public void setState(Icon state) {
		currentState = state;
	}
}