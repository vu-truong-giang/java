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

    public SnakeColor_2(SnakeHaed_2 snakeHaed_2, SnakrBody_2 snakrBody_2, Food_2 food_2, int tileSize) {
        this.snakeHaed_2 = snakeHaed_2;
        this.snakrBody_2 = snakrBody_2;
        this.food_2 = food_2;
        this.tileSize = tileSize;
//        loadImages();
//        loadImages_2();
//        loadImages_3();
    }
    
    public void draw(Graphics g) {
    	try {
            headImg = ImageIO.read(getClass().getResource("/img/head.png"));
            bodyImg = ImageIO.read(getClass().getResource("/img/body.png"));
            foodImg = ImageIO.read(getClass().getResource("/img/food.png"));
        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    	 g.drawImage(headImg, snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,
                 (ImageObserver) null);
    	 g.drawImage(foodImg, food_2.x * tileSize, food_2.y * tileSize, tileSize, tileSize, (ImageObserver) null);
    	 
    	 ArrayList<Tile_2> body = snakrBody_2.getBody();
         for (Tile_2 part : body) {
             g.drawImage(bodyImg, part.x * tileSize, part.y * tileSize, tileSize, tileSize,
                     (ImageObserver) null);
         }
    	
    }
    
    public void draw_2(Graphics g) {
    	try {
            headImg = ImageIO.read(getClass().getResource("/img/head_2.png"));
            bodyImg = ImageIO.read(getClass().getResource("/img/body_2.png"));
            foodImg = ImageIO.read(getClass().getResource("/img/food_2.png"));
        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    	 g.drawImage(headImg, snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,
                 (ImageObserver) null);
    	 g.drawImage(foodImg, food_2.x * tileSize, food_2.y * tileSize, tileSize, tileSize, (ImageObserver) null);
    	 
    	 ArrayList<Tile_2> body = snakrBody_2.getBody();
         for (Tile_2 part : body) {
             g.drawImage(bodyImg, part.x * tileSize, part.y * tileSize, tileSize, tileSize,
                     (ImageObserver) null);
         }
    	
    }
    public void draw_3(Graphics g) {
    	try {
            headImg = ImageIO.read(getClass().getResource("/img/head_3.png"));
            bodyImg = ImageIO.read(getClass().getResource("/img/body_3.png"));
            foodImg = ImageIO.read(getClass().getResource("/img/food_3.png"));
        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    	 g.drawImage(headImg, snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,
                 (ImageObserver) null);
    	 g.drawImage(foodImg, food_2.x * tileSize, food_2.y * tileSize, tileSize, tileSize, (ImageObserver) null);
    	 
    	 ArrayList<Tile_2> body = snakrBody_2.getBody();
         for (Tile_2 part : body) {
             g.drawImage(bodyImg, part.x * tileSize, part.y * tileSize, tileSize, tileSize,
                     (ImageObserver) null);
         }
    	
    }
    public void draw_4(Graphics g) {
    	try {
            headImg = ImageIO.read(getClass().getResource("/img/head_4.png"));
            bodyImg = ImageIO.read(getClass().getResource("/img/body_4.png"));
            foodImg = ImageIO.read(getClass().getResource("/img/food_4.png"));
        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    	 g.drawImage(headImg, snakeHaed_2.x * tileSize, snakeHaed_2.y * tileSize, tileSize, tileSize,
                 (ImageObserver) null);
    	 g.drawImage(foodImg, food_2.x * tileSize, food_2.y * tileSize, tileSize, tileSize, (ImageObserver) null);
    	 
    	 ArrayList<Tile_2> body = snakrBody_2.getBody();
         for (Tile_2 part : body) {
             g.drawImage(bodyImg, part.x * tileSize, part.y * tileSize, tileSize, tileSize,
                     (ImageObserver) null);
         }
    	
    }
    
    

}    