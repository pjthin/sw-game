package fr.pjthin.sw.game.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import fr.pjthin.sw.game.core.GameException.GameError;

public class GameProcessor {

    private static final GameProcessor instance = new GameProcessor();

    public static GameProcessor instance() {
        return instance;
    }

    private final Map<Game, CompletableFuture<Game>> launchedGames;

    private GameProcessor() {
        this.launchedGames = new HashMap<>();
    }

    private Supplier<Game> get(Game game) {
        return () -> run(game);
    }

    private Game run(Game game) {
        while (!game.endded()) {
            game.playRound();
        }
        return game;
    }

    public CompletableFuture<Game> launch(Game newGame) {
        if (launchedGames.containsKey(newGame)) {
            throw new GameException(GameError.GAME_ALREADY_STARTED, newGame);
        }
        CompletableFuture<Game> completableFuture = CompletableFuture.supplyAsync(get(newGame));
        launchedGames.put(newGame, completableFuture);
        return completableFuture;
    }

}
