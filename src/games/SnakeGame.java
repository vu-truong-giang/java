package games;

import java.awt.*;


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
    int speed[] = {500,400,300,200,300,100};
    private JComboBox lv = new JComboBox();
    private JButton newGame_bt;

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
        gameOver = false;
		//game timer
        
        Level level = new Level(speed);
        level.start();
		gameLoop = new Timer(level.getCurrentLevel(),this); 
        gameLoop.start();
        
        JButton level_bt = new JButton("Level "+ (level.getCurrentLevel()));
        level_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				level.nextLevel();
				gameLoop.setDelay(level.getCurrentSpeed());
				level_bt.setText("Level " + (level.getCurrentLevel()));
			}
		});
        JPanel level_pn = new JPanel();
        level_pn.add(level_bt);
        add(level_pn, BorderLayout.SOUTH);
        
        
        
        newGame_bt = new JButton("New Game");
        newGame_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetGame();
			}
		});
        
        int currentLevel = 0;
        int score =0;
        
        
        
        
        newGame_bt.addKeyListener(this);
        newGame_bt.setFont(new Font("UTM Micra",1,15));
        newGame_bt.setBackground(Color.white);
        add(newGame_bt);
        
        
        
        
       
	}	
    
	int[] soreMu = {1,2,3,4,5};
    int currentLevel = 0;
    int currentScore =0;
    
    int scoreMu = levelScore[currentLevel];
    
    
    
    public int currentScore () {
    	int baseScore = snakeBody.getBody().size();
    	int scoreMu = levelScore[currentLevel];
    	
		return (int)(baseScore*scoreMu);
    }
    
    private void resetGame() {
    	snakeHead = new SnakeHead(5, 5);
    	snakeBody = new SnakeBody();
    	food = new Food(10, 10);
    	gameOver = false;
    	
    	gameLoop.restart();
    }
    
    
    
    
    

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
        //Grid Lines
//        for(int i = 0; i < boardWidth/tileSize; i++) {
//            //(x1, y1, x2, y2)
//            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
//            g.drawLine(0, i*tileSize, boardWidth, i*tileSize); 
//        }
		for (int row = 0; row < boardHeight - 2 / tileSize; row++) {
            for (int col = 0; col < boardWidth - 2 / tileSize; col++) {
                // Tính toán tọa độ x và y của ô
                int x = col * tileSize  ;
                int y = row * tileSize ;

                // Tô màu cho ô
                if (row ==0 || col ==0 || col == boardHeight/tileSize -1 || row == boardWidth/tileSize -1) { // Tô màu xen kẽ
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, tileSize, tileSize);
            }
        }

        //Food
        g.setColor(Color.red);
        
        g.fill3DRect(food.x*tileSize-1, food.y*tileSize-1, tileSize, tileSize, true);

        //Snake Head
        g.setColor(Color.blue);
        
        g.fill3DRect(snakeHead.x*tileSize, snakeHead.y*tileSize, tileSize, tileSize, true);

        
        g.setColor(Color.green);
        ArrayList<Tile> body = snakeBody.getBody();
        for(Tile part : body) {
        	g.fillRect(part.x * tileSize, part.y * tileSize, tileSize, tileSize);
        }
       
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
        	g.setColor(Color.black);
            g.drawString("Score: " + currentScore(), tileSize - 16, tileSize);
            
        }
	}
	
	
	
	
	

	
private String calculateScore() {
		// TODO Auto-generated method stub
		return null;
	}

//	

    
private boolean isFoodOnSnake(int x, int y) {
    ArrayList<Tile> body = snakeBody.getBody();
    for (Tile part : body) {
        if (part.x == x && part.y == y) {
            return true; // Thức ăn nằm trên thân rắn
        }
    }
    return false; // Thức ăn không nằm trên thân rắn
}

private void placeFood(int maxWidth, int maxHeight, int tileSize) {
    Random random = new Random();
    int x, y;
    do {
        x = random.nextInt(maxWidth - 2) + 1; // Ngẫu nhiên vị trí x trong khoảng từ 1 đến maxWidth - 2
        y = random.nextInt(maxHeight - 2) + 1; // Ngẫu nhiên vị trí y trong khoảng từ 1 đến maxHeight - 2
    } while (isFoodOnSnake(x, y)); // Kiểm tra xem vị trí mới có trùng với thân rắn không

    // Đặt thức ăn vào vị trí mới
    food.x = x;
    food.y = y;
}
    
private void checkFood() {
    if (snakeHead.x == food.x && snakeHead.y == food.y) {
        snakeBody.add(new Tile(food.x, food.y));
        placeFood(boardWidth / tileSize, boardHeight / tileSize, tileSize);
    }
}

//		if(collision(snakeHead, food)) {
//			snakeBody.add(new Tile(food.x, food.y));
//			food.placeFood(boardWidth, boardHeight, tileSize);
//		}
    
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

        if (snakeHead.x < 1 || snakeHead.x >= (boardWidth / tileSize)-1 ||
            snakeHead.y < 1 || snakeHead.y >= (boardHeight / tileSize)-1) {
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
        
    }  

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
