package Sound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMusicInMap implements Runnable {
    

    public static void play(String filepath) {

        try {
           AudioInputStream audioInputStream  = AudioSystem.getAudioInputStream(PlayMusicInMap.class.getResource(filepath)); // Sửa thành PlayMusicInMap.class
           Clip clip = AudioSystem.getClip();
           clip.open(audioInputStream);
           clip.start();
           while (!clip.isRunning())
               Thread.sleep(10);
           while (clip.isRunning())
               Thread.sleep(10);

           // Đóng Clip
           clip.close();
           
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

	
	

}
