package fr.pjthin.sw.game;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import java.util.concurrent.CompletableFuture;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pjthin.sw.game.core.Game;
import fr.pjthin.sw.game.core.GameContext;
import fr.pjthin.sw.game.core.GameException;
import fr.pjthin.sw.game.core.GameException.GameError;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.GameProcessor;
import fr.pjthin.sw.game.core.impl.AbstractFactory;
import fr.pjthin.sw.game.ihm.ConsolePlayerIhm;

public class CreateGameTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateGameTest.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test1PlayerAddedTwice() {
        expectGameException(GameError.PLAYER_ALREADY_IN_GAME);
        GamePlayer newPlayer1 = AbstractFactory.createPlayer("newPlayer1", new ConsolePlayerIhm());
        AbstractFactory.createContextBuilder().addPlayer(newPlayer1).addPlayer(newPlayer1).build();
    }

    private void expectGameException(GameError error) {
        thrown.expect(GameException.class);
        thrown.expect(hasProperty("error", is(error)));
    }

    @Test
    public void test2PlayerParty() {
        GamePlayer newPlayer1 = AbstractFactory.createPlayer("newPlayer1", new ConsolePlayerIhm());
        GamePlayer newPlayer2 = AbstractFactory.createPlayer("newPlayer2", new ConsolePlayerIhm());
        GameContext context = AbstractFactory.createContextBuilder().addPlayer(newPlayer1).addPlayer(newPlayer2)
                .build();
        Game game = AbstractFactory.createGame(context);
        CompletableFuture<Game> result = GameProcessor.instance().launch(game);
        // try {
        // Thread.sleep(15000);
        // } catch (InterruptedException e) {
        // LOGGER.error(e.getMessage(), e);
        // }
        result.exceptionally(t -> {
            LOGGER.error(t.getMessage(), t);
            return null;
        }).join();
    }

    @Test
    public void testLaunchPartyTwice() {
        expectGameException(GameError.GAME_ALREADY_STARTED);
        GamePlayer newPlayer1 = AbstractFactory.createPlayer("newPlayer1", new ConsolePlayerIhm());
        GamePlayer newPlayer2 = AbstractFactory.createPlayer("newPlayer2", new ConsolePlayerIhm());
        GameContext context = AbstractFactory.createContextBuilder().addPlayer(newPlayer1).addPlayer(newPlayer2)
                .build();
        Game game = AbstractFactory.createGame(context);
        CompletableFuture<Game> result1 = GameProcessor.instance().launch(game);
        CompletableFuture<Game> result2 = GameProcessor.instance().launch(game);
        result1.cancel(true);
        result2.cancel(true);
    }

    public static void main(String[] args) {
        GamePlayer newPlayer1 = AbstractFactory.createPlayer("newPlayer1", new ConsolePlayerIhm());
        GamePlayer newPlayer2 = AbstractFactory.createPlayer("newPlayer2", new ConsolePlayerIhm());
        GameContext context = AbstractFactory.createContextBuilder().addPlayer(newPlayer1).addPlayer(newPlayer2)
                .build();
        Game game = AbstractFactory.createGame(context);
        CompletableFuture<Game> result = GameProcessor.instance().launch(game);
        result.exceptionally(t -> {
            LOGGER.error(t.getMessage(), t);
            return null;
        }).join();
    }
}