package com.company.popup;

import com.company.Trainer;

public class EditTrainerPopup extends TrainerPopup {
    public EditTrainerPopup(Trainer item) {
        super(item);
        trainer.setText(item.getName());
        pokemon.setText(item.getPokemon());
    }

    @Override
    public void apply() {
        item.setName(trainer.getText());
        item.setPokemon(pokemon.getText());
    }

    @Override
    public void delete() {
        item.remove();
    }
}
