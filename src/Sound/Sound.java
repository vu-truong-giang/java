package Sound;

import java.io.IOException;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import LogIn.LoginForm;
import dao.BangTrangThaiGameDAO;

public class Sound {
	
	Clip clip;
	private static String playerName;
	float previousVolume = 0;

	public FloatControl fc;
	boolean mute = false;

	
    public static void setPlayerName(String name) {
        playerName = name;
        System.out.println(playerName);
        System.out.println(BangTrangThaiGameDAO.getInstance().getValueMusic(playerName));
    }
	public static float currentVolume = BangTrangThaiGameDAO.getInstance().getValueMusic(playerName);

    
    
	

	public void setFile(URL url) {
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(sound);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void play(URL url) {
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void loop(URL url) {
		clip.loop((Clip.LOOP_CONTINUOUSLY));
	}
	
	public void stop(URL url) {
		clip.stop();
	}
	
	
	public void volumeUp() {
		currentVolume += 1.0f;
		if(currentVolume > 6.0f) {
			currentVolume = 6.0f;
		}
		
		fc.setValue(currentVolume);
	}
	
	public void volumeDown() {
		currentVolume -= 1.0f;
		if(currentVolume < -80.0f) {
			currentVolume = -80.0f;
		}
		
		fc.setValue(currentVolume);
	}
	
	public void volumeMute() {
		if(mute == false) {
			previousVolume = currentVolume;
			currentVolume = -80.0f;
			fc.setValue(currentVolume);
			mute = true;
		}  else if(mute == true) {
			currentVolume = previousVolume;
			fc.setValue(currentVolume);
			mute = false;
		}
		
		
	}

	

	

}