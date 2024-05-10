package LogIn;
import javax.swing.*;

import dao.BangNguoiChoiDAO;
import dao.BangNguoiDungDAO;
import dao.BangTrangThaiGameDAO;
import model.BangNguoiChoi;
import model.BangNguoiDung;
import model.BangTrangThaiGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField , nameField;
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

        // ten dnag nhap
        JLabel nameLabel = new JLabel("Tên Người Chơi:");
        gbc.gridx = 0 ;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(nameLabel, gbc);
        
        nameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(nameField, gbc);
        
        // tai khoan
        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        gbc.gridx = 0 ;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);
        
        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);
        
        
        // mat khau
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);
        
        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);
        
        
        //nhap lại mat khau
        JLabel confirmPasswordLabel = new JLabel("Xác nhận mật khẩu:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(confirmPasswordLabel, gbc);
        
        confirmPasswordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(confirmPasswordField, gbc);
        
        
        // nut dagn ky
        JButton registerButton = new JButton("Đăng ký");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String name = nameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

                // Kiểm tra mật khẩu và xác nhận mật khẩu
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu và xác nhận mật khẩu không khớp!");
                } else if (BangNguoiDungDAO.getInstance().selectByName(username) == true) {
                    JOptionPane.showMessageDialog(null, "Tồn tại tên đăng nhập!");
                } else if (BangNguoiChoiDAO.getInstance().selectByName(name) == true) {
                    JOptionPane.showMessageDialog(null, "Tồn tại tên người chơi!");
                } else {
                    // Thực hiện đăng ký tài khoản ở đây
                	
                	String randomString = generateRandomString(8);
                	
                	BangNguoiDung bangnguoidung = new BangNguoiDung(randomString, username , password );
                	BangNguoiDungDAO.getInstance().insert(bangnguoidung);
                	
                	BangNguoiChoi bangnguoichoi = new BangNguoiChoi(randomString , name , randomString ,randomString ,0);
                	BangNguoiChoiDAO.getInstance().insert(bangnguoichoi);
                	
                	BangTrangThaiGame bangtrangthaigame = new BangTrangThaiGame(randomString , 1, 1, 0 , 0);
                	BangTrangThaiGameDAO.getInstance().insert(bangtrangthaigame);
                	
                    JOptionPane.showMessageDialog(null, "Tài khoản đã được đăng ký thành công!");
                    
                    nameField.setText("");
                    usernameField.setText("");
                    passwordField.setText("");
                    confirmPasswordField.setText("");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);
        
        
        
        
        JButton back = new JButton("Trở lại");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Đóng frame hiện tại khi nút "Trở lại" được nhấn
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(back);
                currentFrame.dispose();
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(back, gbc);
        
        

        

        getContentPane().add(panel);
        setVisible(true);
    }
    
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        
        boolean isUnique = false;
        do {
            randomString.setLength(0); // Xóa chuỗi hiện tại để tạo chuỗi mới
            for (int i = 0; i < length; i++) {
                randomString.append(characters.charAt(random.nextInt(characters.length())));
            }
            // Kiểm tra xem chuỗi ngẫu nhiên đã tạo có tồn tại trong CSDL không
            isUnique = !BangNguoiDungDAO.getInstance().selectById(randomString.toString());
        } while (!isUnique);

        return randomString.toString();
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