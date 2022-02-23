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
    }

    /**
     * sets the node that manages the input area for the item
     *
     * @param inputArea the area to manage the item in
     */
    public void setInputArea(Node inputArea) {
        this.inputArea = inputArea;
        Scene scene = new Scene(new VBox(inputArea, transferButtons));
        this.stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * applies all changes to the item
     */
    public abstract void apply();

    /**
     * deletes the item
     */
    public abstract void delete();

    /**
     * closes the popup
     */
    public void close() {
        stage.close();
    }

    private void initialiseButtons() {
        cancelButton.setOnAction(e -> this.close());
        applyButton.setOnAction(e -> {
            this.apply();
            this.close();
        });
        if (deleteButton != null)
            deleteButton.setOnAction(e -> {
                this.delete();
                this.close();
            });
    }
}
