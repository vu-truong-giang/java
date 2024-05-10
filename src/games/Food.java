package games;

import java.util.Random;

public class Food {
     int x;
     int y;
   //boolean isBigFood;
     
//	public Food(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
     
//     public void placeBigFood(int boardWidth, int boardHeight, int tileSize, Map map) {
//         // Tạo ngẫu nhiên vị trí cho mồi to
//         Random random = new Random();
//         x = random.nextInt(boardWidth - 3) + 1; // Trừ đi 3 để không vượt ra khỏi biên
//         y = random.nextInt(boardHeight - 3) + 1;
//         isBigFood = true;
//     }
//     public boolean isBigFood() {
//         return isBigFood;
//     }
     public Food(int x, int y ) {
 	
 		this.x = x;
 		this.y = y;
 		//this.isBigFood = isBigFood;
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

