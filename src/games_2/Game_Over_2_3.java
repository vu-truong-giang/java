package games_2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Home.*;
import TrangChu.Home;
import games.Game_Over;
import games.SnakeGame;

public class Game_Over_2_3 extends JFrame implements ActionListener {
    private JButton new_game;
    private JButton play_again;
    private JButton exit;
    private SnakeGame_2 snakeGame_2;
    private SnakeGame_2_2 snakeGame_2_2;
    private SnakeGame_2_3 snakeGame_2_3;
    
    public Game_Over_2_3 (SnakeGame_2_3 snakeGame_2_3) throws HeadlessException {
  	  this.snakeGame_2_3 = snakeGame_2_3;
  	  this.init();
  	  this.setVisible(true);
    }
    public void init() {
  	  this.setTitle("Game Over");
  	  this.setSize(300, 300);
  	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  this.setLocationRelativeTo(null);
  	  
  	  Font font = new Font("Arial", Font.BOLD, 15);
  	  
  	  setLayout(new GridLayout(3, 1, 10, 10));
  	  
  	  JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
  	  JLabel overLabel = new JLabel("GAME OVER");
  	  overLabel.setFont(font);
  	  jPanel1.add(overLabel);
  	  
  	  JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
  	  Label scoreLabel = new Label("Score:"+snakeGame_2_3.calculateScore());
  	  scoreLabel.setFont(font);
  	  scorePanel.add(scoreLabel);
  	  
  	  
  	  JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
  	  new_game = new JButton("Again");
  	  new_game.addActionListener(this);
  	  new_game.setBackground(Color.white);
  	  jPanel.add(new_game);
  	  play_again = new JButton("Home");
  	  play_again.addActionListener(this);
  	  play_again.setBackground(Color.white);
  	  jPanel.add(play_again);
  	  exit = new JButton("Exit");
  	  exit.addActionListener(this);
  	  exit.setBackground(Color.white);
  	  jPanel.add(exit);
  	  
  	  add(jPanel1);
  	  add(scorePanel);
  	  add(jPanel);
  	  
  	  
  	  
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== new_game) {
			openSnakeGame();
			pack();
			setVisible(true);
			this.dispose();
		}else if(e.getSource()== exit) {
			System.exit(0);
		}else if(e.getSource()== play_again) {
			openHome();
			pack();
			setVisible(true);
			this.dispose();
		}
		
		
			
		
	}
	private void openHome() {
		SnakeGameGUI snakeGameGUI = new SnakeGameGUI();
		JFrame homeFrame = new JFrame("Home");
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.getContentPane().add(snakeGameGUI);// add class snakeGame vào
		homeFrame.pack();
		homeFrame.setLocationRelativeTo(null);
		homeFrame.requestFocus();
		homeFrame.setVisible(true);
	}
	private void openSnakeGame() {
      // Tạo một đối tượng của lớp SnakeGame
      SnakeGame_2 snakeGame_2 = new SnakeGame_2(600, 600);

      // Hiển thị trò chơi
      JFrame gameFrame = new JFrame("Snake Game");
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
				SnakeGame_2_3 snakGame_2_3 = new SnakeGame_2_3(600, 600);
			
				//Home home = new Home();
				Game_Over_2_3 game_Over = new Game_Over_2_3(snakGame_2_3);
				
			}
		});
	}
}

