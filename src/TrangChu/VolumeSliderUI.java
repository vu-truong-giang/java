package TrangChu;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class VolumeSliderUI extends JFrame implements ActionListener {
    private JSlider volumeSliderMusic, volumeSliderVoice;
    private JLabel volumeLabelMusic, volumeLabelVoice;

    public VolumeSliderUI() {
        setTitle("Volume Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        volumeLabelMusic = new JLabel("Music Volume: ");
        volumeSliderMusic = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Min: 0, Max: 100, Default: 50
        volumeSliderMusic.setUI(new CircularSliderUI(volumeSliderMusic)); // Set custom UI
        
        
        int volume = volumeSliderMusic.getValue();
        volumeLabelMusic.setText("Music Volume: " + volume);
        volumeSliderMusic.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int volume = volumeSliderMusic.getValue();
                volumeLabelMusic.setText("Music Volume: " + volume);
                // Perform actions based on the volume value
            }
        });

        gbc.anchor = GridBagConstraints.WEST;
        add(volumeLabelMusic, gbc);

        gbc.gridx++;
        add(volumeSliderMusic, gbc);

        volumeLabelVoice = new JLabel("Voice Volume: ");
        volumeSliderVoice = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        volumeSliderVoice.setUI(new CircularSliderUI(volumeSliderVoice));
        
        
        volumeLabelVoice.setText("Voice Volume: " + volume);
        volumeSliderVoice.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int volume = volumeSliderVoice.getValue();
                volumeLabelVoice.setText("Voice Volume: " + volume);
            }
        });

        gbc.gridx = 0;
        gbc.gridy++;
        add(volumeLabelVoice, gbc);

        gbc.gridx++;
        add(volumeSliderVoice, gbc);
        
        
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(this);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(okBtn, gbc);

        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("OK")) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VolumeSliderUI());
    }
}