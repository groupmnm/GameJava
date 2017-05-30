package teamDCH.userinterface;

import javax.swing.*;

import java.awt.*;

public class GameFrame extends JFrame{
	
	// chieu cao va chieu rong man hinh game
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 600;
	private GamePanel gamePanel;
	public GameFrame()
	{
		// lấy size màn hình 
		Toolkit tookit = this.getToolkit();
		Dimension dimension = tookit.getScreenSize();
		this.setBounds((dimension.width-SCREEN_WIDTH)/2,(dimension.height-SCREEN_HEIGHT)/2,SCREEN_WIDTH,SCREEN_HEIGHT);
		
		gamePanel = new GamePanel();
		add(gamePanel);
		this.addKeyListener(gamePanel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game Mario - Team DCH");
		setVisible(true);
	}
	
	public void StartGame()
	{
		gamePanel.StartGame();
	}
	
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
		gameFrame.StartGame();
	}
}
