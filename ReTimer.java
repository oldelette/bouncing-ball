import javax.swing.JPanel;

public class ReTimer implements Runnable
{
	private JPanel repaintPanel;
	private int sleepTime;

	public ReTimer(JPanel panel,int time)
	{
		repaintPanel = panel;
		sleepTime = time;
	} 
	
	public void run()
	{

		while(true)
		{
			try
			{
				Thread.sleep(sleepTime);
				repaintPanel.repaint();
			}
			catch(InterruptedException exception)
			{
				System.out.println( "Error message" );
			}
		} 
	} 
} 
