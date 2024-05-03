package LogIn;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignForm extends JFrame  implements ActionListener{
	private JTextField fullName;
	private JTextField email;
	private JTextField phone;
	private JPasswordField pass;
	private JPasswordField repeat;
	private JButton signUp;
	
	
	public SignForm() {
		setTitle("Sign Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(7, 1,10,10));
		
		Font font = new Font("Arial", Font.BOLD, 15);
		
		JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel signupLabel = new JLabel("SIGN UP");
		signupLabel.setFont(new Font("Arial", Font.BOLD, 20));
		signupPanel.add(signupLabel);
		
		JPanel fullnamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel fullnameLabel = new JLabel("Full name  :");
		fullName = new JTextField(15);
		fullnamePanel.add(fullnameLabel);
		fullnamePanel.add(fullName);
		
		JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabel = new JLabel("Email         :");
		email = new JTextField(15);
		emailPanel.add(emailLabel);
		emailPanel.add(email);
		
		JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel phoneLabel = new JLabel("Phone       :");
		phone = new JTextField(15);
		phonePanel.add(phoneLabel);
		phonePanel.add(phone);
		
		JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel passLabel = new JLabel("Password :");
		pass = new JPasswordField(15);
		passPanel.add(passLabel);
		passPanel.add(pass);
		
		JPanel repeatLPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel repeatLabel = new JLabel("Repeat      :");
		repeat = new JPasswordField(15);
		repeatLPanel.add(repeatLabel);
		repeatLPanel.add(repeat);
		
		JPanel signUpPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		signUp = new JButton("Sign Up");
		signUp.setFont(font);
		signUp.setBackground(Color.red);
		signUpPanel.add(signUp);
		
		add(signupPanel);
		add(fullnamePanel);
		add(emailPanel);
		add(phonePanel);
		add(passPanel);
		add(repeatLPanel);
		add(signUpPanel);
		pack();
		
		setVisible(true);
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		new SignForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
