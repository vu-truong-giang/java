package LogIn;
import javax.swing.*
;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public SignForm() {
        setTitle("Đăng ký");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5,5,5,5);

        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        gbc.gridx = 0 ;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);
        
        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);
        
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);
        
        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);
        
        JLabel confirmPasswordLabel = new JLabel("Xác nhận mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(confirmPasswordLabel, gbc);
        
        confirmPasswordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(confirmPasswordField, gbc);
        
        JButton registerButton = new JButton("Đăng ký");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

                // Kiểm tra mật khẩu và xác nhận mật khẩu
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu và xác nhận mật khẩu không khớp!");
                } else {
                    // Thực hiện đăng ký tài khoản ở đây
                    JOptionPane.showMessageDialog(null, "Tài khoản đã được đăng ký thành công!");
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
                new SignForm();
            }
        });
    }
}
