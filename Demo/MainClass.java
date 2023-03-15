package Demo;

import javax.swing.JFrame;

public class MainClass extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MainClass()
	{
		
		setTitle("my game");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePlay gameplay = new GamePlay();
		add(gameplay);
	}

	public static void main(String[] args) 
	{
		
		new MainClass().setVisible(true);		
		
	
	}
}
