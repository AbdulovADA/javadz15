package ru.netology.domain;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}
