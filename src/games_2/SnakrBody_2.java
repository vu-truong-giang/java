package games_2;

import java.util.ArrayList;

import games.Tile;

public class SnakrBody_2 {
	  private ArrayList<Tile_2> body;
	  public SnakrBody_2() {
	      body = new ArrayList<>();
	  }

	  public void add(Tile_2 tile) {
	      body.add(tile);
	  }
	//  
		  
		  
	  

	  public ArrayList<Tile_2> getBody() {
	      return body;
	  }
	  
	  
	}
