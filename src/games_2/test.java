package games_2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class test extends JFrame implements ActionListener{
   private JComboBox<String> OptionMap;
   private SnakeGame_2 snakeGame_2;
   private SnakeGame_2_2 snakeGame_2_2;
   
   private Map_2 map;
   private SnakeColor_2 snakeColor;
   private SnakeHaed_2 snakeHead;
   private SnakrBody_2 snakeBody;
   private Food_2 food;
   private int tileSize = 25;
   
   
   public test() {
	   
	   setTitle("Test");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setPreferredSize(new Dimension(300,300));
	   setLocationRelativeTo(null);
	   pack();
	   JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	   
	   String[] Maps = {"Map 1","Map 2","Map 3"};
	   OptionMap = new JComboBox<>(Maps);
	   OptionMap.addActionListener(this);
	   
	   jPanel.add(OptionMap);
	   add(jPanel);
	   
	   setVisible(true);
   }
   
   public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			test test = new test();
		}
	});
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()== OptionMap) {
		String SelectOpp = (String) OptionMap.getSelectedItem();
		if(SelectOpp.equals("Map 1")) {
		    SnakeGame_2 snakeGame_2 = new SnakeGame_2(600, 600);
			JFrame gameFrame = new JFrame("Snake Game 2");
		    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    gameFrame.getContentPane().add(snakeGame_2);// add class snakeGame vào
		    gameFrame.pack();
		    gameFrame.setLocationRelativeTo(null);
		    gameFrame.requestFocus();
		    gameFrame.setVisible(true);
		    pack();
		    this.dispose();
		}else if(SelectOpp.equals("Map 2")) {
		    SnakeGame_2_2 snakeGame_2_2 = new SnakeGame_2_2(600, 600);
			JFrame gameFrame = new JFrame("Snake Game 2");
		    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    gameFrame.getContentPane().add(snakeGame_2_2);// add class snakeGame vào
		    gameFrame.pack();
		    gameFrame.setLocationRelativeTo(null);
		    gameFrame.requestFocus();
		    gameFrame.setVisible(true);
		    pack();
		    this.dispose();
		}else if(SelectOpp.equals("Map 3")) {
		    SnakeGame_2_3 snakeGame_2_3 = new SnakeGame_2_3(600, 600);
			JFrame gameFrame = new JFrame("Snake Game 2");
		    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    gameFrame.getContentPane().add(snakeGame_2_3);// add class snakeGame vào
		    gameFrame.pack();
		    gameFrame.setLocationRelativeTo(null);
		    gameFrame.requestFocus();
		    gameFrame.setVisible(true);
		    pack();
		    this.dispose();
		}
		    
	} 
	
	
}
   
  

}
