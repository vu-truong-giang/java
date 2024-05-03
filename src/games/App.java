package games;

import javax.swing.JFrame;
public class App extends JFrame {
    public static void main(String[] args) throws Exception {
        int boardWidth = 600;
        int boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
        
//          
//          Map map = new Map(boardWidth, boardHeight);
//          frame.add(map);
//          frame.pack();
//        new snakeGameee();
//        frame.add(snakeGameee);
//        frame.pack();
        
    }
}
