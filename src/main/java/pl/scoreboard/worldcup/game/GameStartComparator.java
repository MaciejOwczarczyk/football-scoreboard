package pl.scoreboard.worldcup.game;

import java.util.Comparator;

public class GameStartComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        IGame game1 = (Game) o1;
        IGame game2 = (Game) o2;
        if (game1.getGameStart().equals(game2.getGameStart())) {
            return 0;
        } else if (game1.getGameStart().before(game2.getGameStart())) {
            return 1;
        } else {
            return -1;
        }
    }
}
