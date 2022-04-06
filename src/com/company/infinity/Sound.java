package com.company.infinity;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Sound player
 */
public class Sound {
    // The actual media player
    public MediaPlayer player;

    /**
     * Initiate sound
     * @param fileName name of the file in the sounds folder
     */
    public Sound(String fileName) {
        String musicFile = System.getProperty("user.dir") + "/assets/sounds/" + fileName;
        Media music = new Media(new File(musicFile).toURI().toString());

        this.player = new MediaPlayer(music);
    }
}
