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
        URL soundURL = PlayMusic.class.getResource("anime.wav");
        sound.setFile(soundURL);
        sound.play(soundURL);
        sound.loop(soundURL);
        int volumeValue = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);
        sound.fc.setValue(volumeValue); // Set volume based on DAO value
    }

    // Method to set volume externally
    public static void setVolume(int volumeValue) {
        sound.fc.setValue(volumeValue);
    }
}
