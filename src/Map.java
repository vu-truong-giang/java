import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JPanel {
	 private class Tile {
	        int x;
	        int y;

	        Tile(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }  
	 
	    int boardWidth;
	    int boardHeight;
	    int tileSize = 25;
	    
	    
	    Map(int boardWidth, int boardHeight){
	    	this.boardWidth = boardWidth;
	        this.boardHeight = boardHeight;
	        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
	        setBackground(Color.black);
	    }
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	    	draw(g);
	    }
	    public void draw(Graphics g) {
	    	// Grid
//	    	for(int i=0; i<boardWidth/tileSize; i++) {
//	    		g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
//	    		g.drawLine(0, i*tileSize, boardWidth, i*tileSize);
//	    	}
	    	// Map
	    	for (int row = 0; row < boardHeight / tileSize; row++) {
	            for (int col = 0; col < boardWidth / tileSize; col++) {
	                // Tính toán tọa độ x và y của ô
	                int x = col * tileSize;
	                int y = row * tileSize;

	                // Tô màu cho ô
	                if (row ==3 || col ==0 || col == boardHeight/tileSize -5 || row == boardWidth/tileSize -1) { // Tô màu xen kẽ
	                    g.setColor(Color.white);
	                } else {
	                    g.setColor(Color.BLACK);
	                }
	                g.fillRect(x, y, tileSize, tileSize);
	            }
	        }
	    	
	    }
}
