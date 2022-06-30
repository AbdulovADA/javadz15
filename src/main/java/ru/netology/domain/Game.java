package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Game {
    protected List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }
    public Collection<Player> findAll() {
        return players;
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int player1No = findByName(name1);
        int player2No = findByName(name2);

        if (player1No == -1) {
            throw new NotRegisteredException("Игрок" + name1 + "не зарегистрирован");
        }
        if (player2No == -1) {
            throw new NotRegisteredException("Игрок" + name1 + "не зарегистрирован");
        }

        int strength1 = players.get(player1No).getStrength();
        int strength2 = players.get(player2No).getStrength();

        if (strength1 == strength2) {
            return 0;
        }
        if (strength1 > strength2) {
            return 1;
        }
        return 2;
    }

}

