package games;


public class SnakeHead  {
	int x;
	int y;
	int velocityX;
	int velocityY;
	
	public SnakeHead(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.velocityX = 1;
		this.velocityY = 0;
	}
	void move() {
		x += velocityX;
		y += velocityY;
		
		
	}
	

}
