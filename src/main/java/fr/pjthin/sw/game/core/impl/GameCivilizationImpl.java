package fr.pjthin.sw.game.core.impl;

import java.util.List;

import fr.pjthin.sw.game.core.Civilization;
import fr.pjthin.sw.game.core.GameArea;
import fr.pjthin.sw.game.core.GameCivilization;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.Power;

class GameCivilizationImpl implements GameCivilization {

    private final String civilizationName;
    private GamePlayer gameOwner;
    private int costToSelectThisCivilization;

    public GameCivilizationImpl(String civilizationName) {
        this.civilizationName = civilizationName;
    }

    @Override
    public Civilization civilization() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Power power() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<GameArea> conqueredAreas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void decline() {
        // TODO Auto-generated method stub

    }

    @Override
    public int countVitoryPoints() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return civilizationName;
    }

    @Override
    public void setGameOwner(GamePlayer owner) {
        this.gameOwner = owner;
    }

    @Override
    public GamePlayer getGameOwner() {
        return gameOwner;
    }

    @Override
    public void setSelectionCost(int costToSelectThisCivilization) {
        this.costToSelectThisCivilization = costToSelectThisCivilization;
    }
}
