import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class LogoIcon implements Icon
{
	private int width;
	private int height;
	private Color mainColor;
	
	public LogoIcon(int w, int h)
	{
		width = w;
		height = h;
		mainColor = Color.GRAY;
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
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ell = new Ellipse2D.Double(x, y, width, height);
		g2.setPaint(mainColor);
		g2.fill(ell);
	}
}
