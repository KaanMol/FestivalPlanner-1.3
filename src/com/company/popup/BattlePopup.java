package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Trainer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.scene.text.Text;


public abstract class BattlePopup extends Popup<Battle> {
    protected ComboBox<Trainer> trainer1;
    protected ComboBox<Trainer> trainer2;
    protected ComboBox<Arena> arena;
    protected TextField beginTime;
    protected TextField endTime;
    protected TextField popularityPercent;

    public BattlePopup(Battle item) {
        super(item);
        Text selectTrainer1 = new Text("Select the first trainer:");
        Text selectTrainer2 = new Text("Select the second trainer: ");
        Text selectArena = new Text("Select the arena: ");
        Text enterBeginTime = new Text("Enter the begin time: ");
        Text enterEndTime = new Text("Enter the end time: ");
        Text enterPopularity = new Text("Enter the % of popularity: ");

        //make hboxes for the above made textfields
        HBox trainerText = new HBox(selectTrainer1, selectTrainer2);
        HBox arenaText = new HBox(selectArena);
        HBox popularityText = new HBox(enterPopularity);
        HBox timeText = new HBox(enterBeginTime, enterEndTime);
        //set spacing for the above made boxes
        trainerText.setSpacing(173);
        timeText.setSpacing(66);

        //make the comboBoxes for the trainers
        trainer1 = new ComboBox<>();
        trainer2 = new ComboBox<>();
        trainer1.getItems().addAll(Trainer.list);
        trainer2.getItems().addAll(Trainer.list);

        //make the hbox for the trainer comboBoxes and set the spacing
        HBox trainerBox = new HBox(trainer1, trainer2);
        trainerBox.setSpacing(20);

        //make the comboBox for the arena
        arena = new ComboBox<>();
        arena.getItems().addAll(Arena.list);

        //make the tectfields for the time input
        beginTime = new TextField();
        endTime = new TextField();

        //make the textfield for the popularity input
        popularityPercent = new TextField();

        //make hbox for the time input and set the spacing
        HBox timeBox = new HBox(beginTime, endTime);
        timeBox.setSpacing(20);
        //make the vboxes to link the textfields to the right hboxes
        VBox trainersComplete = new VBox(trainerText, trainerBox);
        VBox arenaComplete = new VBox(arenaText, arena);
        VBox popularityComplete = new VBox(popularityText, popularityPercent);
        VBox timeComplete = new VBox(timeText, timeBox);

        VBox base = new VBox(trainersComplete, arenaComplete, popularityComplete, timeComplete);
        base.setSpacing(20);
        setInputArea(base);

        trainer1.setConverter(new StringConverter<Trainer>() {
            @Override
            public String toString(Trainer object) {
                return object.getName();
            }

            @Override
            public Trainer fromString(String string) {
                return null;
            }
        });
        trainer2.setConverter(new StringConverter<Trainer>() {
            @Override
            public String toString(Trainer object) {
                return object.getName();
            }

            @Override
            public Trainer fromString(String string) {
                return null;
            }
        });
        arena.setConverter(new StringConverter<Arena>() {
            @Override
            public String toString(Arena object) {
                return object.getArenaName();
            }

            @Override
            public Arena fromString(String string) {
                return null;
            }
        });
    }
}