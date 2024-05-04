package LogIn;
import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
public class LogIn extends JFrame  {
    
	
    public void logIn() {
        setTitle("Bạn cần phải đăng nhập tài khoản để chơi game!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        
        JLabel titleLabel = new JLabel("Bạn phải đăng nhập tài khoản để chơi game!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0,0,5,0);
        panel.add(titleLabel, gbc);
        
        JButton loginBtn = new JButton("Đăng nhập");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10,5,5,5);
        panel.add(loginBtn, gbc);
        
        JButton signinBtn = new JButton("Đăng ký");
        gbc.gridx = 1; // Sửa từ 2 thành 1
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(signinBtn, gbc);
        
        loginBtn.addActionListener(e -> {
        	LoginForm loginForm = new LoginForm();
        	loginForm.setVisible(true);
        });
        
        signinBtn.addActionListener(e -> {
        	SignForm signForm = new SignForm();
        	signForm.setVisible(true);
        });
        
        
        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LogIn().logIn());
    }

}
