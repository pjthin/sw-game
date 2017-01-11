package fr.pjthin.sw.game.core.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pjthin.sw.game.core.Game;
import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.GameStatus;

class GameImpl implements Game {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameImpl.class);

    private final GameContext context;

    public GameImpl(GameContext context) {
        this.context = context;
    }

    @Override
    public boolean endded() {
        return GameStatus.ENDED.equals(context.getGameStatus());
    }

    @Override
    public void playRound() {
        LOGGER.info("Party play!");
        context.getPlayers().forEach(this::choseCivilisation);
    }

    private void choseCivilisation(GamePlayer player) {
        player.choseNewActiveCivilization(player.getIhm().choseCivilization(context.getSelectableCivilizations()));
    }
}
