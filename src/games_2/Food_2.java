package games_2;

import java.util.Random;

import games.Map;

public class Food_2 {
    int x;
    int y;
    Map map;
	public Food_2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void placeFood_2(int boarWidth, int boarHeight, int tileSize , Map_2 map2) {
		Random random = new Random();
//		x = random.nextInt((boarWidth / tileSize) -2)+1;
//		y = random.nextInt((boarHeight / tileSize) -2)+1;
		int maxX = boarWidth / tileSize - 1;
		int maxY = boarHeight / tileSize - 1;
		
		do {
			x = random.nextInt(maxX) + 1;
			y = random.nextInt(maxY) + 1;
		}while( y == 3 || y == 8 || y == 13);
		
	}
	void placeFood(int boarWidth, int boarHeight, int tileSize, Map_2 map2) {
		Random random = new Random();
		x = random.nextInt((boarWidth / tileSize) -2)+1;
		y = random.nextInt((boarHeight / tileSize) -2)+1;
	}
	
	void placeFood_3(int boarWidth, int boarHeight, int tileSize, Map_2 map2) {
		Random random = new Random();
//		x = random.nextInt((boarWidth / tileSize) -2)+1;
//		y = random.nextInt((boarHeight / tileSize) -2)+1;
		int maxX = boarWidth / tileSize - 1;
		int maxY = boarHeight / tileSize - 1;
		
		do {
			x = random.nextInt(maxX) + 1;
			y = random.nextInt(maxY) + 1;
		}while( x == 3 || x == 8 || x == 13);
		
	}
    
}
