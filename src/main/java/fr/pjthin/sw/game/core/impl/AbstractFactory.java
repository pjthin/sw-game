package fr.pjthin.sw.game.core.impl;

import fr.pjthin.sw.game.core.Game;
import fr.pjthin.sw.game.core.GameCivilization;
import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.PlayerIhm;

public class AbstractFactory {

    private AbstractFactory() {

    }

    public static Game createGame(GameContext context) {
        return new GameImpl(context);
    }

    public static GamePlayer createPlayer(String pseudo, PlayerIhm ihm) {
        return new GamePlayerImpl(pseudo, ihm);
    }

    public static GameContextBuilder createContextBuilder() {
        return new GameContextBuilder();
    }

    public static GameCivilization createGameCivilization(String civilizationName) {
        return new GameCivilizationImpl(civilizationName);
    }
}
