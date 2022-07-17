package pl.scoreboard.worldcup.game;

import pl.scoreboard.worldcup.teaminagame.ITeamGame;

import java.sql.Timestamp;
import java.util.Objects;

public class Game implements IGame {

    private final ITeamGame homeTeam;
    private final ITeamGame awayTeam;
    private Timestamp gameStart;
    private Timestamp gameFinish;
    private GamePhase gamePhase;

    public Game(ITeamGame homeTeam, ITeamGame awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public GamePhase getGamePhase() {
        return gamePhase;
    }

    @Override
    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

    @Override
    public Timestamp getGameStart() {
        return gameStart;
    }

    @Override
    public Timestamp getGameFinish() {
        return gameFinish;
    }

    @Override
    public void setGameStart(Timestamp gameStart) {
        this.gameStart = gameStart;
    }

    @Override
    public void setGameFinish(Timestamp gameFinish) {
        this.gameFinish = gameFinish;
    }

    @Override
    public ITeamGame getHomeTeam() {
        return homeTeam;
    }

    @Override
    public ITeamGame getAwayTeam() {
        return awayTeam;
    }

    @Override
    public void updateScore(int scoreHomeTeam, int scoreAwayTeam) {
        if (scoreHomeTeam < 0 || scoreAwayTeam < 0) {
            throw new GameUpdateScoreException("Score must be 0 or positive");
        }
        homeTeam.setTeamScore(scoreHomeTeam);
        awayTeam.setTeamScore(scoreAwayTeam);
    }

    @Override
    public int getTotalScore() {
        return this.homeTeam.getTeamScore() + this.awayTeam.getTeamScore();
    }

    @Override
    public String toString() {
        return homeTeam.getTeam().getTeamName() +
                " " +
                homeTeam.getTeamScore() +
                " - " +
                awayTeam.getTeam().getTeamName() +
                " " +
                awayTeam.getTeamScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }

        Game other = (Game) o;
        boolean homeTeamCodeEquals = (this.homeTeam == null && other.getHomeTeam() == null) || (this.homeTeam != null && this.homeTeam.equals(other.getHomeTeam()));
        boolean awayTeamCodeEquals = (this.awayTeam == null && other.getAwayTeam() == null) || (this.awayTeam != null && this.awayTeam.equals(other.getAwayTeam()));
        boolean gameStartCodeEquals = (this.gameStart == null && other.getGameStart() == null) || (this.gameStart != null && this.gameStart.equals(other.getGameStart()));
        boolean gameFinishCodeEquals = (this.gameFinish == null && other.getGameFinish()== null) || (this.gameFinish != null && this.gameFinish.equals(other.getGameFinish()));
        boolean gamePhaseCodeEquals = (this.gamePhase == null && other.getGamePhase() == null) || (this.gamePhase != null && this.gamePhase.equals(other.getGamePhase()));
        return homeTeamCodeEquals && awayTeamCodeEquals && gameStartCodeEquals && gameFinishCodeEquals && gamePhaseCodeEquals;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(homeTeam)) {
            result = prime * result + homeTeam.hashCode();
        }
        if (Objects.nonNull(awayTeam)) {
            result = prime * result + awayTeam.hashCode();
        }
        if (Objects.nonNull(gameStart)) {
            result = prime * result + gameStart.hashCode();
        }
        if (Objects.nonNull(gameFinish)) {
            result = prime * result + gameFinish.hashCode();
        }
        if (Objects.nonNull(gamePhase)) {
            result = prime * result + gamePhase.hashCode();
        }
        return result;
    }
}
