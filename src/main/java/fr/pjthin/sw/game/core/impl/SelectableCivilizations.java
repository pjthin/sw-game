package fr.pjthin.sw.game.core.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import fr.pjthin.sw.game.core.GameCivilization;

public class SelectableCivilizations {

    private LinkedList<GameCivilization> unusedCivilizations;
    private LinkedList<GameCivilization> selectableCivilizations;
    private int maxSelectableCivilization;

    public SelectableCivilizations(int maxSelectableCivilization) {
        this.maxSelectableCivilization = maxSelectableCivilization;
        selectableCivilizations = new LinkedList<>();
        unusedCivilizations = new LinkedList<>();
    }

    public void init(List<GameCivilization> allCivilizations) {
        for (int idx = 0; idx < maxSelectableCivilization && idx < allCivilizations.size(); idx++) {
            selectableCivilizations.addLast(allCivilizations.get(idx));
        }
        if (allCivilizations.size() > maxSelectableCivilization) {
            for (int idx = maxSelectableCivilization; idx < allCivilizations.size(); idx++) {
                unusedCivilizations.addLast(allCivilizations.get(idx));
            }
        }
        recalculateCostCivilization();
    }

    public void civilizationHasBeenSelected(GameCivilization selectedCivilization) {
        if (!selectableCivilizations.contains(selectedCivilization)) {
            throw new IllegalArgumentException("selectedCivilization '" + selectedCivilization + "' is not selectable");
        }
        selectableCivilizations.remove(selectedCivilization);
        if (!unusedCivilizations.isEmpty()) {
            selectableCivilizations.addLast(unusedCivilizations.removeFirst());
        }
        recalculateCostCivilization();
    }

    public List<GameCivilization> getSelectableCivilizations() {
        return Collections.unmodifiableList(selectableCivilizations);
    }

    private void recalculateCostCivilization() {
        final AtomicInteger cost = new AtomicInteger(0);
        selectableCivilizations.forEach(selectableCivilization -> selectableCivilization.setSelectionCost(cost
                .getAndIncrement()));
    }
}
