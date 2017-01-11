package fr.pjthin.sw.game.core.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pjthin.sw.game.core.GameCivilization;
import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.PlayerIhm;

class GamePlayerImpl implements GamePlayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GamePlayer.class);

    private final String pseudo;
    private final PlayerIhm ihm;

    private GameCivilization activeCivilization;

    private GameContext context;

    public GamePlayerImpl(String pseudo, PlayerIhm ihm) {
        this.pseudo = pseudo;
        this.ihm = ihm;
        ihm.init(this);
    }

    @Override
    public String getPseudo() {
        return pseudo;
    }

    @Override
    public PlayerIhm getIhm() {
        return ihm;
    }

    @Override
    public GameCivilization getActiveCivilization() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GameCivilization> getDeclineCivilizations() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void choseNewActiveCivilization(GameCivilization newActiveCivilization) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(this + " chose new active civilization " + newActiveCivilization);
        }
        if (this.activeCivilization != null) {
            this.activeCivilization.decline();
        }
        this.activeCivilization = newActiveCivilization;
        this.activeCivilization.setGameOwner(this);
        this.context.removeFromSelectableCivilization(this.activeCivilization);
    }

    @Override
    public void attackArea() {
        // TODO Auto-generated method stub

    }

}
