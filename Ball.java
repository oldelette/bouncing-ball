import java.util.Random;
import java.awt.Color;

public class Ball implements Runnable
{
	private int x,y;
	private int xChange,yChange;
	private int diameter,maxHeight,maxWidth;
	private boolean forwards,downwards;
	private Random randomGenerator;
	private Color ballColour;

	public Ball( int windowWidth, int windowHeight, int startX, int startY, int ballDiameter )
	{
		x = startX;
		y = startY;
		diameter = ballDiameter;
		forwards = true;
		downwards = true;
		setMaxWidth( windowWidth );
		setMaxHeight( windowHeight );
		randomGenerator = new Random();
		xChange = 1 + randomGenerator.nextInt(5);
		yChange = 1 + randomGenerator.nextInt(5); 
		ballColour = Color.BLUE; 
	}
	

	public void run()
	{
		while( true )
		{
			try
			{
				Thread.sleep(20);
			
				if(forwards)
				{
					x += xChange;
					
					if(x >=(maxWidth - diameter))
						forwards = false;
				}
				else
				{
					x -= xChange;

					if(x<=0)
						forwards = true;
				}
				
				if(downwards)
				{
					y += yChange;
					
					if( y >= ( maxHeight - diameter ) )
						downwards = false;
				}
				else
				{
					y -= yChange;
					
					if(y <= 0)
						downwards = true;
				}
			}
			catch(InterruptedException exception)
			{
				System.out.println("Interrupted exception in Ball");
			}
		}
	}
	
	public void setMaxWidth( int width )
	{
		maxWidth = width;
	}

	public void setMaxHeight( int height )
	{
		maxHeight = height;
	}
	
	public void setBallColour( Color colour )
	{
		ballColour = colour;
	}
	
	public int getDiameter()
	{
		return diameter;
	}
	
	public int getXCoord()
	{
		return x;
	}
	
	public int getYCoord()
	{
		return y;
	}
	
	public Color getBallColour()
	{
		return ballColour;
	}
}
