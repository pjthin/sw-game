package fr.pjthin.sw.game.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pjthin.sw.game.core.GameCivilization;
import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GameMap;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.GameStatus;

class GameContextImpl implements GameContext {

    private final List<GamePlayer> players;
    private GameStatus status;
    private final SelectableCivilizations selectableCivilizations;

    public GameContextImpl() {
        this.players = new ArrayList<>();
        this.status = GameStatus.INIT;
        this.selectableCivilizations = new SelectableCivilizations(6);
    }

    @Override
    public GameMap getMap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GamePlayer> getPlayers() {
        if (GameStatus.INIT.equals(status)) {
            return this.players;
        } else {
            return Collections.unmodifiableList(this.players);
        }
    }

    @Override
    public void removeFromSelectableCivilization(GameCivilization activeCivilization) {
        selectableCivilizations.civilizationHasBeenSelected(activeCivilization);
    }

    @Override
    public List<GameCivilization> getCivilizations() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GameStatus getGameStatus() {
        return this.status;
    }

    @Override
    public List<GameCivilization> getSelectableCivilizations() {
        return selectableCivilizations.getSelectableCivilizations();
    }

}
