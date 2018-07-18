import javax.swing.JFrame;
import java.awt.BorderLayout;

public class myTest extends JFrame
{

	BallPanel ballPanel;
	
	public myTest()
	{
		super("Bouncing Ball Game");
		ballPanel = new BallPanel(800,800);
		add(ballPanel);
	} 

	public static void main( String args[] )
	{
		myTest frame = new myTest();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,800,800);
		frame.pack();
		
		frame.setVisible(true); 
	}
}
