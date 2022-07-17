package pl.scoreboard.worldcup.scoreboard;

import pl.scoreboard.worldcup.game.IGame;

import java.util.Set;

public interface IScoreBoard  {

    void startAGame(IGame game);

    void updateScore(IGame game, int homeTeamScore, int awayTeamScore);

    void finishAGame(IGame game);

    void getAllGamesScore();

    void getScore(IGame game);

    Set<IGame> getiGames();

}
