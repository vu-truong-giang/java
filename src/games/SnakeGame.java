package games;

import java.awt.*; 

import javax.imageio.ImageIO ;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    
    private SnakeHead snakeHead;
    private SnakeBody snakeBody;
    private Food food;
    int boardWidth;
    int boardHeight;
    int tileSize = 25;
    private Timer gameLoop;
    private boolean gameOver;
    int levelScore[] = {1,2,3,4,5,6,7,8,9,10};
    int levelMultiplier =0;
    int speed[] = {500,450,400,350,300,250,200,150,100,50};
    //private int score = 0;
    private Level level;
    private JComboBox lv = new JComboBox();
    private JButton newGame_bt;
    private Game_Over game_Over;
    private Image foodImg;
    private Image headImg;
    private Image bodyImg;
    private Map map;
    private SnakeColor snakeColor;
    

    //snake
    private JPanel pn;
    Container cn;
    Timer timer;
    
       
    
    public SnakeGame(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead = new SnakeHead(5,5);
        snakeBody = new SnakeBody();
        food = new Food(10,10);
        map = new Map(tileSize);
        snakeColor = new SnakeColor(snakeHead, snakeBody, food, tileSize, headImg, bodyImg, foodImg);
        gameOver = false;
        
		//game timer
        
        Level level = new Level(speed);
        level.start();
		gameLoop = new Timer(level.getCurrentLevel(),this); 
        //gameLoop.start();// bắt đầu trò chơi
        
        
        
        JButton level_bt = new JButton("Level "+ (level.getCurrentLevel()+1));
        level_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				level.nextLevel();
				
				gameLoop.setDelay(level.getCurrentSpeed());

				level_bt.setText("Level " + (level.getCurrentLevel()+1));
				
			}
		});
        JPanel level_pn = new JPanel(new BorderLayout());
        level_pn.add(level_bt, BorderLayout.NORTH);
        add(level_pn, BorderLayout.NORTH);
        
        
        
        newGame_bt = new JButton("Start");
        newGame_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetGame();
				newGame_bt.setVisible(false);
				level_bt.setVisible(false);
			}
		});
        
//        int currentLevel = 0;
//        int score =0;
        
        
        
        
        newGame_bt.addKeyListener(this);
        newGame_bt.setFont(new Font("UTM Micra",1,15));
        newGame_bt.setBackground(Color.white);
        add(newGame_bt);
        
        
        
        
        
       
	}	
    
//	int[] soreMu = {1,2,3,4,5,6,7,8,9,10};
//    int currentLevel = 1;
//    int currentScore =0;
//    
//    int scoreMu = levelScore[currentLevel];
    
    
    
   
    
    private void resetGame() {
    	snakeHead = new SnakeHead(5, 5);
    	snakeBody = new SnakeBody();
    	food = new Food(10, 10);
    	map = new Map(tileSize);
        snakeColor = new SnakeColor(snakeHead, snakeBody, food, tileSize, headImg, bodyImg, foodImg);
    	gameOver = false;
    	gameLoop.restart();;
    }
    
    
    
    
    
    

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		//map
		map.drawMap(g, 600, 600);
		// color
		snakeColor.draw(g);
		

      
        //Score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over: " + currentScore(), tileSize - 16, tileSize);

        }
        
        else {
        	g.setColor(Color.red);
        	
            g.drawString("Score: " + currentScore(), tileSize - 16, tileSize);
            
        }
	}
	  int currentScore () {

		     Level level = new Level(speed);
		    levelMultiplier = levelScore[level.getCurrentLevel()];
		    int baseScore = snakeBody.getBody().size();
		    
		    // Tính điểm dựa trên hệ số của level
		    int score = baseScore * levelMultiplier;
		    return score;
	    	
	    	
	    }
	

//	

    
    
    
	private void checkFood() {
        if (snakeHead.x == food.x && snakeHead.y == food.y) {
            snakeBody.add(new Tile(food.x, food.y));
            food.placeFood(boardWidth, boardHeight, tileSize,map);
        }
		
    }
	public void moveBody() {
		for(int i = snakeBody.getBody().size()-1; i>=0; i--) {
			Tile snakePart = snakeBody.getBody().get(i);
			if(i==0) {
				snakePart.x = snakeHead.x;
				snakePart.y = snakeHead.y;
			}else {
				Tile prevSnakePart = snakeBody.getBody().get(i-1);
				snakePart.x = prevSnakePart.x;
				snakePart.y = prevSnakePart.y;
			}
		}
		
	}
	public boolean collision(SnakeHead snakeHead2, Food food2) {
        return snakeHead2.x == food2.x && snakeHead2.y == food2.y;
    }
	private void checkCollision() {
        ArrayList<Tile> body = snakeBody.getBody();
        for (Tile part : body) {
            if (part.x == snakeHead.x && part.y == snakeHead.y) {
                gameOver = true;
                return;
            }
        }

        if (snakeHead.x -2 < 0 || snakeHead.x >= boardWidth / tileSize -2 ||
            snakeHead.y -2 < 0 || snakeHead.y >= boardHeight / tileSize -2) {
            gameOver = true;
        }
        
    }
	

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver) {
        	checkFood();
        	moveBody();
        	snakeHead.move();
        	checkCollision();
        	repaint();
        }
        else if(gameOver){
        	gameLoop.stop();
        	SwingUtilities.invokeLater(()-> new Game_Over(this));// chuyển sang Game_Over
        	
        }
    }
//        

    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println("KeyEvent: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP && snakeHead.velocityY != 1) {
            snakeHead.velocityX = 0;
            snakeHead.velocityY = -1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && snakeHead.velocityY != -1) {
        	snakeHead.velocityX = 0;
        	snakeHead.velocityY = 1;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && snakeHead.velocityX != 1) {
        	snakeHead.velocityX = -1;
        	snakeHead.velocityY = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snakeHead.velocityX != -1) {
        	snakeHead.velocityX = 1;
        	snakeHead.velocityY = 0;
        }
    }

    //not needed
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
//    
}
