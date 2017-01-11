package fr.pjthin.sw.game.core;

import java.util.List;

public interface GameArea {

    GameCivilization getConqueringCivilization();

    List<GameArea> getArroundAreas();

    void attacked(GameCivilization attakingCivilization);

}
