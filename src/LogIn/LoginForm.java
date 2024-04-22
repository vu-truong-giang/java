package LogIn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST; // Đặt cố định thành trái

        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 0; // Dòng 0
        gbc.gridwidth = 1; // Số cột chiếm dụng
        gbc.insets = new Insets(5,5,5,5); // Khoảng cách giữa các thành phần
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1; // Cột 1
        gbc.gridy = 0; // Dòng 0
        gbc.gridwidth = 2; // Số cột chiếm dụng
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Mật khẩu:");
        gbc.gridx = 0; // Cột 0
        gbc.gridy = 1; // Dòng 1
        gbc.gridwidth = 1; // Số cột chiếm dụng
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1; // Cột 1
        gbc.gridy = 1; // Dòng 1
        gbc.gridwidth = 2; // Số cột chiếm dụng
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Đăng nhập");
        gbc.gridx = 1; // Cột 1
        gbc.gridy = 2; // Dòng 2
        gbc.gridwidth = 2; // Số cột chiếm dụng
        gbc.anchor = GridBagConstraints.CENTER; // Đặt cố định vào giữa
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                // Kiểm tra tên đăng nhập và mật khẩu ở đây
                if(username.equals("admin") && password.equals("123")) {
                	JOptionPane.showMessageDialog(null , "Đăng nhập thành công");
                } else {
                	JOptionPane.showMessageDialog(null, "Tên đang nhập hoặc mật khẩu không đúng!");
                }
            }
        });

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm();
            }
        });
    }
}
