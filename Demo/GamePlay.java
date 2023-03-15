package Demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JLabel;

public class GamePlay extends JLabel implements ActionListener,KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean play = false;
	int totalBricks = 21;
	Timer timer;
	int delay =8;
	int ballPosX = 120;
	int ballPosY = 350;
	int ballDirX = -1;
	int ballDirY = -2;
	int playerX=350;
	Map map;
	
	
	public GamePlay() 
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		  timer = new Timer(delay,this);
		  timer.start();
		
		map = new Map(3,7);
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g); 
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592);
		
		// Border
		g.setColor(Color.yellow);
		g.fillRect(0,0,692,3);
		g.fillRect(0,3,3,592);
		g.fillRect(691,3,3,592);
		
		// paddle
		g.setColor(Color.GREEN);
		g.fillRect(playerX, 550, 100, 8);
		
		
		//Bricks
		map.draw((Graphics2D) g);
		
		// ball
		g.setColor(Color.red);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(play==true)
		{
			if(ballPosX<=0)
			{
				ballDirX =-ballDirX;
			}

			//if(ballPosY>=570)
			{
				//ballDirY =-ballDirY;
			}
			if(ballPosX>=670)
			{
				ballDirX =-ballDirX;
			}
			if(ballPosY<=0)
			{
				ballDirY =-ballDirY;
			}
			
			
			Rectangle ballRect=new Rectangle(ballPosX,ballPosY,20,20);
			Rectangle paddleRect=new Rectangle(playerX,550,100,8);
			
			if(ballRect.intersects(paddleRect))
			{
				ballDirY=-ballDirY;
			}
			
			// single is for the variable in this class
			
			a:for (int i = 0; i < map.map.length; i++) 
			{
				for (int j = 0; j < map.map[0].length; j++) 
				{
					if(map.map[i][j]>0)
					{
						
						int width = map.brickHeight;
						int height=map.brickHeight;
						int brickXpos=80+j*width;
						int brickYpos=50+i*height;
						
						Rectangle brickRect = new Rectangle(brickXpos,brickYpos,width,height);
						
						if(ballRect.intersects(brickRect))
						{
							map.setBrick(0,i,j);
							totalBricks--;
						}
						
						//if(ballPosX+19 <=brickXpos || ballPosX+1 >=brickXpos+width)
						{
							//ballDirX=-ballDirX;
						}
						//else
						{
							//ballDirY =-ballDirY;
						}
						
						//break a;
						
						
					}
				}
			}
			
			
			
			ballPosX +=ballDirX;
			ballPosY +=ballDirY;
			
			
		}
		repaint();
	}
	
	private void moveLeft()
	{
		play=true;
		playerX-= 20;
		
	}
	
	private void moveRight()
	{
		playerX+= 20;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			if(playerX<=0)
				playerX=0;
			else
			moveLeft();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			if(playerX>=600)
				playerX=600;
			else
			moveRight();
		}
		
		repaint();
	}

	
	
	
	
	
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {}

	
	
	
}
