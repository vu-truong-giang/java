package TrangChu;
import java.awt.BorderLayout;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Sound.PlayMusic;
import Sound.Sound;
import LogIn.LoginForm;
import dao.BangTrangThaiGameDAO;

public class Slider {
    private JSlider slider;
    private JLabel volumeLabel;
    private Sound sound = new Sound();
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Slider());
    }

    public Slider() {
        JFrame window = new JFrame("Volume Control");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        int num  = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);
        System.out.println(num);
        volumeLabel = new JLabel("Volume: " + num + " db");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(volumeLabel, gbc);

        slider = new JSlider( -40, 6 );
        slider.setUI(new CircularSliderUI(slider));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(num);
            	System.out.println(playerName);
                 
                volumeLabel.setText("Volume: " + slider.getValue() + " db");
            }
        });
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(slider, gbc);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(cancel, gbc);
        
        JButton set = new JButton("Set");
        set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BangTrangThaiGameDAO.getInstance().updateMusicToDatabase(playerName, slider.getValue());
                PlayMusic.setVolume(slider.getValue());
			}
        	
        });
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(set, gbc);
        

        window.add(panel, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        window.setVisible(true);
    }
}
