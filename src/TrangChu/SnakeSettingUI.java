package TrangChu;

import javax.swing.*;

import dao.BangTrangThaiGameDAO;

import java.awt.*;
import java.awt.event.*;

public class SnakeSettingUI extends JFrame implements ActionListener {
   
	private JLabel[] mapLabels , snakeLabels , imgMapLabels , imgSnakeLabels;
	private int currentMapIndex , currentSnakeIndex;
    private int size;
    
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public SnakeSettingUI() {
        setTitle("Snake Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        
        

        // Map selection
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        ImageIcon iconLeft = new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("Icon_left.png")));
        // Scale the image to a smaller size
        Image scaledImageLeft = iconLeft.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIconLeft = new ImageIcon(scaledImageLeft);
        
        ImageIcon iconRight = new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("Icon_right.png")));
        // Scale the image to a smaller size
        Image scaledImageRight = iconRight.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIconRight = new ImageIcon(scaledImageRight);

        // Tạo label cho map
        mapLabels = new JLabel[4];
        for (int i=0 ; i < mapLabels.length ; i++) {
        	mapLabels[i] = new JLabel("Map" + i);
        }
        currentMapIndex = BangTrangThaiGameDAO.getInstance().getValueMap(playerName) ;
        
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
        	imgMapLabels[i].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img"+i+".jpg"))));
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
        
        currentSnakeIndex = BangTrangThaiGameDAO.getInstance().getValueSnake(playerName) ;
        
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
        	imgSnakeLabels[i].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img"+i+".jpg"))));
        }
        
        JLabel imgSnakeLabel = imgSnakeLabels[currentSnakeIndex];
        imgSnakeLabel.setPreferredSize(new Dimension(size,size));
        gbc.gridx = 5; 
        gbc.gridy = 1;
        add(imgSnakeLabel, gbc);
        
        



        // OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Đóng cửa sổ hiện tại
            	BangTrangThaiGameDAO.getInstance().updateSnakeSetting(playerName, currentMapIndex, currentSnakeIndex);
                setVisible(false);
                // Đóng cả cửa sổ SnakeSettingUI
                dispose();
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(okButton, gbc);
        
        
        
        leftMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMapIndex = (currentMapIndex - 1 + mapLabels.length) % mapLabels.length; // Chuyển sang mapLabel mới
                mapLabel.setText("Map " + currentMapIndex); // Thay đổi văn bản của mapLabel
                updateMapLabels();
            }

			private void updateMapLabels() {
				mapLabel.setText("Map " + currentMapIndex); // Cập nhật văn bản của mapLabel
	            imgMapLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img" + currentMapIndex + ".jpg")))); // Cập nh
			}
        });
        
        rightMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMapIndex = (currentMapIndex + 1) % mapLabels.length; // Chuyển sang mapLabel mới
                updateMapLabels();
            }
            
            private void updateMapLabels() {
            	mapLabel.setText("Map " + currentMapIndex);
            	imgMapLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img" + currentMapIndex + ".jpg"))));
            }
        });
        
        rightSnakeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSnakeIndex = (currentSnakeIndex + 1) % snakeLabels.length;
                updateSnakeLabels();
            }
            
            private void updateSnakeLabels() {
            	snakeLabel.setText("Snake " + currentSnakeIndex);
            	imgSnakeLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img" + currentSnakeIndex + ".jpg"))));
            }
        });
        
        leftSnakeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSnakeIndex = (currentSnakeIndex - 1 + snakeLabels.length) % snakeLabels.length;
                updateSnakeLabels();
            }
            
            private void updateSnakeLabels() {
            	snakeLabel.setText("Snake " + currentSnakeIndex);
            	imgSnakeLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SnakeSettingUI.class.getResource("img" + currentSnakeIndex + ".jpg"))));
            }
        });
        
      
        setVisible(true);
        pack();
    }


   



	public void actionPerformed(ActionEvent e) {
          
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SnakeSettingUI());
    }
}
