package Sound;

import java.net.URL;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import dao.BangTrangThaiGameDAO;

public class PlayMusic {
    static Sound sound = new Sound();
    private static String playerName;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static void playMusic() {
        URL soundURL = PlayMusic.class.getResource("Charlie-Puth-and-Selena-Gomez-We-Don_t-Talk-Anymore-_minus_.wav");
        sound.setFile(soundURL);
        sound.play(soundURL);
        sound.loop(soundURL);
        int volumeValue = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);
        sound.fc.setValue(volumeValue); // Set volume based on DAO value
    }
    
    public static void SoundSnakeEatFood() {
    	 URL soundURL = PlayMusic.class.getResource("cartoon-jump-6462.wav");
         sound.setFile(soundURL);
         sound.play(soundURL);
         int volumeValue = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);
         sound.fc.setValue(volumeValue); 
    }
    
    public static void SoundSnakeLoss() {
   	 URL soundURL = PlayMusic.class.getResource("game-bonus-144751.wav");
        sound.setFile(soundURL);
        sound.play(soundURL);
        int volumeValue = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);
        sound.fc.setValue(volumeValue); 
   }

    // Method to set volume externally
    public static void setVolume(int volumeValue) {
        sound.fc.setValue(volumeValue);
    }
}
