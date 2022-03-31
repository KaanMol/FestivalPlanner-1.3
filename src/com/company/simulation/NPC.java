package com.company.simulation;

import com.company.infinity.Node;

import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NPC extends Node {
    private Point2D position;
    private List<BufferedImage> sprites;
    private double speed;
    private Direction direction;

    public NPC() {
        this.setZIndex(4);
        setImages();
        this.speed = 10;

    }

    public void update() {

    }

    public void draw() {

    }

    public void setImages() {
        sprites = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/assets/images/npcsprite.png"));
            int width = image.getWidth() / 3;
            int height = image.getHeight() / 4;
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 3; x++) {
                    this.sprites.add(image.getSubimage(x * width, y * height, width, height));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
