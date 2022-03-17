package com.company.popup;

import com.company.Arena;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public abstract class ArenaPopup extends Popup<Arena> {
    protected TextField textField;

    public ArenaPopup(Arena item) {
        super(item);

        Label label = new Label("Arena name:");
        textField = new TextField();
        setInputArea(new HBox(label, textField));
    }
}
