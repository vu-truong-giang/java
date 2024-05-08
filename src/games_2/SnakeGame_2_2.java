package games_2;


import javax.imageio.ImageIO ;


import javax.swing.*;
import games.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame_2_2 extends JPanel implements ActionListener, KeyListener {
    private SnakeHaed_2 snakeHead;
    private SnakrBody_2 snakeBody;
    private Food_2 food;
    private int tileSize = 25;
    private int boardWidth;
    private int boardHeight;
    private Timer gameLoop;
    private boolean gameOver;
    private int delay = 300;
    private int speed = 1;
    private int timeElapsed = 0;
    private int scoreMultiplier = 1;
    private int speedIncreaseInterval = 5000;
    private int score = 0;
    private int speedIncreaseFactor = 10;
    private Image foodImg;
    private Image headImg;
    private Image bodyImg;
    private Map_2 map;
    private SnakeColor_2 snakeColor;
    private test test;
    private JButton start_Button;
    
    

    public SnakeGame_2_2(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
       // this.maxXY = Math.max(boardWidth, boardHeight)/ tileSize;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        
        

        snakeHead = new SnakeHaed_2(5, 5);
        snakeBody = new SnakrBody_2();
        food = new Food_2(10, 10);
        map = new Map_2(tileSize);
        //snakeColor = new SnakeColor_2(snakeHead, snakeBody, food, boardHeight, headImg, bodyImg, foodImg)
        snakeColor = new SnakeColor_2(snakeHead, snakeBody, food, tileSize);
        
        gameOver = false;
        

        gameLoop = new Timer(delay, this);
        //gameLoop.start();
        
        
        start_Button = new JButton("Start");
        start_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetGame();
				start_Button.setVisible(false);
			}
		});
        start_Button.addKeyListener(this);
        start_Button.setFont(new Font("UTM Micra",1,15));
        start_Button.setBackground(Color.white);
        add(start_Button);
    }
    public void resetGame() {
    	snakeHead = new SnakeHaed_2(5, 5);
    	snakeBody = new SnakrBody_2();
    	food = new Food_2(10, 10);
    	map = new Map_2(tileSize);
    	snakeColor = new SnakeColor_2(snakeHead, snakeBody, food, tileSize);
    	gameOver = false;
    	gameLoop.restart();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
    	
    	
//    	
    //	map.drawMap(g, 600, 600);
         map.drawMap_2(g, 600, 600);
     //	map.drawMap_3(g, 600, 600);
  //   	snakeColor.draw(g);
        snakeColor.draw_2(g);
  	//   snakeColor.draw_3(g);
//    	snakeColor.draw_4(g);
    	
//    	
//    	

        // Vẽ điểm số
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
        	g.setColor(Color.red);
            g.drawString("Game Over: " + score, tileSize - 16, tileSize);
        } else {
        	g.setColor(Color.red);
            g.drawString("Score: " + score, tileSize - 16, tileSize);
        }
    }

    
    int calculateScore() {
    	int snakeLength = snakeBody.getBody().size();
    	int score = snakeLength * scoreMultiplier;
    	return score;
    }
    private void updateScore() {
    	if(timeElapsed % speedIncreaseInterval == 0) {
    		delay -= speedIncreaseFactor;
    		gameLoop.setDelay(delay);
    		scoreMultiplier++;
    	}
    	score = snakeBody.getBody().size() * scoreMultiplier;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && snakeHead.velocityX != 1) {
            snakeHead.velocityX = -1;
            snakeHead.velocityY = 0;
        } else if (key == KeyEvent.VK_RIGHT && snakeHead.velocityX != -1) {
            snakeHead.velocityX = 1;
            snakeHead.velocityY = 0;
        } else if (key == KeyEvent.VK_UP && snakeHead.velocityY != 1) {
            snakeHead.velocityX = 0;
            snakeHead.velocityY = -1;
        } else if (key == KeyEvent.VK_DOWN && snakeHead.velocityY != -1) {
            snakeHead.velocityX = 0;
            snakeHead.velocityY = 1;
        }
    }

    private void checkFood() {
        if (snakeHead.x == food.x && snakeHead.y == food.y) {
            snakeBody.add(new Tile_2(food.x, food.y));
            map.drawMap_2(getGraphics(), 600, 600);
            food.placeFood_2(boardWidth, boardHeight, tileSize,map);
            moveBody();
            
        }
    }
    
    // di chuyển
    public void moveBody() {
		for(int i = snakeBody.getBody().size()-1; i>=0; i--) {
			Tile_2 snakePart = snakeBody.getBody().get(i);
			if(i==0) {
				snakePart.x = snakeHead.x;
				snakePart.y = snakeHead.y;
			}else {
				Tile_2 prevSnakePart = snakeBody.getBody().get(i-1);
				snakePart.x = prevSnakePart.x;
				snakePart.y = prevSnakePart.y;
			}
		}
    	
		
	}
    
    public boolean collision(SnakeHaed_2 snakeHead2, Food_2 food2) {
        return snakeHead2.x == food2.x && snakeHead2.y == food2.y;
    }
    
    
    // va chạm
    private void checkCollision() {
        ArrayList<Tile_2> body = snakeBody.getBody();
        for (Tile_2 part : body) {
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
 

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    
    public void actionPerformed(ActionEvent e) {
    	timeElapsed += delay;
    	
    	updateScore();
    	if(timeElapsed % 5000 == 0){
    		speed++;
    		delay = delay / speed;
    		gameLoop.setDelay(delay);
    	}
        if (!gameOver) {
            checkFood();
            moveBody();
            snakeHead.move();
            checkCollision();
            repaint();
        }else if(gameOver){
        	gameLoop.stop();
        	SwingUtilities.invokeLater(()-> new Game_Over_2_2(this));// chuyển sang Game_Over
        	
        }
        
    }
}

