package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Schedule;
import com.company.Trainer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public abstract class PopulationPopup extends Popup<Schedule> {
    protected TextField populationSchedule;

    public PopulationPopup(Schedule item) {
        super(item);
        Text enterPopulation = new Text("Enter the population: ");

        //make hboxes for the above made textfields
        HBox populationText = new HBox(enterPopulation);
        //set spacing for the above made boxes
        populationText.setSpacing(66);

        //make the textfield for the population input
        populationSchedule = new TextField();

        VBox populationComplete = new VBox(populationText, populationSchedule);
        setInputArea(populationComplete);
    }
}

