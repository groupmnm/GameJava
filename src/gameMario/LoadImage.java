package gameMario;

import java.awt.*;

import javax.swing.*;

public class LoadImage extends JPanel{
	private Image image;
	public LoadImage()
	{
		ImageIcon imageIcon = new ImageIcon("img/Welcome.png");
		image = imageIcon.getImage();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 100, 100, this);
	}
}
