package com.company;

import com.company.infinity.Node;

import java.awt.*;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;


public class Simulator extends Node {
    public void start(Stage stage) throws Exception {
        HBox SimMimic = new HBox();
        javafx.scene.control.TextField tempSim = new javafx.scene.control.TextField("");
        tempSim.setMinHeight(960);
        tempSim.setMinWidth(1280);
        VBox entireMenu = new VBox();
        entireMenu.setSpacing(25);


        VBox entireMenuTime = new VBox();
        Text Timeline = new Text("TimeLine");
        javafx.scene.control.TextField tempTimeLine = new javafx.scene.control.TextField("");
        entireMenuTime.getChildren().add(Timeline);
        entireMenuTime.getChildren().add(tempTimeLine);
        entireMenuTime.setSpacing(10);
        entireMenu.getChildren().add(entireMenuTime);

        VBox entireMenuDTime = new VBox();
        Text DigitaTime = new Text("Digital Time");
        javafx.scene.control.TextField digitalTimeDisplay = new TextField();
        entireMenuDTime.getChildren().add(DigitaTime);
        entireMenuDTime.getChildren().add(digitalTimeDisplay);
        entireMenuDTime.setSpacing(10);
        entireMenu.getChildren().add(entireMenuDTime);


        VBox entireMenuSimSpeed = new VBox();
        Text SimulationSpeed = new Text("Simulation Speed");

        HBox hBoxSpeedSim = new HBox();
        Button SimulationSpeed1X = new Button("1x");
        Button SimulationSpeed2X = new Button("2x");
        Button SimulationSpeed4X = new Button("4x");
        Button SimulationSpeed8X = new Button("8x");
        hBoxSpeedSim.getChildren().add(SimulationSpeed1X);
        hBoxSpeedSim.getChildren().add(SimulationSpeed2X);
        hBoxSpeedSim.getChildren().add(SimulationSpeed4X);
        hBoxSpeedSim.getChildren().add(SimulationSpeed8X);
        hBoxSpeedSim.setSpacing(10);
        entireMenuSimSpeed.getChildren().add(SimulationSpeed);
        entireMenuSimSpeed.getChildren().add(hBoxSpeedSim);
        entireMenuSimSpeed.setSpacing(10);
        entireMenu.getChildren().add(entireMenuSimSpeed);


        VBox entireMenuPopulation = new VBox();

        Text Population = new Text("Population");
        HBox hBoxPopulation = new HBox();
        Text PopulationMaxMin = new Text("(Min. 50, Max. 10.000)");
        Text CurrentPopulation = new Text("Current: " + "......");
        hBoxPopulation.getChildren().add(PopulationMaxMin);
        hBoxPopulation.getChildren().add(CurrentPopulation);
        hBoxPopulation.setSpacing(10);

        HBox PopulationButtons = new HBox();
        Button PopulationAdd1 = new Button("1");
        Button PopulationAdd10 = new Button("10");
        Button PopulationAdd50 = new Button("50");
        Button PopulationAdd100 = new Button("100");
        PopulationButtons.getChildren().add(PopulationAdd1);
        PopulationButtons.getChildren().add(PopulationAdd10);
        PopulationButtons.getChildren().add(PopulationAdd50);
        PopulationButtons.getChildren().add(PopulationAdd100);
        PopulationButtons.setSpacing(10);
        entireMenuPopulation.getChildren().add(Population);
        entireMenuPopulation.getChildren().add(hBoxPopulation);
        entireMenuPopulation.getChildren().add(PopulationButtons);
        entireMenuPopulation.setSpacing(10);
        entireMenu.getChildren().add(entireMenuPopulation);


        VBox entireMenuPlayPause = new VBox();
        HBox plusMinus  = new HBox();
        Button Plus = new Button("+");
        Button Minus = new Button("-");
        plusMinus.getChildren().add(Plus);
        plusMinus.getChildren().add(Minus);
        plusMinus.setSpacing(10);

        Text PlayPause = new Text("Play/Pause");

        HBox hBoxplayPause = new HBox();
        Button play = new Button(">");
        Button pause = new Button("||");
        hBoxplayPause.getChildren().add(play);
        hBoxplayPause.getChildren().add(pause);
        hBoxplayPause.setSpacing(10);
        entireMenuPlayPause.getChildren().add(plusMinus);
        entireMenuPlayPause.getChildren().add(PlayPause);
        entireMenuPlayPause.getChildren().add(hBoxplayPause);
        entireMenuPlayPause.setSpacing(10);
        entireMenu.getChildren().add(entireMenuPlayPause);

        SimMimic.getChildren().add(tempSim);
        SimMimic.getChildren().add(entireMenu);
        SimMimic.setSpacing(10);



        Scene scene = new Scene(SimMimic);
        stage.setScene(scene);
        stage.setTitle("Simulation");
        stage.setMinHeight(960);
        stage.setMinWidth(250);

        stage.show();


    }

}
