package com.company.popup;

import com.company.Battle;

import java.time.LocalTime;

public class CreateBattlePopup extends BattlePopup {
    public CreateBattlePopup() {
        super(null);
    }

    @Override
    public void apply() {
        new Battle(LocalTime.parse(beginTime.getText()), LocalTime.parse(endTime.getText()),
                arena.getValue(), trainer1.getValue(), trainer2.getValue());
    }

    @Override
    public void delete() {
        //note that there is nothing to delete
    }
}
