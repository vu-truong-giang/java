package games;

import java.util.ArrayList;

public class SnakeBody {
  private ArrayList<Tile> body;
  public SnakeBody() {
      body = new ArrayList<>();
  }

  public void add(Tile tile) {
      body.add(tile);
  }
//  
	  
	  
  

  public ArrayList<Tile> getBody() {
      return body;
  }
  
  
}

