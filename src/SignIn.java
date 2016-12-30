import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignIn extends JFrame {

	//decorations instance variables
	Font fontB = new Font("Serif", Font.BOLD, 24);
	//Font fontM = new Font("Serif", Font.BOLD, 18);
	Font font2 = new Font("Serif", Font.BOLD, 18);
	Font font = new Font("Serif", Font.PLAIN, 16);
	Font fontS = new Font("Serif", Font.PLAIN, 14);


	Color darkBlue = new Color(62, 89, 130);
	//	Color lightBlue = new Color(154, 183, 182);
	Color teal = new Color(146, 183, 166);
	Color darkTeal = new Color(108, 150, 130);
	Color darkRed = new Color(124, 28, 30);
	Color auburn = new Color(163, 102, 89);

	public SignIn(MoodModel model)
	{	
		//initialize main panel and frame layout
		//		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		//		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		//		Font boldUnderline = new Font("Serif",Font.BOLD, 18).deriveFont(fontAttributes);
		//		getContentPane().setBackground(Color.LIGHT_GRAY);
		JPanel mainPanel = new JPanel();
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


		
		//logo: set images
		JPanel logoPanel = new JPanel();
		Icon logo = new LogoIcon(150, 150);
		LogoIcon logo2 = new LogoIcon(150, 150);
		logo2.setColor(teal);
		LogoIcon logo3 = new LogoIcon(150, 150);
		logo3.setColor(auburn);
		JButton logoButton = new JButton();
		logoButton.setIcon(logo);
		logoButton.setRolloverIcon(logo2);
		logoButton.setPressedIcon(logo3);
		
		
		//logo: edit button look and feel
		logoButton.setForeground(darkBlue);
		logoButton.setFocusPainted(false);
		logoButton.setContentAreaFilled(false);
		logoButton.setBorderPainted(false);
		
		
		//logo: add action
		logoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{

			}

		});
		logoPanel.add(logoButton);
		mainPanel.add(logoPanel);


		//sign in
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
		JPanel signInPanel = new JPanel();
		signInPanel.setLayout(new BoxLayout(signInPanel, BoxLayout.Y_AXIS));
		//		signInPanel.setLayout(new GridLayout(0, 1));
		TitledBorder label = new TitledBorder(new LineBorder(auburn, 2, true), "Mood Listener");
		label.setTitleFont(fontB);
		label.setTitleColor(darkTeal);
		
		
		//sign in: username
		JTextField signInID = new JTextField("Enter username");
		signInID.setToolTipText("Enter username");
		signInID.setFont(font);
		signInID.setForeground(auburn);
		signInID.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				if (signInID.getText().equals("Enter username"))
				{
					signInID.setText("");
				}
			}
			public void focusLost(FocusEvent event) {
				if (signInID.getText().equals("")) {
					signInID.setText("Enter username");
				}
			}
		});	
		
		
		//sign in: password
		JPasswordField signInPass = new JPasswordField("Enter password", 20);
		signInPass.setToolTipText("Enter password");
		char defaultChar = signInPass.getEchoChar();
		signInPass.setEchoChar((char) 0);
		signInPass.setFont(font);
		signInPass.setForeground(auburn);
		signInPass.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent event) {
				String pass = new String(signInPass.getPassword());
				if (pass.equals("Enter password"))
				{
					signInPass.setText("");
					signInPass.setEchoChar(defaultChar);
				}
			}
			public void focusLost(FocusEvent event) {
				String pass = new String(signInPass.getPassword());
				if (pass.equals("")) {
					signInPass.setEchoChar((char) 0);
					signInPass.setText("Enter password");
				}
			}
		});	
		
		
		//sign in: log in
		JButton signInButton = new JButton("Log in");
		signInButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = signInID.getText();
				String password = new String(signInPass.getPassword());
				if(model.signIn(username, password))
				{
					//next screen
					//dispose();
				}
				else
				{
//					signInError.setText("Error: Invalid account information");
				}

			}

		});
		signInButton.setFont(fontS);
		signInButton.setForeground(darkTeal);
		signInButton.setFocusPainted(false);
		signInButton.setContentAreaFilled(false);
		
		
		//sign in: add options to optionsPanels
		signInPanel.setBorder(label);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("Username"));
		signInPanel.add(signInID);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(new JLabel("Password"));
		signInPanel.add(signInPass);
		signInPanel.add(new JLabel("\n"));
		signInPanel.add(signInButton);
		signInPanel.add(new JLabel("\n"));
		optionsPanel.add(signInPanel);
		optionsPanel.add(new JLabel("\n"));
		optionsPanel.add(new JLabel("\n"));
		optionsPanel.add(new JLabel("\n"));


		//sign up
		JPanel signUpPanel = new JPanel();
		JButton signUp = new JButton("New Account");
		signUp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae) {
				SignUp signUp = new SignUp(model);
				dispose();
			}

		});
		signUp.setFont(font2);
		signUp.setForeground(darkTeal);
		signUp.setFocusPainted(false);
		signUp.setContentAreaFilled(false);
		signUpPanel.add(signUp);
		optionsPanel.add(signUpPanel);
		
		
		//set optionsPanel look and feel
		//		optionsPanel.setAlignmentX(LEFT_ALIGNMENT);
		Border border = new EmptyBorder(0, 0, 0, 0);
		Border margin = new EmptyBorder(40, 50, 100, 50);
		optionsPanel.setBorder(new CompoundBorder(border, margin));
		mainPanel.add(optionsPanel);

		
		//set frame options
		add(mainPanel);
		setTitle("Mood Listener");
		setSize(450, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

