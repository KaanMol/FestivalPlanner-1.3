package com.company.simulation;

import com.company.simulation.map.TileMap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import static com.company.simulation.navigation.Direction.*;

public class VisitorNPC extends NPC {
    public VisitorNPC(TileMap tileMap) {
        super(tileMap);
    }

    @Override
    public void loadImages() {
        sprites = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/visitorsprite.png")));
            int width = image.getWidth() / 3;
            int height = image.getHeight() / 4;
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 3; x++) {
                    this.sprites.add(image.getSubimage(x * width, y * height, width, height));
                }
            }
            setAnimationImages();
            centerX = sprites.get(0).getWidth() / 2;
            centerY = sprites.get(0).getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAnimationImages() {
        animation = new HashMap<>();
        animation.put(NORTH, Arrays.asList(sprites.get(0), sprites.get(1), sprites.get(0), sprites.get(2)));
        animation.put(WEST, Arrays.asList(sprites.get(3), sprites.get(4), sprites.get(3), sprites.get(5)));
        animation.put(SOUTH, Arrays.asList(sprites.get(6), sprites.get(7), sprites.get(6), sprites.get(8)));
        animation.put(EAST, Arrays.asList(sprites.get(9), sprites.get(10), sprites.get(9), sprites.get(11)));
    }

}
