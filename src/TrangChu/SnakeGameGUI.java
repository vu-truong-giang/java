package TrangChu;

import javax.swing.*;

import LogIn.LoginForm;
import Sound.PlayMusicInMap;
import Sound.playMusic;
import dao.BangNguoiChoiDAO;
import games.SnakeGame;
import model.BangNguoiChoi;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeGameGUI extends JFrame implements ActionListener {
    private JButton playButton;
    private JLabel playerNameLabel;
    private JButton soundButton;
    private JButton leaderboardButton;
    private JButton selectMapButton;
    private playMusic musicPlayer;
    
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
        // Sử dụng giá trị playerName ở đây
    }

    public SnakeGameGUI() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
        
        playerNameLabel = new JLabel("<html><font color='blue'>Player:</font> <font color='red'>" + BangNguoiChoiDAO.getInstance().selectByNameReturnNameuser(playerName) + "</font></html>");
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerNameLabel.setForeground(Color.BLUE);
        playerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playerNameLabel, gbc);

        playButton = new JButton("Play New Game");
        playButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
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
        selectMapButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new SnakeSettingUI().setVisible(true));
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(selectMapButton, gbc);

        soundButton = new JButton("Sound");
        soundButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new VolumeSliderUI().setVisible(true));
        });
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
            // Create a new JFrame for the game window
            JFrame gameWindow = new JFrame("Snake Game");
            gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the window when closed

            // Create an instance of SnakeGame and add it to the game window
            SnakeGame snakeGame = new SnakeGame(600, 600); // Adjust the dimensions as needed
            gameWindow.add(snakeGame);

            // Pack and display the game window
            gameWindow.pack();
            gameWindow.setLocationRelativeTo(null);
            gameWindow.setVisible(true);
        } else if (e.getSource() == soundButton) {
            // Handle sound button action
        } else if (e.getSource() == leaderboardButton) {
            // Handle leaderboard button action

        } else if (e.getSource() == selectMapButton) {
            // Handle select map button action
        }
    }
    


    public static void main(String[] args) {
    	
    	
      
        // Tạo một luồng mới cho âm thanh
        Thread soundThread = new Thread(() -> {
            try {
                playMusic.run();
            } catch (Exception e) {
                e.printStackTrace();
            }    
        });

        soundThread.start();

        // Tạo và hiển thị giao diện trực tiếp trong luồng chính
        SwingUtilities.invokeLater(() -> {
            SnakeGameGUI gui = new SnakeGameGUI();
            gui.setVisible(true);
        });
    
    }
}