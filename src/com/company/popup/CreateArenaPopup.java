package com.company.popup;

import com.company.Arena;

public class CreateArenaPopup extends ArenaPopup {
    public CreateArenaPopup(Arena item) {
        super(item);
        textField.setText(item.getArenaName());
    }

    @Override
    public void apply() {
        new Arena(textField.getText());
    }

    @Override
    public void delete() {
        //note that there is nothing to delete
    }
}
