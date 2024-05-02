package TrangChu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGameGUI extends JFrame implements ActionListener {
    private JButton playButton;
    private JLabel playerNameLabel;
    private JButton soundButton;
    private JButton leaderboardButton;
    private JButton selectMapButton;

    public SnakeGameGUI() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        playerNameLabel = new JLabel("<html><font color='blue'>Player:</font> <font color='red'>giang</font></html>");
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Thiết lập font chữ
        playerNameLabel.setForeground(Color.BLUE); // Thiết lập màu chữ
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ngang văn bản
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playerNameLabel, gbc);




        playButton = new JButton("Play New Game");
        playButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0; // Thiết lập weightx để mở rộng ra
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(playButton, gbc);
        
        leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(leaderboardButton, gbc);


        selectMapButton = new JButton("Select Map");
        selectMapButton.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(selectMapButton, gbc);

        soundButton = new JButton("Sound");
        soundButton.addActionListener(this);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(soundButton, gbc);
        
        
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            // Xử lý sự kiện khi nhấn nút "Play"
        } else if (e.getSource() == soundButton) {
            // Xử lý sự kiện khi nhấn nút "Sound"
            
        } else if (e.getSource() == leaderboardButton) {
            // Xử lý sự kiện khi nhấn nút "Leaderboard"
        } else if (e.getSource() == selectMapButton) {
            // Xử lý sự kiện khi nhấn nút "Select Map"
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeGameGUI());
    }
}
