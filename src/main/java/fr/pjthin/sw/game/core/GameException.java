package fr.pjthin.sw.game.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private GameError error;
    private List<Object> datas;

    public GameException(Throwable t) {
        this(GameError.UNKNOWN_ERROR, t);
    }

    public GameException(GameError error, Throwable t, Object... datas) {
        super(t);
        this.error = error;
        if (datas != null && datas.length > 0) {
            this.datas = Arrays.asList(datas);
        } else {
            this.datas = new ArrayList<>();
        }
    }

    public GameException(GameError error, Object... datas) {
        this(error, null, datas);
    }

    public GameError getError() {
        return this.error;
    }

    public List<Object> getDatas() {
        return this.datas;
    }

    public static enum GameError {
        UNKNOWN_ERROR, PLAYER_ALREADY_IN_GAME, GAME_ALREADY_STARTED;
    }
}
