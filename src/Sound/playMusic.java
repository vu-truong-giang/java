package Sound;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class playMusic {
     
	private boolean soundEnable = true;
    
	

	public static void run() {
	    try {
			while (true) {
			    play("anime.wav");
			    try {
			        Thread.sleep(1000); // Chờ 1 giây
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void toggleEnable() {
		try {
			soundEnable = !soundEnable;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    public static void play(String filepath) {
        try {
            // Load file âm thanh
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(playMusic.class.getResourceAsStream(filepath));

            // Tạo Clip
            Clip clip = AudioSystem.getClip();

            // Mở file âm thanh trong Clip
            clip.open(audioInputStream);

            // Phát âm thanh
            clip.start();

            // Chờ cho đến khi âm thanh kết thúc
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);

            // Đóng Clip
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	
}