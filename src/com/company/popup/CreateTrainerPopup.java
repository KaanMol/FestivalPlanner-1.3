package com.company.popup;

import com.company.Trainer;

public class CreateTrainerPopup extends TrainerPopup {
    public CreateTrainerPopup() {
        super(null);
    }

    @Override
    public void apply() {
        new Trainer(trainer.getText(), pokemon.getText());
    }

    @Override
    public void delete() {
        //note that there is nothing to delete
    }
}
