package view.panels;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1051062108060126218L;
	
	public void paintComponent(Graphics g) {
		try {
			Image img = ImageIO.read(new File("pic/pile_of_coins.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
