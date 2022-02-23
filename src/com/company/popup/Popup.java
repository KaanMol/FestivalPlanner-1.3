package com.company.popup;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class Popup<T> {
    private Stage stage;
    private Node inputArea;
    private Parent transferButtons;
    private Button cancelButton;
    private Button applyButton;
    private Button deleteButton;

    protected T item;

    public Popup(T item) {
        this.item = item;

        cancelButton = new Button("Cancel");
        applyButton = new Button(item == null ? "Create" : "Apply");
        HBox standardButtons = new HBox(cancelButton, applyButton);
        if (item == null) {
            transferButtons = standardButtons;
        } else {
            deleteButton = new Button("Delete");
            transferButtons = new VBox(standardButtons, deleteButton);
        }
        this.initialiseButtons();

        Scene scene = new Scene(new VBox(inputArea, transferButtons));
        this.stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void setInputArea(Node inputArea) {
        this.inputArea = inputArea;
    }

    public abstract void apply();

    public abstract void delete();

    public void close() {
        stage.close();
    }

    private void initialiseButtons() {
        cancelButton.setOnAction(e -> this.close());
        applyButton.setOnAction(e -> {
            this.apply();
            this.close();
        });
        deleteButton.setOnAction(e -> {
            this.delete();
            this.close();
        });
    }
}
