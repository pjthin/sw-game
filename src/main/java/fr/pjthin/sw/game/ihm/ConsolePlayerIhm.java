package fr.pjthin.sw.game.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pjthin.sw.game.core.GameCivilization;
import fr.pjthin.sw.game.core.GamePlayer;
import fr.pjthin.sw.game.core.PlayerIhm;

public class ConsolePlayerIhm implements PlayerIhm {

    private GamePlayer toPlayer;

    @Override
    public void init(GamePlayer toPlayer) {
        this.toPlayer = toPlayer;
        System.out.println("Bienvenue " + toPlayer.getPseudo());
    }

    private boolean isANumberBetween(String choice, int from, int to) {
        if (choice.matches("[0-9]+")) {
            int value = Integer.parseInt(choice);
            return from <= value && to > value;
        }
        return false;
    }

    @Override
    public GameCivilization choseCivilization(List<GameCivilization> allCivilizations) {
        System.out.println(toPlayer.getPseudo() + ", vous devez choisir : ");
        allCivilizations.forEach(choice -> System.out.println(allCivilizations.indexOf(choice) + "- "
                + choice.toString()));
        System.out.println("");
        return getSelections(allCivilizations);
    }

    private <T> T getSelections(List<T> allChoice) {
        String choice = null;
        do {
            if (choice != null) {
                System.out.println("Je n'ai pas compris votre choix ?\nMerci de bien choisir : ");
            }
            choice = GetScanner.instance.next();
        } while (!isANumberBetween(choice, 0, allChoice.size()));
        return allChoice.get(Integer.parseInt(choice));
    }

    private static final class GetScanner {
        static final Scanner instance = new Scanner(System.in);
    }
}
