package com.company.popup;

import com.company.Arena;

public class EditArenaPopup extends ArenaPopup {
    public EditArenaPopup(Arena item) {
        super(item);
        textField.setText(item.getArenaName());
    }

    @Override
    public void apply() {
        item.setArenaName(textField.getText());
    }

    @Override
    public void delete() {
        item.remove();
    }
}
