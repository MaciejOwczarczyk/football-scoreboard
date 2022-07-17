package pl.scoreboard.worldcup.game;

import java.util.Comparator;

public class TotalScoreComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        IGame game1 = (Game) o1;
        IGame game2 = (Game) o2;
        return Integer.compare(game2.getTotalScore(), game1.getTotalScore());
    }
}
