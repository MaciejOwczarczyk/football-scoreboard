package pl.scoreboard.worldcup.scoreboard;

import pl.scoreboard.worldcup.game.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard implements IScoreBoard {

    private Set<IGame> iGames;
    private static ScoreBoard INSTANCE;

    private ScoreBoard() {

    }

    public static ScoreBoard getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScoreBoard();
        }
        return INSTANCE;
    }

    @Override
    public void startAGame(IGame game) {
        if (Objects.isNull(iGames)) iGames = new HashSet<>();
        if (!iGames.contains(game)) {
            game.setGameStart(Timestamp.valueOf(LocalDateTime.now()));
            updateGamePhase(game, GamePhase.FIRST_HALF);
            updateScore(game, 0, 0);
            this.iGames.add(game);
        }
    }

    @Override
    public void updateScore(IGame game, int homeTeamScore, int awayTeamScore) {
        if (game.getGamePhase() != null && game.getGamePhase() != GamePhase.FINISHED) {
            game.updateScore(homeTeamScore, awayTeamScore);
        }
    }

    @Override
    public void finishAGame(IGame game) {
        if (game.getGamePhase() != GamePhase.FINISHED) {
            game.setGameFinish(Timestamp.valueOf(LocalDateTime.now()));
            updateGamePhase(game, GamePhase.FINISHED);
            this.iGames.remove(game);
        }
    }

    @Override
    public void getAllGamesScore() {
        Set<IGame> sortedByTotalScore = this.iGames.stream().sorted(new GameStartComparator()).sorted(new TotalScoreComparator()).collect(Collectors.toCollection(LinkedHashSet::new));
        sortedByTotalScore.forEach(o -> System.out.println(o.toString()));
        System.out.println("\n");
    }

    @Override
    public void getScore(IGame game) {
        System.out.println(game.getHomeTeam().getTeam().getTeamName() + " - "
                + game.getAwayTeam().getTeam().getTeamName()
                + ": " + game.getHomeTeam().getTeamScore()
                + " - " + game.getAwayTeam().getTeamScore() + "\n");
    }

    @Override
    public Set<IGame> getiGames() {
        return iGames;
    }

    @Override
    public void updateGamePhase(IGame game, GamePhase gamePhase) {
        if (iGames.contains(game)) {
            game.setGamePhase(gamePhase);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(iGames)) result = prime * result + iGames.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScoreBoard)) {
            return false;
        }
        ScoreBoard other = (ScoreBoard) obj;
        return (this.iGames == null && other.getiGames() == null) || (this.iGames != null && this.iGames.equals(other.getiGames()));
    }
}
