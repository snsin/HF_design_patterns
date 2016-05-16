import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class ImageProxy implements Icon {
	private ImageIcon imageIcon;
	private URL imageURL;
	private Thread retrievalThread;
	private boolean retrieving = false;
	
	private Icon downloadingState;
	private Icon downloadedState;
	private Icon currentState;
	
	public ImageProxy(URL url) {
		imageURL = url;
		currentState = new IconDownloadingState();
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
}