package LogIn;
import javax.swing.*;

import Sound.PlayMusic;
import Sound.Sound;
import TrangChu.SnakeSettingUI;
import TrangChu.RankFrame;
import TrangChu.Slider;
import TrangChu.SnakeGameGUI;
import dao.BangNguoiDungDAO;
import ran.snakeGame;

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
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Kiểm tra thông tin đăng nhập
            if (BangNguoiDungDAO.getInstance().isValidLogin(username, password)) {
                // Đăng nhập thành công, hiển thị thông báo
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
                String inputValue = usernameField.getText(); // Lấy giá trị từ JTextField
                // Gọi phương thức trong GameUI để sử dụng giá trị này
                SnakeGameGUI.setPlayerName(inputValue);
//                VolumeSliderUI.setPlayerName(inputValue);
                SnakeSettingUI.setPlayerName(inputValue);
                Slider.setPlayerName(inputValue);
                PlayMusic.setPlayerName(inputValue);
                RankFrame.setPlayerName(inputValue);
                snakeGame.setPlayerName(inputValue);
                // Mở SnakeGameGUI
                dispose(); // Đóng cửa sổ đăng nhập
                SwingUtilities.invokeLater(() -> new SnakeGameGUI().setVisible(true));
            } else {
                // Hiển thị thông báo lỗi nếu đăng nhập không thành công
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
            }
        });
        gbc.gridx = 1; // Cột 1
        gbc.gridy = 2; // Dòng 2
        gbc.gridwidth = 2; // Số cột chiếm dụng
        gbc.anchor = GridBagConstraints.CENTER; // Đặt cố định vào giữa
        panel.add(loginButton, gbc);

        

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