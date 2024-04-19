package LogIn;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JCheckBox rememberCheckBox;
    private JButton loginButton;
    private JButton signupButton;
    
    public LoginForm() {
    	setTitle("Login Form");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,400);
    	setLocationRelativeTo(null);
    	
    	
    	setLayout(new GridLayout(4, 1, 10,10));
    	
    	Font font = new Font("Arial", Font.BOLD, 15);
    	JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JLabel userLabel = new JLabel("Username:");
    	userLabel.setFont(font);
    	userField = new JTextField(20);
    	userField.setFont(font);
    	userPanel.add(userLabel);
    	userPanel.add(userField);
    	
    	JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	JLabel passLabel = new JLabel("Password:");
    	passLabel.setFont(font);
    	passField = new JPasswordField(20);
    	passField.setFont(font);
    	passPanel.add(passLabel);
    	passPanel.add(passField);
    	
    	JPanel rememberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	rememberCheckBox = new JCheckBox(" Remember Password");
    	rememberPanel.add(rememberCheckBox);
    	
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	loginButton = new JButton("Log In");
    	loginButton.setFont(font);
    	loginButton.addActionListener(this);
    	panel.add(loginButton);
    	
    	signupButton = new JButton("Sign Up");
    	signupButton.setFont(font);
    	signupButton.addActionListener(this);
    	panel.add(signupButton);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	add(userPanel);
    	add(passPanel);
    	add(rememberPanel);
    	add(panel);
    	pack();
    	setVisible(true);
    	
    }
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String user = userField.getText();
		String pass = new String(passField.getPassword());
		
		// kiểm tra tên và mk
		if(user.equals("admin") && pass.equals("admin")) {
			if(rememberCheckBox.isSelected()) {
				JOptionPane.showMessageDialog(this, "Login successful! Remember password:"+pass);
				
			} else {
				JOptionPane.showMessageDialog(this, "Login successful!" );
			}
		} else {
			JOptionPane.showMessageDialog(this,"Invalid username or password. Please try again." );
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new LoginForm();
			}
		});
	}
	
}


