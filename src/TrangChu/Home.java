package TrangChu;
<<<<<<< HEAD

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import games.*;
=======
import games.*;  
import games_2.*;
import games_2.SnakeGame_2;
import games_2.App_2;
import games.SnakeGame;
import games.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
>>>>>>> refs/remotes/master/master

<<<<<<< HEAD
public class Home extends JFrame implements ActionListener {
    private JButton playButton; // Khai báo biến playButton ở đây
=======
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
>>>>>>> refs/remotes/master/master

<<<<<<< HEAD
=======
public class Home  extends JFrame implements ActionListener{
    private JButton startButton;
    private JButton levelButton;
    private JComboBox<String> gameOptions;
    private JButton logIn;
    private JButton signUp;
    int boarWidth = 600;
    int boarHeight = boarWidth;
    private Image backG;
    
>>>>>>> refs/remotes/master/master
    public Home() {
<<<<<<< HEAD
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
=======
    	setTitle("Snake Game Home");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setPreferredSize(new Dimension(600,400));
    	
    	
    	startButton = new JButton("Start");
    	startButton.addActionListener(this);
    	startButton.setFont(new Font("UTM Micra", 1,15));
    	startButton.setBackground(Color.white);
    	
    	
    	String[] games = {"Game 1","Game 2"};
    	gameOptions = new JComboBox<>(games);
    	gameOptions.addActionListener(this);
    	
    
    	
    	
    	logIn = new JButton(" Log In");
    	logIn.addActionListener(this);
    	logIn.setFont(new Font("UTM Micra", 1,15));
    	logIn.setBackground(Color.white);
    	
    	signUp = new JButton(" Sign Up");
    	signUp.addActionListener(this);
    	signUp.setFont(new Font("UTM Micra", 1,15));
    	signUp.setBackground(Color.white);
    	
    	
    	
    	
    	 JPanel panel = new JPanel(new BorderLayout()) {
         	@Override
         	protected void paintComponent(Graphics g) {
         		super.paintComponent(g);
         		draw(g);
         	}
         };
         
        JPanel topPanel = new JPanel(); 
    	topPanel.add(startButton);    	
    	topPanel.add(gameOptions);
    	topPanel.add(logIn);
    	topPanel.add(signUp);
    	panel.add(topPanel, BorderLayout.NORTH);
    	

    	
    	add(panel);
    	pack();
    	setLocationRelativeTo(null);
    	setVisible(true);
>>>>>>> refs/remotes/master/master
    }
<<<<<<< HEAD

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            openSnakeGame();
            dispose(); // Đóng cửa sổ hiện tại
        }
    }

    private void openSnakeGame() {
=======
        
        public void draw(Graphics g) {
        	try {
        		backG = ImageIO.read(getClass().getResource("/img/nen.png"));
        		g.drawImage(backG, 0, 0, getWidth(), getHeight(), this);
				
			} catch (IOException e) {
				// TODO: handle exception
			}
        }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()== gameOptions) {
		String selectedOption = (String) gameOptions.getSelectedItem();
		if(selectedOption.equals("Game 1")) {
			openSnakeGame();
			pack();
			this.dispose();
		}else if(selectedOption.equals("Game 2")) {
			openSnakeGame_2();
			pack();
			this.dispose();
		}
		
	}
	}
	private void openSnakeGame() {
>>>>>>> refs/remotes/master/master
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
<<<<<<< HEAD
=======
	private void openSnakeGame_2() {
		SnakeGame_2 snakeGame_2 = new SnakeGame_2(600, 600);
		JFrame gameFrame = new JFrame("Snake Game 2");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().add(snakeGame_2);// add class snakeGame vào
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
	}
>>>>>>> refs/remotes/master/master

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
