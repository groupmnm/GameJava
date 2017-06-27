package GameState;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.Player;
import Main.GamePanel;
import TileMap.Background;
import TileMap.TileMap;

public class Level1State extends GameState
{
	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	public Level1State(GameStateManager gsm)
	{
		this.gsm = gsm;
		init();
	}
	
	public void init() 
	{
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(0.07);
		
		
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
		
	}

	public void update() 
	{
		// update player
		player.update();
		
		tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(), GamePanel.HEIGHT / 2 - player.gety());
		
		// set background
		bg.setPosition(tileMap.getx(), tileMap.gety()); 
		
	}
	
	public void draw(Graphics2D g) 
	{
		// draw background
		bg.draw(g); 
		
		// draw tilemap
		tileMap.draw(g);	
		
		// draw player
		player.draw(g);
		
	}
	
	public void keyPressed(int k) 
	{
		if(k == KeyEvent.VK_A)
		{
			player.setLeft(true);
		}
		if(k == KeyEvent.VK_D)
		{
			player.setRight(true);
		}
		if(k == KeyEvent.VK_UP)
		{
			player.setUp(true);
		}
		if(k == KeyEvent.VK_DOWN)
		{
			player.setDown(true);
		}
		if(k == KeyEvent.VK_W)
		{
			player.setJumping(true);
		}
		if(k == KeyEvent.VK_SPACE)
		{
			player.setGliding(true);
		}
	}
	
	public void keyReleased(int k) 
	{
		if(k == KeyEvent.VK_A)
		{
			player.setLeft(false);
		}
		if(k == KeyEvent.VK_D)
		{
			player.setRight(false);
		}
		if(k == KeyEvent.VK_UP)
		{
			player.setUp(false);
		}
		if(k == KeyEvent.VK_DOWN)
		{
			player.setDown(false);
		}
		if(k == KeyEvent.VK_W)
		{
			player.setJumping(false);
		}
		if(k == KeyEvent.VK_SPACE)
		{
			player.setGliding(false);
		}		
	}
}
