import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class LogoIcon implements Icon
{
	private int width;
	private int height;
	private Color mainColor;
	
	Color darkBlue = new Color(62, 89, 130);
	Color lightBlue = new Color(154, 183, 182);
	Color teal = new Color(146, 183, 166);
	Color darkTeal = new Color(108, 150, 130);
	Color darkRed = new Color(124, 28, 30);
	Color auburn = new Color(163, 102, 89);
	
	public LogoIcon(int w, int h)
	{
		width = w;
		height = h;
		mainColor = teal;
	}
	
	public int getIconHeight() 
	{
		return height;
	}

	public int getIconWidth() 
	{
		return width;
	}
	
	public void setColor(Color c)
	{
		mainColor = c;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
		//rain cloud with words/letters as rain
		//bird made up of words/letters
		//a bird singing, but show singing as words/letters related to moods/ranting?
		
		
		//try use only above colors
		//silhouette?
		//default color is main as teal or lightBlue?
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ell = new Ellipse2D.Double(x, y, width, height);
		g2.setPaint(mainColor);
		g2.fill(ell);
	}
}
