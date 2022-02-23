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
    }

    @Override
    public void apply() {
        delete();
        new Arena(textField.getText());
    }

    @Override
    public void delete() {
        if (item != null) {
            item.remove();
        }
    }
}
