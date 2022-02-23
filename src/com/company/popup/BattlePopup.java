package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Trainer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalTime;

public class BattlePopup extends Popup<Battle> {
    private ComboBox<Trainer> trainer1;
    private ComboBox<Trainer> trainer2;
    private ComboBox<Arena> arena;
    private TextField beginTime;
    private TextField endTime;

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

        if (item == null)
            return;
        beginTime.setText(item.getBeginTime().toString());
        endTime.setText(item.getEndTime().toString());
        arena.setValue(item.getArena());
        trainer1.setValue(item.getTrainer1());
        trainer2.setValue(item.getTrainer2());
    }

    @Override
    public void apply() {
        if (item == null) {
            new Battle(LocalTime.parse(beginTime.getText()), LocalTime.parse(endTime.getText()),
                    arena.getValue(), trainer1.getValue(), trainer2.getValue());
        } else {
            item.setBeginTime(LocalTime.parse(beginTime.getText()));
            item.setEndTime(LocalTime.parse(endTime.getText()));
            item.setArena(arena.getValue());
            item.setTrainer1(trainer1.getValue());
            item.setTrainer2(trainer2.getValue());
        }
    }

    @Override
    public void delete() {
        if (item != null) {
            item.remove();
        }
    }
}
