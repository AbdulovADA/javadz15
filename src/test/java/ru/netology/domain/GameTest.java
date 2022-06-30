package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Player player1 = new Player(1, "Max", 10);
    Player player2 = new Player(2, "Mary", 8);
    Player player3 = new Player(3, "Alex", 6);
    Player player4 = new Player(4, "Seth", 10);
    Player player5 = new Player(5, "May", 2);

    Game testGame = new Game();

    @Test
    void shouldPlusPlayer() {
        testGame.register(player1);
        testGame.register(player2);
        testGame.register(player3);

        Collection<Player> actual = testGame.findAll();
        Collection<Player> expected = List.of(player1, player2, player3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldEmptyPlayers() {

        Collection<Player> actual = testGame.findAll();
        Collection<Player> expected = List.of();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void RegisteredPlayers() {
        testGame.register(player1);
        testGame.register(player2);
        testGame.register(player3);
        testGame.register(player4);
        testGame.register(player5);

        int actual1 = testGame.round("Max", "Seth");
        int expected1 = 0;
        Assertions.assertEquals(expected1, actual1);

        int actual2 = testGame.round("Mary", "May");
        int expected2 = 1;
        Assertions.assertEquals(expected1, actual1);

        int actual3 = testGame.round("Alex", "Max");
        int expected3 = 2;
        Assertions.assertEquals(expected1, actual1);

    }

    @Test
    void notRegisteredPlayers() {
        testGame.register(player1);
        testGame.register(player2);
        testGame.register(player3);
        testGame.register(player4);
        testGame.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            testGame.round("Ray", "Alex");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            testGame.round("Max", "Manny");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            testGame.round("Piper", "Rachel");
        });
    }

    @Test
    void getPlayer() {
        Player data = new Player(9, "Sasha", 19);
        assertEquals(9, data.getId());
        assertEquals("Sasha", data.getName());
        assertEquals(19, data.getStrength());
    }

    @Test
    void getPlayer2() {
        Player data = new Player();
        assertEquals(0, data.getId());
        assertEquals(null, data.getName());
        assertEquals(0, data.getStrength());
    }
}



