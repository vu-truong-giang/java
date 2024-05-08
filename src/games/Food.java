package games;

import java.util.Random;

public class Food {
     int x;
     int y;
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void placeFood(int boarWidth, int boarHeight, int tileSize, Map map) {
		Random random = new Random();
		x = random.nextInt((boarWidth / tileSize) -2)+1;
		y = random.nextInt((boarHeight / tileSize) -2)+1;
		
		
	}
	void placeFood_2(int boarWidth, int boarHeight, int tileSize, Map map) {
		Random random = new Random();
		
		int maxX = boarWidth / tileSize -1;
		int maxY = boarHeight / tileSize - 1;
		do {
			x = random.nextInt(maxX) + 1;
			y = random.nextInt(maxY) + 1;
		}while(y == 3 || y == 8 || y == 13);
			
	}
	void placeFood_3(int boarWidth, int boarHeight, int tileSize, Map map) {
		Random random = new Random();
		
		int maxX = boarWidth / tileSize -1;
		int maxY = boarHeight / tileSize - 1;
		do {
			x = random.nextInt(maxX) + 1;
			y = random.nextInt(maxY) + 1;
		}while(x == 3 || x == 8 || x == 13);
			
	}
	
	
     
}

