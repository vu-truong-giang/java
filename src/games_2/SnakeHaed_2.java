package games_2;

public class SnakeHaed_2{
	int x;
	int y;
	int velocityX;
	int velocityY;
	public SnakeHaed_2(int x, int y) {
		
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
