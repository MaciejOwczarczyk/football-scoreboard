package pl.scoreboard.worldcup.scoreboard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.scoreboard.worldcup.game.Game;
import pl.scoreboard.worldcup.game.IGame;
import pl.scoreboard.worldcup.team.ITeam;
import pl.scoreboard.worldcup.teaminagame.ITeamGame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScoreBoardTest {

    @Mock
    IGame game;
    @Mock
    ITeamGame homeTeam;
    @Mock
    ITeamGame awayTeam;
    @Mock
    ITeamGame homeTeam2;
    @Mock
    ITeamGame awayTeam2;
    @Mock
    ITeam home;
    @Mock
    ITeam away;
    @Mock
    ITeam home2;
    @Mock
    ITeam away2;


    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    void shouldCheckEqualsAndHashCodeContract() {
        IScoreBoard scoreBoard = ScoreBoard.getInstance();
        IScoreBoard scoreBoard1 = ScoreBoard.getInstance();
        int hash = scoreBoard.hashCode();
        int hash1 = scoreBoard1.hashCode();
        assertThat(Integer.compare(hash, hash1), is(0));
        assertEquals(scoreBoard, scoreBoard1);
    }
    
    @DisplayName("Should start a game")
    @Test
    void shouldStartAGame() {
        ScoreBoard scoreBoard = mock(ScoreBoard.class, CALLS_REAL_METHODS);
        scoreBoard.startAGame(game);
        Set<IGame> expected = Set.of(game);
        Set<IGame> actual = scoreBoard.getiGames();
        assertEquals(expected, actual);
    }

    @Test
    void updateScore() {
        IScoreBoard scoreBoard = mock(ScoreBoard.class, CALLS_REAL_METHODS);
        IGame game = new Game(homeTeam, awayTeam);
        scoreBoard.startAGame(game);
        scoreBoard.updateScore(game, 2, 1);
        when(game.getHomeTeam().getTeamScore()).thenReturn(2);
        when(game.getAwayTeam().getTeamScore()).thenReturn(1);
        int expectedHomeTeamScore = 2;
        int expectedAwayTeamScore = 1;
        int actualHomeTeamScore = game.getHomeTeam().getTeamScore();
        int actualAwayTeamScore = game.getAwayTeam().getTeamScore();
        assertEquals(expectedHomeTeamScore, actualHomeTeamScore);
        assertEquals(expectedAwayTeamScore, actualAwayTeamScore);
    }

    @Test
    void finishAGame() {
        IScoreBoard scoreBoard = mock(ScoreBoard.class, CALLS_REAL_METHODS);
        scoreBoard.startAGame(game);
        scoreBoard.finishAGame(game);
        assertFalse(scoreBoard.getiGames().contains(game));
    }

    @Test
    void getAllGamesScore() {
        IScoreBoard scoreBoard = mock(ScoreBoard.class, CALLS_REAL_METHODS);
        IGame game = new Game(homeTeam, awayTeam);
        IGame game1 = new Game(homeTeam2, awayTeam2);
        scoreBoard.startAGame(game);
        scoreBoard.startAGame(game1);
        when(homeTeam.getTeam()).thenReturn(home);
        when(awayTeam.getTeam()).thenReturn(away);
        when(homeTeam.getTeam().getTeamName()).thenReturn("Poland");
        when(awayTeam.getTeam().getTeamName()).thenReturn("Germany");
        when(homeTeam.getTeamScore()).thenReturn(2);
        when(awayTeam.getTeamScore()).thenReturn(2);
        when(homeTeam2.getTeam()).thenReturn(home2);
        when(awayTeam2.getTeam()).thenReturn(away2);
        when(homeTeam2.getTeam().getTeamName()).thenReturn("France");
        when(awayTeam2.getTeam().getTeamName()).thenReturn("England");
        when(homeTeam2.getTeamScore()).thenReturn(1);
        when(awayTeam2.getTeamScore()).thenReturn(1);
        System.setOut(new PrintStream(outputStreamCaptor));
        scoreBoard.getAllGamesScore();
        assertEquals("Poland 2 - Germany 2\nFrance 1 - England 1", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

    @Test
    void getScore() {
        IScoreBoard scoreBoard = mock(ScoreBoard.class, CALLS_REAL_METHODS);
        IGame game1 = new Game(homeTeam2, awayTeam2);
        scoreBoard.startAGame(game1);
        when(homeTeam2.getTeam()).thenReturn(home2);
        when(awayTeam2.getTeam()).thenReturn(away2);
        when(homeTeam2.getTeam().getTeamName()).thenReturn("France");
        when(awayTeam2.getTeam().getTeamName()).thenReturn("England");
        when(homeTeam2.getTeamScore()).thenReturn(1);
        when(awayTeam2.getTeamScore()).thenReturn(1);
        System.setOut(new PrintStream(outputStreamCaptor));
        scoreBoard.getScore(game1);
        assertEquals("France - England: 1 - 1", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
}