package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Trainer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.time.LocalTime;

public abstract class BattlePopup extends Popup<Battle> {
    protected ComboBox<Trainer> trainer1;
    protected ComboBox<Trainer> trainer2;
    protected ComboBox<Arena> arena;
    protected TextField beginTime;
    protected TextField endTime;

    public BattlePopup(Battle item) {
        super(item);

        trainer1 = new ComboBox<>();
        trainer2 = new ComboBox<>();

        trainer1.getItems().addAll(Trainer.list);
        trainer2.getItems().addAll(Trainer.list);

        HBox trainerBox = new HBox(trainer1, trainer2);

        arena = new ComboBox<>();
        arena.getItems().addAll(Arena.list);

        beginTime = new TextField();
        endTime = new TextField();

        HBox timeBox = new HBox(beginTime, endTime);

        VBox base = new VBox(trainerBox, arena, timeBox);

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
