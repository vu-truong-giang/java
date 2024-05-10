package TrangChu;

import javax.swing.*;
import LogIn.LoginForm;
import Sound.PlayMusic;
import Sound.Sound;

import javax.swing.event.*;

import dao.BangTrangThaiGameDAO;

import java.awt.*;
import java.awt.event.*;

public class VolumeSliderUI extends JFrame implements ActionListener {
    private JSlider volumeSliderMusic, volumeSliderVoice;
    private JLabel volumeLabelMusic, volumeLabelVoice;
    
    
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public VolumeSliderUI() {
        setTitle("Volume Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        
   /*================================================================================set music ==================================================*/     
        
        int num = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName );
        volumeLabelMusic = new JLabel("Music Volume: " + num); // Đổi thành Music Volume
        System.out.println(num);
        volumeSliderMusic = new JSlider(JSlider.HORIZONTAL, -80 , 6);
        volumeSliderMusic.setUI(new CircularSliderUI(volumeSliderMusic));

        // Thêm một ChangeListener cho volumeSliderMusic
        volumeSliderMusic.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Lấy giá trị mới từ volumeSliderMusic
                int newValue = volumeSliderMusic.getValue();
                
                
                // Cập nhật giá trị của JLabel
                volumeLabelMusic.setText("Music Volume: " + newValue); // Sửa thành volumeLabelMusic
                
                Sound.getNum(newValue);
                
                // Lưu giá trị mới vào CSDL
                BangTrangThaiGameDAO.getInstance().updateMusicToDatabase(playerName, newValue);
                System.out.println(newValue);
            }
        });
        

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(volumeLabelMusic, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        add(volumeSliderMusic, gbc);
        
        /*--------------------------------------set VOice--------------------------------------------------------------------------*/
       
        int numVoice = BangTrangThaiGameDAO.getInstance().getValueVoice(playerName);
        volumeLabelVoice = new JLabel("Voice Volume: " + numVoice); 
        System.out.println(numVoice);
        volumeSliderVoice = new JSlider(JSlider.HORIZONTAL, 0, 100, numVoice);
        volumeSliderVoice.setUI(new CircularSliderUI(volumeSliderVoice));

        // Thêm một ChangeListener cho volumeSliderMusic
        volumeSliderVoice.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Lấy giá trị mới từ volumeSliderMusic
                int newValue = volumeSliderVoice.getValue();
                // Cập nhật giá trị của JLabel
                volumeLabelVoice.setText("Voice Volume: " + newValue); // Sửa thành volumeLabelMusic
                // Lưu giá trị mới vào CSDL
                BangTrangThaiGameDAO.getInstance().updateVoiceToDatabase(playerName, newValue );
                System.out.println(newValue);
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(volumeLabelVoice, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(volumeSliderVoice, gbc);

        
        
/*====================================================================set button ========================================================*/
        
        
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(e -> {
//        	BangTrangThaiGameDAO.getInstance().updateVolumeSlider(playerName, volumeSliderMusic.getValue(), volumeSliderVoice.getValue());

        	 dispose();
        });
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(okBtn, gbc);

        pack();
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VolumeSliderUI());
    }

	
}