package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Trainer implements Serializable {
    /*
    Als eerste krijgen we de Object attributen voor deze klasse.
     */
    private String name;
    private String pokemon;

    /*
    Als tweede krijgen we de constructor(s) voor deze klasse.
     */

    public Trainer(String name, String pokemon) {
        this.name = name;
        this.pokemon = pokemon;
        Trainer.list.add(this);
    }

    /*
       Nu komen methods die public zijn en dus door andere Klassen bereikt kunnen worden.
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getName() {
        return this.name;
    }

    public String getPokemon() {
        return this.pokemon;
    }

    public static ArrayList<Trainer> list = new ArrayList<>();

    public void remove() {
        Trainer.list.remove(this);
    }

    @Override
    public String toString() {
        return "com.company.Trainer{" +
                "name='" + name + '\'' +
                ", pokemon='" + pokemon + '\'' +
                '}';
    }
}
