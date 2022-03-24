package com.company.popup;

import com.company.Trainer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class TrainerPopup extends Popup<Trainer>{
    protected TextField trainer;
    protected TextField pokemon;

    public TrainerPopup(Trainer item) {
        super(item);

        Label label = new Label("Trainer name:");
        trainer = new TextField();

        HBox trainerBox = new HBox(label, trainer);

        Label label2 = new Label("Pokémon name:");
        pokemon = new TextField();

        HBox pokemonBox = new HBox(label2, pokemon);

        setInputArea(new VBox(trainerBox, pokemonBox));
    }
}
