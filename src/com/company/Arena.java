package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Arena implements Serializable {
    /*
    Als eerste krijgen we de Object attributen voor deze klasse.
     */

    private String arenaName;

    /*
    Als tweede krijgen we de constructor(s) voor deze klasse.
     */

    public Arena(String arenaName) {
        this.arenaName = arenaName;
        Arena.list.add(this);
    }

    /*
       Nu komen methods die public zijn en dus door andere Klassen bereikt kunnen worden.
     */

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public String getArenaName() {
        return this.arenaName;
    }

    public static ArrayList<Arena> list = new ArrayList<>();

    public void remove() {
        Arena.list.remove(this);
    }


    @Override
    public String toString() {
        return "Arena{" +
                "arenaName='" + arenaName + '\'' +
                '}';
    }
}
