package fr.pjthin.sw.game.core;

import java.util.List;

public interface GamePlayer {

    String getPseudo();

    PlayerIhm getIhm();

    GameCivilization getActiveCivilization();

    List<GameCivilization> getDeclineCivilizations();

    void choseNewActiveCivilization(GameCivilization newActiveCivilization);

    void attackArea();
}
