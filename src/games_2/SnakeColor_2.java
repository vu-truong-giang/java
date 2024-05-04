package games_2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SnakeColor_2 {
    private SnakeHaed_2 snakeHaed_2;
    private SnakrBody_2 snakrBody_2;
    private Food_2 food_2;
    private int tileSize;
    private Image headImg;
    private Image bodyImg;
    private Image foodImg;
    
    
    public SnakeColor_2(SnakeHaed_2 snakeHaed_2, SnakrBody_2 snakrBody_2, Food_2 food_2, int tileSize, Image headImg,
			Image bodyImg, Image foodImg) {
    	
		this.snakeHaed_2 = snakeHaed_2;
		this.snakrBody_2 = snakrBody_2;
		this.food_2 = food_2;
		this.tileSize = tileSize;
		this.headImg = headImg;
		this.bodyImg = bodyImg;
		this.foodImg = foodImg;
	}

    
	public void Snake_1(Graphics g ) {
		try {
			foodImg = ImageIO.read(getClass().getResource("/img/food.png"));
			headImg = ImageIO.read(getClass().getResource("/img/head.png"));
			bodyImg = ImageIO.read(getClass().getResource("/img/body.png"));
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		g.drawImage(headImg,snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,(ImageObserver) this);
		
		g.drawImage(foodImg,snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,(ImageObserver) this);
		 ArrayList<Tile_2> body = snakrBody_2.getBody();
	        for (Tile_2 part : body) {
	            g.drawImage(bodyImg,part.x * tileSize, part.y * tileSize, tileSize, tileSize,(ImageObserver) this);
	        }
		
	}





	
    
}
