package fr.pjthin.sw.game.core;

import java.util.List;

public interface GameCivilization {

    void setGameOwner(GamePlayer owner);

    GamePlayer getGameOwner();

    Civilization civilization();

    Power power();

    List<GameArea> conqueredAreas();

    void decline();

    int countVitoryPoints();

    void setSelectionCost(int costToSelectThisCivilization);

}
