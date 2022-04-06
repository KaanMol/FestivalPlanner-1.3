package com.company.popup;

import com.company.Schedule;

import java.awt.*;

public class CreatePopulationPopup extends PopulationPopup {

    Schedule schedule;

    public CreatePopulationPopup(Schedule schedule) {
        super(null);
        this.schedule = schedule;
    }

    @Override
    public void apply() {
        int population = Integer.parseInt(populationSchedule.getText());
        this.schedule.setPopulation(population);
    }

    @Override
    public void delete() {

    }
}
