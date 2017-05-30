package teamDCH.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable,KeyListener{

	private Thread thread;
	private boolean isRunning;
	private InputManger inputManger;
	public GamePanel()
	{
		isRunning = true;
		inputManger = new InputManger();
	}
	public void StartGame()
	{
		if(thread == null)
		{
			thread = new Thread(this);
		}
		thread.start();
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
	}

	@Override
	public void run() {
		long FPS = 80;
		long perios = 1000 * 1000000 /FPS;
		long beginTime;
		long sleepTime;
		int a =0;
		
		while(isRunning)
		{
			beginTime = System.nanoTime();
			long deltaTime = System.nanoTime() - beginTime;
			sleepTime = perios - deltaTime;
			
			try {
				if(sleepTime >0)
				{
					Thread.sleep(sleepTime/1000000);
				}
				else
				{
					Thread.sleep(perios/2000000);
				}
			} catch (InterruptedException e) {}
			
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		inputManger.ProcessKeyPressed(e.getKeyCode());
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		inputManger.ProcessKeyReleased(e.getKeyCode());
	}
}
