package TrangChu;
import games.*;
import games.SnakeGame;
import games.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Home  extends JFrame implements ActionListener{
    private JButton startButton;
    private JButton levelButton;
    private JButton logIn;
    private JButton signUp;
    int boarWidth = 600;
    int boarHeight = boarWidth;
    
    
    public Home() {
    	setTitle("Snake Game Home");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setPreferredSize(new Dimension(600,400));
    	
    	
    	startButton = new JButton("New Game");
    	startButton.addActionListener(this);
    	startButton.setFont(new Font("UTM Micra", 1,15));
    	startButton.setBackground(Color.white);
    	
    	
    	levelButton = new JButton("Level");
    	levelButton.addActionListener(this);
    	levelButton.setFont(new Font("UTM Micra", 1,15));
    	levelButton.setBackground(Color.white);
    	
    	logIn = new JButton(" Log In");
    	logIn.addActionListener(this);
    	logIn.setFont(new Font("UTM Micra", 1,15));
    	logIn.setBackground(Color.white);
    	
    	signUp = new JButton(" Sign Up");
    	signUp.addActionListener(this);
    	signUp.setFont(new Font("UTM Micra", 1,15));
    	signUp.setBackground(Color.white);
    	
    	JPanel panel = new JPanel(new BorderLayout());
    	JPanel topPanel = new JPanel();
    	topPanel.add(startButton);
    	topPanel.add(levelButton);
    	topPanel.add(logIn);
    	topPanel.add(signUp);
    	panel.add(topPanel, BorderLayout.NORTH);
    	
//    	JPanel centerJPanel = new JPanel();
//    	centerJPanel.setLayout(new GridLayout(4,1));
//    	centerJPanel.add(startButton);
//    	centerJPanel.add(levelButton);
//    	panel.add(centerJPanel, BorderLayout.CENTER);
    	
    	add(panel);
    	pack();
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== startButton) {
//	      
		  openSnakeGame();
		  pack();
		  setVisible(true);
		  this.dispose();
		  
		  
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
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
	}

}
