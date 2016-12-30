
public class User 
{
	private String name;
	private String username;
	private boolean referName;
	private String password;

	public User(String n, String user, boolean ref, String p)
	{
		name = n;
		username = user;
		referName = ref;
		password = p;
	}

	public String getNameReference()
	{
		if(referName == true)
			return name;
		else
			return username;
	}

	public String getUsername()
	{
		return username;
	}

	public void changeReferSetting(boolean setting)
	{
		referName = setting;
	}

	public boolean checkPassword(String otherPass)
	{
		if(password.equals(otherPass))
			return true;
		else
			return false;
	}
}
