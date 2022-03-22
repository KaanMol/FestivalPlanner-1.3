package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Config;
import com.company.infinity.Infinity;
import com.company.infinity.Node;
import com.company.infinity.Table;
import com.company.infinity.TableCell;

import java.time.LocalTime;
import java.util.ArrayList;

public class EditBattlePopup extends BattlePopup {
    public EditBattlePopup(Battle item) {
        super(item);
        beginTime.setText(item.getBeginTime().toString());
        endTime.setText(item.getEndTime().toString());
        arena.setValue(item.getArena());
        trainer1.setValue(item.getTrainer1());
        trainer2.setValue(item.getTrainer2());
    }

    @Override
    public void apply() {
        item.setBeginTime(LocalTime.parse(beginTime.getText()));
        item.setEndTime(LocalTime.parse(endTime.getText()));
        item.setArena(arena.getValue());
        item.setTrainer1(trainer1.getValue());
        item.setTrainer2(trainer2.getValue());
    }

    @Override
    public void delete() {
        item.remove();
    }
}
