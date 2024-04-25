package TrangChu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import games.*;

public class Home extends JFrame implements ActionListener {
    private JButton playButton; // Khai báo biến playButton ở đây

    public Home() {
        setTitle("Snake Game Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Đặt cửa sổ ở trung tâm màn hình
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        playButton = new JButton("Play Snake Game"); // Khởi tạo biến playButton ở đây
        playButton.addActionListener(this); // Đăng ký ActionListener cho nút "Play Snake Game"
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(playButton, gbc);

        getContentPane().add(panel);
        pack(); // Tự động điều chỉnh kích thước cửa sổ dựa trên nội dung của nó
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            openSnakeGame();
            dispose(); // Đóng cửa sổ hiện tại
        }
    }

    private void openSnakeGame() {
        // Tạo một đối tượng của lớp SnakeGame
        SnakeGame snakeGame = new SnakeGame(600, 600);

        // Hiển thị trò chơi
        JFrame gameFrame = new JFrame("Snake Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().add(snakeGame);// add class snakeGame vào
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
