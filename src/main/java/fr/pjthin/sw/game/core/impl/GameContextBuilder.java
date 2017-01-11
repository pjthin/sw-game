package fr.pjthin.sw.game.core.impl;

import java.util.List;

import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GameException;
import fr.pjthin.sw.game.core.GameException.GameError;
import fr.pjthin.sw.game.core.GamePlayer;

public class GameContextBuilder {

    private GameContext context;

    public GameContextBuilder() {
        this.context = new GameContextImpl();
    }

    public GameContext build() {
        return context;
    }

    public GameContextBuilder addPlayer(GamePlayer newPlayer) {
        List<GamePlayer> players = context.getPlayers();
        if (players.contains(newPlayer)) {
            throw new GameException(GameError.PLAYER_ALREADY_IN_GAME);
        }
        players.add(newPlayer);
        return this;
    }

}
