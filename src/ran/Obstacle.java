package ran;
import java.util.ArrayList;

public class Obstacle {
    private int[][] map;

    public Obstacle(int[][] map) {
        this.map = map;
    }

    public void addObstacle(int x, int y) {
        map[x][y] = 4; // Set obstacle at position (x, y)
    }

    public void createObstacle1() {
        // Create a pattern of obstacles (example: U shape)
        for (int i = 5; i < 10; i++) {
            addObstacle(5, i);
            addObstacle(i, 5);
        }

        for (int i = 20; i > 15; i--) {
            addObstacle(5, i);
            addObstacle(i, 5);
        }
    }

    public void createObstacle2() {
        // Create another pattern of obstacles (example: diagonal line)
        for( int i= 0 ; i < 10; i++) {
            addObstacle(i , 7);
        }
        for(int i = 1 ; i < 15 ; i++) {
            addObstacle(i , 20);

        }
        for ( int i = 0 ; i < 8 ; i++) {
            addObstacle(12 , i);

        }
        
        for( int i= 0 ; i < 22; i++) {
            addObstacle(17 , i);
        }
        addObstacle(24 , 0);
        addObstacle(23 , 0);
        addObstacle( 0,24);
        addObstacle(0,23);

    }
    
    public void createObstacle0() {
//    	for (int i = 0 ; i < 25 ; i++) {
//    		for(int j = 0 ; j < 25; j++) {
//                addObstacle(j, i);
//    		}
//    	}
    }
    
    public void createObstacle3() {
    	for( int i = 5 ; i <= 20 ; i ++) {
			addObstacle(20,i);
    		for( int j = 5 ; j <= 25 ; j +=5) {
    			addObstacle(i,j);
    		}
    	}
    	
    }

    public void createObstacle(int pattern) {
        // Dispatch to the appropriate method based on pattern
        switch (pattern) {
            case 0 :
            	createObstacle0();
            	break;
            case 1:
                createObstacle1();
                break;
            case 2:
                createObstacle2();
                break;
            case 3:
            	createObstacle3();
                break;
            default:
                System.out.println("Invalid pattern number.");
                break;
        }
    }
}
