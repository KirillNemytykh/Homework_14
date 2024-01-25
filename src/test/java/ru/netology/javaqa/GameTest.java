package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.NotCompliantMBeanException;

public class GameTest {

    @Test
    public void testFirstPlayerWinBothRegistered() {
        Game game = new Game();
        Player kirill = new Player(1, "Кирилл", 80);
        Player andrey = new Player(2, "Андрей", 60);

        game.register(kirill);
        game.register(andrey);

        int actual = game.round("Кирилл", "Андрей");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayerWinBothRegistered() {
        Game game = new Game();
        Player kirill = new Player(1, "Кирилл", 80);
        Player andrey = new Player(2, "Андрей", 140);

        game.register(kirill);
        game.register(andrey);

        int actual = game.round("Кирилл", "Андрей");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testDrawBothRegistered() {
        Game game = new Game();
        Player kirill = new Player(1, "Кирилл", 80);
        Player andrey = new Player(2, "Андрей", 80);

        game.register(kirill);
        game.register(andrey);

        int actual = game.round("Кирилл", "Андрей");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testFirstPlayerNotRegistered() {
        Game game = new Game();
        Player kirill = new Player(1, "Кирилл", 80);
        Player andrey = new Player(2, "Андрей", 120);

        game.register(andrey);
        game.register(kirill);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Кирилл"));

    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Game game = new Game();
        Player kirill = new Player(1, "Кирилл", 80);
        Player andrey = new Player(2, "Андрей", 120);

        game.register(andrey);
        game.register(kirill);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Кирилл", "Иван"));

    }
}
