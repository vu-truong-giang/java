package games;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import games_2.Tile_2;

public class SnakeColor{
	private SnakeHead snakeHead;
	private SnakeBody snakeBody;
	private Food food;
	private int tileSize;
	private Image headImg;
	private Image bodyImg;
	private Image foodImg;
	
	
	public SnakeColor(SnakeHead snakeHead, SnakeBody snakeBody, Food food, int tileSize, Image headImg, Image bodyImg,
			Image foodImg) {
	
		this.snakeHead = snakeHead;
		this.snakeBody = snakeBody;
		this.food = food;
		this.tileSize = tileSize;
		this.headImg = headImg;
		this.bodyImg = bodyImg;
		this.foodImg = foodImg;
	}


	public void draw(Graphics g) {
		try {
			headImg = ImageIO.read(getClass().getResource("/img/head.png"));
            bodyImg = ImageIO.read(getClass().getResource("/img/body.png"));
            foodImg = ImageIO.read(getClass().getResource("/img/food.png"));
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("Error loading images: " + e.getMessage());
		}
		g.drawImage(headImg, snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize,
                (ImageObserver) null);
		g.drawImage(foodImg, food.x * tileSize, food.y * tileSize, tileSize, tileSize, (ImageObserver) null);
		
		ArrayList<Tile> body = snakeBody.getBody();
        for (Tile part : body) {
            g.drawImage(bodyImg, part.x * tileSize, part.y * tileSize, tileSize, tileSize,
                    (ImageObserver) null);
        }
	}
	
	
	
	
}
