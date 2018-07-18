import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;
import java.awt.Dimension;
import java.util.Random;
import java.awt.geom.Ellipse2D;

public class BallPanel extends JPanel
{
	private ReTimer repaintTimer;
	private ExecutorService threadExecutor;
	private int panelWidth,panelHeight,ballCounter;
	private final int MAX_NUMBER_OF_BALLS = 20;
	private Ball[] ballArray = new Ball[ MAX_NUMBER_OF_BALLS ];
	private Random randomGenerator;
	

	public BallPanel( int width, int height )
	{
		setPreferredSize(new Dimension( width, height ) );
	 	panelWidth = (int) getPreferredSize().getWidth();
		panelHeight = (int) getPreferredSize().getHeight();
		
		repaintTimer = new ReTimer(this,20);
		
		threadExecutor = Executors.newCachedThreadPool(); 
		setBackground( Color.WHITE );
		setOpaque( true ); 
		addMouseListener( new MouseListener() ); 
		threadExecutor.execute( repaintTimer );
		ballCounter = 0; 
		randomGenerator = new Random(); 
	} 

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D) g; 
		
		for(Ball ball : ballArray) 
		{		
			if(ball != null)
			{
				g2d.setPaint(ball.getBallColour());

				g2d.fill(new Ellipse2D.Double(ball.getXCoord(), 
												ball.getYCoord(), 
												ball.getDiameter(), 
												ball.getDiameter() ) 
						);
			}
		}
	}
	

	public class MouseListener extends MouseAdapter
	{

		public void mousePressed(MouseEvent e)
		{
			if(ballCounter < MAX_NUMBER_OF_BALLS)
			{
				ballArray[ballCounter] = new Ball((int) getPreferredSize().getWidth(),
								                        (int) getPreferredSize().getHeight(),
								                        e.getX(),e.getY(),30);
				

				ballArray[ballCounter].setBallColour(new Color( randomGenerator.nextInt(256),
									     					       randomGenerator.nextInt(256),
									     					       randomGenerator.nextInt(256)
									     					      )
									     		      );
								  
				threadExecutor.execute(ballArray[ballCounter]);
				
				ballCounter++;
			}
		}
	}
}
