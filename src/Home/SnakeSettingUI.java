package Home;

import javax.swing.*;  
import games.*;
import games_2.SnakeGame_2;
import games_2.SnakeGame_2_2;
import games_2.SnakeGame_2_3;

import java.awt.*;
import java.awt.event.*;

public class SnakeSettingUI extends JFrame implements ActionListener {
   
	private JLabel[] mapLabels , snakeLabels , imgMapLabels , imgSnakeLabels;
	private int currentMapIndex , currentSnakeIndex;
    private int size;
    private JButton okButton;
    private JComboBox<String> OptionMap;
   

    public SnakeSettingUI() {
        setTitle("Snake Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Map selection
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        ImageIcon iconLeft = new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/Icon_left.png")));
        // Scale the image to a smaller size
        Image scaledImageLeft = iconLeft.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIconLeft = new ImageIcon(scaledImageLeft);
        
        ImageIcon iconRight = new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/Icon_right.png")));
        // Scale the image to a smaller size
        Image scaledImageRight = iconRight.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIconRight = new ImageIcon(scaledImageRight);

        // Tạo label cho map
        mapLabels = new JLabel[4];
        for (int i=0 ; i < mapLabels.length ; i++) {
        	mapLabels[i] = new JLabel("Map" + i);
        }
        currentMapIndex = 0;
        
        JLabel mapLabel = mapLabels[currentMapIndex];
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(mapLabel, gbc);

        // Create the button with the scaled icon
        JButton leftMapBtn = new JButton("", scaledIconLeft);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(leftMapBtn, gbc);
        
        JButton rightMapBtn = new JButton("", scaledIconRight);
        gbc.gridx= 2;
        gbc.gridy = 0;
        add(rightMapBtn , gbc);
        
        imgMapLabels = new JLabel[4];
        for ( int i= 0 ; i < imgMapLabels.length ; i++) {
        	imgMapLabels[i] = new JLabel();
        	imgMapLabels[i].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/img"+i+".png"))));
        }
        
        size = 200;
        
        JLabel imgMapLabel = imgMapLabels[currentMapIndex];
        imgMapLabel.setPreferredSize(new Dimension(size,size));
        gbc.gridx = 1; 
        gbc.gridy = 1;
        add(imgMapLabel, gbc);
        

  

        // Tạo label cho rắn
        snakeLabels = new JLabel[4];
        for( int i=0 ; i < snakeLabels.length ; i++) {
        	snakeLabels[i] = new JLabel("Snake " + i);
        }
        
        currentSnakeIndex = 0 ;
        
        JLabel snakeLabel = snakeLabels[currentSnakeIndex];
        gbc.gridx = 5;
        gbc.gridy = 0;
        add(snakeLabel, gbc);

        JButton rightSnakeBtn = new JButton("", scaledIconRight);
        gbc.gridx = 6;
        gbc.gridy = 0;
        add(rightSnakeBtn, gbc);

        JButton leftSnakeBtn = new JButton("", scaledIconLeft);
        gbc.gridx = 4;
        gbc.gridy = 0;
        add(leftSnakeBtn, gbc);
        
        
        
        imgSnakeLabels = new JLabel[4];
        for ( int i= 0 ; i < imgSnakeLabels.length ; i++) {
        	imgSnakeLabels[i] = new JLabel();
        	imgSnakeLabels[i].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/imgColor_"+i+".png"))));
        }
        
        JLabel imgSnakeLabel = imgSnakeLabels[currentSnakeIndex];
        imgSnakeLabel.setPreferredSize(new Dimension(size,size));
        gbc.gridx = 5; 
        gbc.gridy = 1;
        add(imgSnakeLabel, gbc);
        
        



        // OK button
//        JButton okButton = new JButton("OK");
//        okButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            
//                // Đóng cửa sổ hiện tại
//                setVisible(false);
//                // Đóng cả cửa sổ SnakeSettingUI
//                dispose();
//            }
//        });
        //JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
 	   
 	   String[] Maps = {"Map 1.1","Map 1.2","Map 1.3","Map 2.1","Map 2.2","Map 2.3"};
 	   OptionMap = new JComboBox<>(Maps);
 	   OptionMap.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String SelectOpp = (String) OptionMap.getSelectedItem();
			if(SelectOpp.equals("Map 2.1")) {
			    SnakeGame_2 snakeGame_2 = new SnakeGame_2(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame_2);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}else if(SelectOpp.equals("Map 2.2")) {
			    SnakeGame_2_2 snakeGame_2_2 = new SnakeGame_2_2(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame_2_2);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}else if(SelectOpp.equals("Map 2.3")) {
			    SnakeGame_2_3 snakeGame_2_3 = new SnakeGame_2_3(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame_2_3);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}else if(SelectOpp.equals("Map 1.1")) {
			    SnakeGame snakeGame = new SnakeGame(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}
			else if(SelectOpp.equals("1.2")) {
			    SnakeGame2 snakeGame2 = new SnakeGame2(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame2);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}
			else if(SelectOpp.equals("Map 1.3")) {
			    SnakeGame3 snakeGame3 = new SnakeGame3(600, 600);
				JFrame gameFrame = new JFrame("Snake Game ");
			    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    gameFrame.getContentPane().add(snakeGame3);// add class snakeGame vào
			    gameFrame.pack();
			    gameFrame.setLocationRelativeTo(null);
			    gameFrame.requestFocus();
			    gameFrame.setVisible(true);
			    pack();
			    dispose();
			}
			// Đóng cửa sổ hiện tại
             setVisible(false);
//          // Đóng cả cửa sổ SnakeSettingUI
             dispose();
			
		}
	});
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(OptionMap, gbc);
        
        
        
        leftMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMapIndex = (currentMapIndex - 1 + mapLabels.length) % mapLabels.length; // Chuyển sang mapLabel mới
                mapLabel.setText("Map " + currentMapIndex); // Thay đổi văn bản của mapLabel
                updateMapLabels();
            }

			private void updateMapLabels() {
				mapLabel.setText("Map " + currentMapIndex); // Cập nhật văn bản của mapLabel
	            imgMapLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/img" + currentMapIndex + ".png")))); // Cập nh
			}
        });
        
        rightMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMapIndex = (currentMapIndex + 1) % mapLabels.length; // Chuyển sang mapLabel mới
                updateMapLabels();
            }
            
            private void updateMapLabels() {
            	mapLabel.setText("Map " + currentMapIndex);
            	imgMapLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/img" + currentMapIndex + ".png"))));
            }
        });
        
        rightSnakeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSnakeIndex = (currentSnakeIndex + 1) % snakeLabels.length;
                updateSnakeLabels();
            }
            
            private void updateSnakeLabels() {
            	snakeLabel.setText("Snake " + currentSnakeIndex);
            	imgSnakeLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/imgColor_" + currentSnakeIndex + ".png"))));
            }
        });
        
        leftSnakeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSnakeIndex = (currentSnakeIndex - 1 + snakeLabels.length) % snakeLabels.length;
                updateSnakeLabels();
            }
            
            private void updateSnakeLabels() {
            	snakeLabel.setText("Snake " + currentSnakeIndex);
            	imgSnakeLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("/img/imgColor_" + currentSnakeIndex + ".png"))));
            }
        });
        
      
        setVisible(true);
        pack();
    }


   



	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()== okButton) {
//			//if(imgMapLabels.length==0 && imgSnakeLabels.length == 0) {
//				 SnakeGame_2 snakeGame_2 = new SnakeGame_2(600, 600);
//					JFrame gameFrame = new JFrame("Snake Game 2");
//				    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				    gameFrame.getContentPane().add(snakeGame_2);// add class snakeGame vào
//				    gameFrame.pack();
//				    gameFrame.setLocationRelativeTo(null);
//				    gameFrame.requestFocus();
//				    gameFrame.setVisible(true);
//				    pack();
//				    this.dispose();
//			//}
//		}
		
		
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeSettingUI());
    }
}
