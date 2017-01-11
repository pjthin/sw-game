package fr.pjthin.sw.game.core;

import java.util.List;

public interface PlayerIhm {

    void init(GamePlayer toPlayer);

    GameCivilization choseCivilization(List<GameCivilization> allCivilizations);

}
