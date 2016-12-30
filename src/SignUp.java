import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.*;

public class SignUp extends JFrame {

	//decorations instance variables
	Font fontB = new Font("Serif", Font.BOLD, 24);
	//Font fontM = new Font("Serif", Font.BOLD, 18);
	Font fontM = new Font("Serif", Font.BOLD, 16);
	Font font = new Font("Serif", Font.PLAIN, 16);
	Font fontS = new Font("Serif", Font.PLAIN, 14);


	Color darkBlue = new Color(62, 89, 130);
	//	Color lightBlue = new Color(154, 183, 182);
	Color teal = new Color(146, 183, 166);
	Color darkTeal = new Color(108, 150, 130);
	Color darkRed = new Color(124, 28, 30);
	Color auburn = new Color(163, 102, 89);

	public SignUp(MoodModel model)
	{	
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		//enter new account information
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel infoPanel = new JPanel();
		//		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setLayout(new GridLayout(0, 1));
		TitledBorder label = new TitledBorder(new LineBorder(auburn, 2, true), "Make a new account");
		label.setTitleFont(fontB);
		label.setTitleColor(darkTeal);


		//user's name
		JTextField name = new JTextField("Name, only letters");
		name.setToolTipText("Enter name, only letters");
		name.setFont(font);
		name.setForeground(auburn);
		name.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (name.getText().equals("Name, only letters"))
				{
					name.setText("");
				}
			}
			public void focusLost(FocusEvent event) {
				if (name.getText().equals("")) {
					name.setText("Name, only letters");
				}
			}
		});


		//desired username
		JTextField username = new JTextField("Username/alternative name, only letters");
		username.setToolTipText("Enter username/alternative name, only letters");
		username.setFont(font);
		username.setForeground(auburn);
		username.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (username.getText().equals("Username/alternative name, only letters"))
				{
					username.setText("");
				}
			}
			public void focusLost(FocusEvent event) {
				if (username.getText().equals("")) {
					username.setText("Username/alternative name, only letters");
				}
			}
		});	


		//refer as username or name?
		JPanel refer = new JPanel();
		JRadioButton referName = new JRadioButton("Name");
		referName.setForeground(darkRed);
		referName.setFont(fontS);
		referName.setFocusPainted(false);
		JRadioButton referAlt = new JRadioButton("Username");
		referAlt.setForeground(darkRed);
		referAlt.setFont(fontS);
		referAlt.setFocusPainted(false);
		ButtonGroup group = new ButtonGroup();
		group.add(referName);
		group.add(referAlt);
		refer.add(referName);
		refer.add(referAlt);



		//desired passsword
		JPasswordField password = new JPasswordField("Password", 20);
		password.setToolTipText("Password");
		char defaultChar = password.getEchoChar();
		password.setEchoChar((char) 0);
		password.setFont(font);
		password.setForeground(auburn);
		password.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String pass = new String(password.getPassword());
				if (pass.equals("Password"))
				{
					password.setText("");
					password.setEchoChar(defaultChar);
				}
			}
			public void focusLost(FocusEvent event) {
				String pass = new String(password.getPassword());
				if (pass.equals("")) {
					password.setEchoChar((char) 0);
					password.setText("Password");
				}
			}
		});	


		//re-enter desired password
		JPasswordField passwordCheck = new JPasswordField("Password", 20);
		passwordCheck.setToolTipText("Password");
		char defaultCharCheck = passwordCheck.getEchoChar();
		passwordCheck.setEchoChar((char) 0);
		passwordCheck.setFont(font);
		passwordCheck.setForeground(auburn);
		passwordCheck.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String pass = new String(passwordCheck.getPassword());
				if (pass.equals("Password"))
				{
					passwordCheck.setText("");
					passwordCheck.setEchoChar(defaultCharCheck);
				}
			}
			public void focusLost(FocusEvent event) {
				String pass = new String(passwordCheck.getPassword());
				if (pass.equals("")) {
					passwordCheck.setEchoChar((char) 0);
					passwordCheck.setText("Password");
				}
			}
		});	


		//back button
		JPanel buttonPanel = new JPanel();
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				SignIn signIn = new SignIn(model);
				dispose();
			}

		});
		backButton.setForeground(darkTeal);
		backButton.setFont(fontM);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);


		//confirm account information
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae) {
				//check valid account information

			}

		});
		confirmButton.setForeground(darkTeal);
		confirmButton.setFont(fontM);
		confirmButton.setFocusPainted(false);
		confirmButton.setContentAreaFilled(false);



		//add info fields to panels
		buttonPanel.add(backButton);
		buttonPanel.add(confirmButton);
		infoPanel.setBorder(label);
		infoPanel.add(new JLabel("Enter name"));
		infoPanel.add(name);
		infoPanel.add(new JLabel("Enter username/alternative name"));
		infoPanel.add(username);
		infoPanel.add(new JLabel("Refer as name or username?"));
		infoPanel.add(refer);
		infoPanel.add(new JLabel("Enter password"));
		infoPanel.add(password);
		infoPanel.add(new JLabel("Re-enter password"));
		infoPanel.add(passwordCheck);
		infoPanel.add(buttonPanel);
		panel.add(infoPanel);


		//set panel options
		Border border = new EmptyBorder(0, 0, 0, 0);
		Border margin = new EmptyBorder(20, 50, 40, 50);
		panel.setBorder(new CompoundBorder(border, margin));
		add(panel);


		//frame options
		setTitle("Mood Listener");
		setSize(450, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

