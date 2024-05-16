package ran;

import java.awt.Color;

import javax.swing.JButton;

import dao.BangTrangThaiGameDAO;

public class ColorSnake {
	static int maxXY = 100;
	 private static int[][] map;
     private static JButton bt[][] = new JButton[maxXY][maxXY];
 	static Color background_cl[] = {Color.gray, Color.LIGHT_GRAY, Color.red, Color.green , Color.blue};
 	static Color snake_cl[] = {Color.LIGHT_GRAY , Color.YELLOW , Color.PINK};
	int m = 25, n = 25;
	private int a[][] = new int[maxXY][maxXY];
	private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

	    
	
	public static void updateColor() {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					bt[i][j].setBackground(background_cl[a[i][j]]);
				} else if (map[i][j] == 1 ) {
					bt[i][j].setBackground(snake_cl[BangTrangThaiGameDAO.getInstance().getValueSnake(playerName)]);
				} else if (map[i][j] == 4) {
					bt[i][j].setBackground(background_cl[a[i][j]]);
				}
			}

	}
	
	

}
