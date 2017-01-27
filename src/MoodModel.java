import java.awt.Color;
import java.util.*;
import javax.swing.event.*;

public class MoodModel 
{
	private User currentUser;					//currently logged in user, null if none
	private Mood selectedMood;					//currently selected mood, null if none
	private Response selectedResponse;			//currently selected response, null if none
	private TreeMap<User, ArrayList<Mood>> savedInfo;		//saved moods and responses per user
	private ArrayList<ChangeListener> listeners;

	public MoodModel()
	{
		currentUser = null;
		selectedMood = null;
		selectedResponse = null;
		savedInfo = new TreeMap<User, ArrayList<Mood>>();
		//get serialization info for treemap
		listeners = new ArrayList<ChangeListener>();
	}
	
	public boolean signIn(String username, String password)
	{
		Set<User> users = savedInfo.keySet();
		for(User u : users)
		{
			if(u.getUsername().equals(username) && u.checkPassword(password))
			{
				currentUser = u;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAvailUsername(String username)
	{
		String lowerUsername = username.toLowerCase();
		Set<User> users = savedInfo.keySet();
		for(User u : users)
		{
			if(u.getUsername().toLowerCase().equals(lowerUsername))
			{
				return false;
			}
		}
		return true;
	}
	
	public void addNewUser(String name, String username, boolean referName, String password)
	{
		User addUser = new User(name, username, referName, password);
		ArrayList<Mood> defaultMoods = getDefaultMoods();
		savedInfo.put(addUser, defaultMoods);
	}
	
	public ArrayList<Mood> getDefaultMoods()
	{
		ArrayList<Mood> defaultMoods = new ArrayList<Mood>();
		defaultMoods.add(new Mood("Happy", Color.black));
		defaultMoods.add(new Mood("Sad", Color.black));
		defaultMoods.add(new Mood("Angry", Color.black));
		defaultMoods.add(new Mood("Afraid", Color.black));
		defaultMoods.add(new Mood("Surprised", Color.black));
		return defaultMoods;
	}
}
