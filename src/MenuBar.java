import javax.swing.*;

public class MenuBar extends JPanel
{
	public MenuBar(MoodModel model, JFrame currentFrame)
	{
		//BACK BUTTON
			//if currentFrame is main menu, do the check log out thing
			//if is a mood, make main menu then dispose
					//when go back, make sure to make "current mood" null
			//if is a response, make current mood, info in model, then dispose
					//when go back, make sure to make "current response" null
			//ELSE if none of the 3, go to main menu, OR go to current response, if that null,
					//go to current mood, if that null, go to main menu
		//LOGO BUTTON
			//goes to main menu always
		//QUICK MEMO BUTTON
			//goes to memo frame
	}
}
