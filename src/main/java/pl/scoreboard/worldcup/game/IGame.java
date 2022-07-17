package pl.scoreboard.worldcup.game;

import pl.scoreboard.worldcup.teaminagame.ITeamGame;

import java.sql.Timestamp;

public interface IGame {

    GamePhase getGamePhase();

    void setGamePhase(GamePhase gamePhase);

    Timestamp getGameStart();

    Timestamp getGameFinish();

    void setGameStart(Timestamp gameStart);

    void setGameFinish(Timestamp gameFinish);

    ITeamGame getHomeTeam();

    ITeamGame getAwayTeam();

    void updateScore(int scoreHomeTeam, int scoreAwayTeam);

    int getTotalScore();

}
