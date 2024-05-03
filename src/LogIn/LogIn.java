package LogIn;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogIn extends JFrame implements ActionListener {
    private JTextField user;
    private JTextField pass;
    private JButton logIn;
    private JButton signUp;

    public LogIn() throws HeadlessException {
        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("Log In");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 20);

        JLabel jLabel_user = new JLabel("User");
        jLabel_user.setFont(font);
        JLabel jLabel_pass = new JLabel("Password");
        jLabel_pass.setFont(font);

        user = new JTextField(15);
        user.setFont(font);
        pass = new JTextField(15);
        pass.setFont(font);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2, 200, 100));
        jPanel.add(jLabel_user);
        jPanel.add(user);
        jPanel.add(jLabel_pass);
        jPanel.add(pass);

        logIn = new JButton("Log In");
        logIn.addActionListener(this);
        logIn.setFont(font);
        logIn.setBackground(Color.WHITE);

        signUp = new JButton("Sign Up");
        signUp.addActionListener(this);
        signUp.setFont(font);
        signUp.setBackground(Color.WHITE);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(1, 2, 50, 50));
        jPanel2.add(logIn);
        jPanel2.add(signUp);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(jPanel, BorderLayout.CENTER);
        mainPanel.add(jPanel2, BorderLayout.SOUTH);

        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nhấn nút Log In hoặc Sign Up
        // Cần thêm mã xử lý sau này
    }

    public static void main(String[] args) {
        new LogIn();
    }

}
