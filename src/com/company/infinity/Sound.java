package com.company.infinity;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
    public MediaPlayer player;

    public Sound(String fileName) {
        String musicFile = System.getProperty("user.dir") + "/assets/sounds/" + fileName;
        Media music = new Media(new File(musicFile).toURI().toString());

        this.player = new MediaPlayer(music);
    }
}
