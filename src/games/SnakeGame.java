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
		// tạo lưới
        //Grid Lines
//        for(int i = 0; i < boardWidth/tileSize; i++) {
//            //(x1, y1, x2, y2)
//            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
//            g.drawLine(0, i*tileSize, boardWidth, i*tileSize); 
//        }
//		for (int row = 0; row < boardHeight / tileSize; row++) {
//            for (int col = 0; col < boardWidth / tileSize; col++) {
//                // Tính toán tọa độ x và y của ô
//                int x = col * tileSize;
//                int y = row * tileSize;
//
//                // Tô màu cho ô
//                if (row ==0 || col ==0 || col == boardHeight/tileSize -1 || row == boardWidth/tileSize -1) { // Tô màu xen kẽ
//                    g.setColor(Color.white);
//                } else {
//                    g.setColor(Color.BLACK);
//                }
//                g.fillRect(x, y, tileSize, tileSize);
//            }
//        }
		map.drawMap_3(g, 600, 600);
		
		snakeColor.draw(g);
		

        //Food
//        g.setColor(Color.red);
//        
//        g.fill3DRect(food.x*tileSize-1, food.y*tileSize-1, tileSize, tileSize, true);
//
//        //Snake Head
//        g.setColor(Color.blue);
//        
//        g.fill3DRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize, true);
//
//        
//        g.setColor(Color.green);
//        ArrayList<Tile> body = snakeBody.getBody();
//        for(Tile part : body) {
//        	g.fillRect(part.x * tileSize, part.y * tileSize, tileSize, tileSize);
//        }
//       
        //Score
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over: " + currentScore(), tileSize - 16, tileSize);
//              gameLoop.stop();
//              JOptionPane.showMessageDialog(null, "Bạn đã thua cuộc");
//              gameOver = true;
//              return;
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
//		if(collision(snakeHead, food)) {
//			snakeBody.add(new Tile(food.x, food.y));
//			food.placeFood(boardWidth, boardHeight, tileSize);
//		}
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
