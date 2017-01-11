package fr.pjthin.sw.game.core;

import java.util.List;

public interface GameContext {

    GameMap getMap();

    List<GamePlayer> getPlayers();

    List<GameCivilization> getCivilizations();

    List<GameCivilization> getSelectableCivilizations();

    void removeFromSelectableCivilization(GameCivilization activeCivilization);

    GameStatus getGameStatus();

}
