package games;

import java.awt.*; 

import javax.imageio.ImageIO ;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame2 extends JPanel implements ActionListener, KeyListener {
    
    private SnakeHead snakeHead;
    private SnakeBody snakeBody;
    private Food food;
    int boardWidth;
    int boardHeight;
    int tileSize = 25;
    private Timer gameLoop;
    private boolean gameOver;
    int levelScore[] = {1,2,3,4,5};
    int speed[] = {500,450,400,350,300,250,200,150,100,50};
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
    
       
    
    public SnakeGame2(int boardWidth, int boardHeight) {
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
			}
		});
        
//        int currentLevel = 0;
//        int score =0;
        
        
        
        
        newGame_bt.addKeyListener(this);
        newGame_bt.setFont(new Font("UTM Micra",1,15));
        newGame_bt.setBackground(Color.white);
        add(newGame_bt);
        
        
        
        
        
       
	}	
    
	//int[] soreMu = {1,2,3,4,5};
    int currentLevel = 1;
    int currentScore =0;
    
    int scoreMu = levelScore[currentLevel];
    
    
    
    public int currentScore () {
    	int baseScore = snakeBody.getBody().size();
//    	int scoreMu = levelScore[currentLevel];
//    	
//		return (int)(baseScore*scoreMu);
    	int scoreMu = 1;
    	if(currentLevel==1) {
    		scoreMu = 1;
    	}else if(currentLevel == 2) {
    		scoreMu = 2;
    	}else if(currentLevel == 3) {
    		scoreMu = 3;
    	}else if(currentLevel == 4) {
    		scoreMu = 4;
    	}else if(currentLevel == 5) {
    		scoreMu = 5;
    	}
    	return(int) baseScore * scoreMu;
    }
    
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
		map.drawMap_2(g, 600, 600);
		// color
		snakeColor.draw_2(g);
		

      
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
	

//	

    
    
    
	private void checkFood() {
        if (snakeHead.x == food.x && snakeHead.y == food.y) {
            snakeBody.add(new Tile(food.x, food.y));
            food.placeFood(boardWidth, boardHeight, tileSize);
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


        if(isWhiteTile_2(snakeHead.x, snakeHead.y)) {
        	map.drawMap_2(getGraphics(), 600, 600);
        	gameOver = true;
        	return;
        }
        
	}
        
     // chạm chướng ngại vật bản đồ 2
        int [][] whiteTiles_2 = {
        		{1,2},{2,2},{3,2},{7,2},{8,2},{9,2},{10,2},{11,2},{12,2},{13,2},{14,2},{15,2},{16,2},{17,2},{18,2},{19,2},{20,2},{21,2},{22,2},
        		{1,4},{2,4},{3,4},{7,4},{8,4},{9,4},{10,4},{11,4},{12,4},{13,4},{14,4},{15,4},{16,4},{17,4},{18,4},{19,4},{20,4},{21,4},{22,4},
        		{1,7},{2,7},{3,7},{7,7},{8,7},{9,7},{10,7},{11,7},{12,7},{13,7},{14,7},{15,7},{16,7},{17,7},{18,7},{19,7},{20,7},{21,7},{22,7},
        		{1,9},{2,9},{3,9},{7,9},{8,9},{9,9},{10,9},{11,9},{12,9},{13,9},{14,9},{15,9},{16,9},{17,9},{18,9},{19,9},{20,9},{21,9},{22,9},
        		{1,12},{2,12},{3,12},{4,12},{5,12},{8,12},{9,12},{10,12},{11,12},{12,12},{13,12},{14,12},{15,12},{16,12},{17,12},{18,12},{19,12},{20,12},{21,12},{22,12},
        		{1,14},{2,14},{3,14},{4,14},{5,14},{8,14},{9,14},{10,14},{11,14},{12,14},{13,14},{14,14},{15,14},{16,14},{17,14},{18,14},{19,14},{20,14},{21,14},{22,14},
        		};
        private boolean isWhiteTile_2(int x, int y) {
        	for(int i = 0; i<whiteTiles_2.length; i++) {
        		int whiteTileX = whiteTiles_2[i][0];
        		int whiteTileY = whiteTiles_2[i][1];
        		if(x== whiteTileX && y==whiteTileY) {
        			return true;
        		}
        	}
        	return false;
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
        	SwingUtilities.invokeLater(()-> new Game_Over2(this));// chuyển sang Game_Over
        	
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
