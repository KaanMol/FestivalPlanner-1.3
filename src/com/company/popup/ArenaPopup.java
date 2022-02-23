package com.company.popup;

import com.company.Arena;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ArenaPopup extends Popup<Arena> {
    private TextField textField;

    public ArenaPopup(Arena item) {
        super(item);

        Label label = new Label("Arena name:");
        textField = new TextField();
        setInputArea(new HBox(label, textField));

        if (item == null)
            return;
        textField.setText(item.getArenaName());
    }

    @Override
    public void apply() {
        if (item == null) {
            new Arena(textField.getText());
        } else {
            item.setArenaName(textField.getText());
        }
    }

    @Override
    public void delete() {
        if (item != null) {
            item.remove();
        }
    }
}
