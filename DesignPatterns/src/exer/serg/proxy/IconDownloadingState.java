package exer.serg.proxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class IconDownloadingState implements Icon {
	private boolean retrieving = false;
	private ImageProxy proxy;
	private URL imageURL;
	
	public IconDownloadingState(ImageProxy proxy, URL url) {
		this.proxy = proxy;
		this.imageURL = url;
	}
	
	@Override
	public int getIconWidth() {
		return 800;
	}
	
	@Override
	public int getIconHeight() {
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
						Thread.sleep(20000L);
						proxy.setState(imageIcon);	
						c.repaint();
					} catch (Exception e) { 
						System.out.println("!!!!!!!!!!!");
						e.printStackTrace();
					}
										
				}
			}).start();
		}
	}
}