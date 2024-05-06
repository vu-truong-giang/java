package games_2;

import java.awt.Color; 
import java.awt.Graphics;

public class Map_2 {
	   private int tileSize;
//	   private int boarWidth;
//	   private int boatHeight;
	   
	   
	   public Map_2(int tileSize) {
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
	   
	   public void drawMap_2(Graphics g, int boarWidth, int boarHeight ) {
       	  for(int row = 0; row < boarHeight/tileSize; row++) {
       		  for(int col = 0; col < boarWidth/tileSize; col++) {
       			  int x = col * tileSize;
       			  int y = row * tileSize;
       			if(row == 3 || row == 8 || row == 13 ) {
       			   
					g.setColor(Color.white);
					   
					 
				   }else {
					   g.fillRect(0, 75, tileSize, tileSize);
					   g.fillRect(0, 200, tileSize, tileSize);
					   g.fillRect(0, 325, tileSize, tileSize);
					   g.fillRect(100, 75, tileSize, tileSize);
					   g.fillRect(100, 200, tileSize, tileSize);
					   g.fillRect(150, 325, tileSize, tileSize);
					   g.fillRect(125, 75, tileSize, tileSize);
					   g.fillRect(125, 200, tileSize, tileSize);
					   g.fillRect(175, 325, tileSize, tileSize);
					   g.fillRect(575 , 75, tileSize, tileSize);
					   g.fillRect(575 , 200, tileSize, tileSize);
					   g.fillRect(575 , 325, tileSize, tileSize);
					   g.setColor(Color.black);
				   }
				   g.fillRect(x, y, tileSize, tileSize);
       			  
       		  }
       	  }
       }
	   public void drawMap_3(Graphics g, int boarWidth, int boarHeight) {
		   for(int row = 0; row < boarHeight/tileSize; row++) {
	       		  for(int col = 0; col < boarWidth/tileSize; col++) {
	       			  int x = col * tileSize;
	       			  int y = row * tileSize;
	       			 if(col == 3 || col == 8 || col == 13) { 
	       				 g.setColor(Color.white);
	       			 }else {
	       				g.fillRect(75, 0, tileSize, tileSize);
	       				g.fillRect(200, 0, tileSize, tileSize);
	       				g.fillRect(325, 0, tileSize, tileSize);
	       				g.fillRect(75, 100, tileSize, tileSize);
	       				g.fillRect(200, 100, tileSize, tileSize);
	       				g.fillRect(325, 150, tileSize, tileSize);
	       				g.fillRect(75, 125, tileSize, tileSize);
	       				g.fillRect(200, 125, tileSize, tileSize);
	       				g.fillRect(325, 150, tileSize, tileSize);
	       				g.fillRect(75, 575, tileSize, tileSize);
	       				g.fillRect(200, 575, tileSize, tileSize);
	       				g.fillRect(325, 575, tileSize, tileSize);
	       				g.setColor(Color.black);
	       				 
	       			 }
	       			g.fillRect(x, y, tileSize, tileSize);
	       			  
	       			  
	       	   }
		   }
	   }
	}
        
