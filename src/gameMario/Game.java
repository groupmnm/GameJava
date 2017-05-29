package gameMario;
import java.awt.*;
import javax.swing.*;

public class Game extends JFrame{
	public Game()
	{
		setTitle("Game Mario - Team DCH");
		setSize(1600,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new LoadImage());
		setVisible(true);
	}
}
