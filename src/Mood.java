import java.awt.*;
import java.util.*;

public class Mood 
{
	private String title;
	private Color color;
	private String description;
	private String generalTip;
	private ArrayList<Response> savedResponses;
	private ArrayList<Response> choices;
	
	public Mood(String t, Color c)
	{
		title = t;
//		color = c;
		color = new Color(146, 183, 166);
		description = "";
		generalTip = "";
		savedResponses = new ArrayList<Response>();
		choices = new ArrayList<Response>();
//		choices.add, add the default choices for every mood, journal, image, reminder, quote
	}
	
	public void changeTitle(String t)
	{
		//note, in MODEL, before call this, check if desired new title is taken or not
		title = t;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void changeColor(Color c)
	{
		//note, in MODEL, check if desired new color is taken or not
		color = c;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setDescription(String d)
	{
		description = d;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setGeneralTip(String g)
	{
		generalTip = g;
	}
	
	public String getGeneralTip()
	{
		return generalTip;
	}
	
	public void addSavedResponse(Response r)
	{
		savedResponses.add(r);
	}
	
	public ArrayList<Response> getSavedResponses()
	{
		return savedResponses;
	}
	
	public void addChoice(Response c)
	{
		choices.add(c);
	}
	
	public ArrayList<Response> getChoices()
	{
		return choices;
	}
}
