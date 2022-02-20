package com.company;

import java.awt.Color;
import java.awt.FontMetrics;
import java.util.ArrayList;

import com.company.Infinity.Infinity2D;

import org.jfree.fx.FXGraphics2D;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {
    public FXGraphics2D fxGraphics2D;
    public Infinity2D infinity;
    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        this.infinity = new Infinity2D(800, 600);
        draw(new FXGraphics2D(infinity.getGraphicsContext2D()));

        TabPane pane = new TabPane();
        Tab tab = new Tab("schedule");
        tab.setClosable(false);
        tab.setContent(new Group(infinity));

        pane.getTabs().add(tab);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private void draw(FXGraphics2D fxGraphics2D) {
        this.fxGraphics2D = fxGraphics2D;

        int topbarHeight = 50;

        fxGraphics2D.setColor(Color.BLACK);
        fxGraphics2D.fillRect(0, 0, 100, 50);

        // fxGraphics2D.setColor(Color.WHITE);
        //Left bar
        // fxGraphics2D.fillRect(100, 50, 100, 600);

        int min = 6; 
        int max = 24;

        //Draw hours on left bar
        fxGraphics2D.setColor(Color.BLACK);
        for (int i = min; i <= max; i++) {
            fxGraphics2D.drawString(Integer.toString(i), 10, topbarHeight + (i - min) * 30);
        }

        
        //Top bar

        // Draw Arena's on top horizontal bar
        int columnWidth = ((int)this.infinity.getWidth() - 100) / 5;

        ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.PINK);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);

        for (int i = 0; i < colors.size(); i++) {
            fxGraphics2D.setColor(colors.get(i));
            int column = 100 + columnWidth * i;
            fxGraphics2D.fillRect(column, topbarHeight, columnWidth, (int)this.infinity.getHeight() - topbarHeight);

            fxGraphics2D.setColor(Color.BLACK);
            fxGraphics2D.drawString("Arena " + i, column, topbarHeight);
        }
        //get Font width from a given string
        int fontWidth = fxGraphics2D.getFontMetrics().stringWidth("Arena 1");

        System.out.println(fontWidth);

        this.button("Create", 0, 0, 100, 50);
    }

    void button(String text, int x, int y, int width, int height) {
        FontMetrics font = fxGraphics2D.getFontMetrics();
        int fontWidth = font.stringWidth(text);
        int fontHeight = font.getHeight();

        fxGraphics2D.setColor(Color.BLACK);
        fxGraphics2D.fillRect(x, y, width, height);
        
        fxGraphics2D.setColor(Color.WHITE);
        fxGraphics2D.drawString(text, (width - fontWidth) / 2, (height + fontHeight) / 2);

        System.out.println(fontHeight);
    }
}
