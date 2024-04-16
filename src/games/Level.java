package games;

import javax.swing.Timer;
import java.awt.event.*;

public class Level {
    private int[] speeds; // Mảng chứa các tốc độ cho các cấp độ
    private int[] levelScores;
    private Timer[] timers; // Mảng chứa các đối tượng Timer cho từng cấp độ
    private int currentLevel; // Cấp độ hiện tại

    public Level(int[] speeds) {
        this.speeds = speeds;
        this.currentLevel = 0; 
        this.timers = new Timer[speeds.length]; 

        
        for (int i = 0; i<speeds.length; i++) {
            final int levelIndex = i; 
            timers[i] = new Timer(speeds[i], new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
        }
    }
//    private void updateLevel() {
//    	for(int )
//    }

    
    public void start() {
        timers[currentLevel].start();
    }

    
    public void pause() {
        timers[currentLevel].stop();
    }

    
    public void nextLevel() {
        if (currentLevel < speeds.length - 1) {
            currentLevel++;
            start(); 
        }
    }

    // lấy cấp độ của cấp độ hiện tại
    public int getCurrentSpeed() {
        return speeds[currentLevel];
    }

    // lấy cấp độ hiện tại
    public int getCurrentLevel() {
        return currentLevel;
    }
}

