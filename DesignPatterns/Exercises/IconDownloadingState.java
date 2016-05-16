import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.ImageProducer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class IconDownloadingState implements Icon {
	private boolean retrieving = false;
	private ImageProxy proxy;
	
	public IconDownloadingState(ImageProxy proxy) {
		this.proxy = proxy;
	}
	
	@Override
	public int getIconWidth() {
		return 800;
	}
	
	@Override
	public int getIconHeigth() {
		return 600;
	}
	
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
		if (!retrieving) { 
			retrieving = true;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						ImageIcon imageIcon = new ImageIcon(imageURL, "CD cover");
						proxy.setState(imageIcon);
						c.repaint();
					} catch (NullPointerException e) { // TODO Cange to correct exception
						e.printStackTrace();
					}
										
				}
			}).start();
		}
	}
}