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

public class SnakeGame_2 extends JPanel implements ActionListener, KeyListener {
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
    

    public SnakeGame_2(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
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
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
    	
    	map.drawMap(g, 600, 600);
    	
    	snakeColor.draw_4(g);
//    	
//    	try {
//			foodImg = ImageIO.read(getClass().getResource("/img/food.png"));
//			headImg = ImageIO.read(getClass().getResource("/img/head.png"));
//			bodyImg = ImageIO.read(getClass().getResource("/img/body.png"));
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//    	
//    	
//        g.drawImage(headImg,snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize,this);
//
//        // Vẽ thức ăn
//        g.drawImage(foodImg, food.x * tileSize, food.y * tileSize, tileSize, tileSize, this);
//
//        // Vẽ mảng các phần của rắn
//        //g.setColor(Color.green);
//        ArrayList<Tile_2> body = snakeBody.getBody();
//        for (Tile_2 part : body) {
//            g.drawImage(bodyImg,part.x * tileSize, part.y * tileSize, tileSize, tileSize,this);
//        }

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
        	SwingUtilities.invokeLater(()-> new Game_Over_2(this));// chuyển sang Game_Over
        	
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
            food.placeFood(boardWidth, boardHeight, tileSize);
            moveBody();
            
            
        }
    }
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

    private void checkCollision() {
        ArrayList<Tile_2> body = snakeBody.getBody();
        for (Tile_2 part : body) {
            if (part.x == snakeHead.x && part.y == snakeHead.y) {
                gameOver = true;
                return;
            }
        }

        if (snakeHead.x - 2 < 0 || snakeHead.x >= boardWidth / tileSize - 2 ||
            snakeHead.y - 2 < 0 || snakeHead.y >= boardHeight / tileSize - 2) {
            gameOver = true;
        }
    }
//    private void updateScore() {
//        int currentScore = snakeBody.getBody().size() * scoreMultiplier;
//        // Tăng hệ số nhân cho điểm số
//        scoreMultiplier++;
//        // Cập nhật lại điểm số hiển thị
//        System.out.println("Score: " + currentScore);
//    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
