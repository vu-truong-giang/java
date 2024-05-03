package games;

import java.awt.Color;
import java.awt.Graphics;

public class Map {
   private int tileSize;
   
   
   public Map(int tileSize) {
	   this.tileSize = tileSize;
   }
   public void drawMap(Graphics g, int boarWidth, int boarHeight) {
	   for(int row = 0; row < boarHeight/ tileSize; row++) {
		   for(int col = 0; col < boarWidth/ tileSize; col++) {
			   int x = col * tileSize;
			   int y = row * tileSize;
			   
			   if(row == 0 || col == 0 || col == boarHeight/tileSize-1 || row == boarWidth/tileSize -1) {
				   g.setColor(Color.white);
			   }else {
				   g.setColor(Color.black);
			   }
			   g.fillRect(x, y, tileSize, tileSize);
		   }
	   }
   }
}
