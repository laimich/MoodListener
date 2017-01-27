import javax.swing.*;

public class MainMenu extends JFrame
{
	public MainMenu(MoodModel model)
	{
		MenuBar bar = new MenuBar(model, this);
		
		
		
		//set frame options
		setTitle("Mood Listener");
		setSize(450, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
