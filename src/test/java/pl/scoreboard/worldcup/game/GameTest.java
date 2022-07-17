package pl.scoreboard.worldcup.game;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.scoreboard.worldcup.teaminagame.ITeamGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    @Mock
    ITeamGame homeTeam;
    @Mock
    ITeamGame awayTeam;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    public void shouldCheckEqualsAndHashCodeContract() {
        EqualsVerifier.simple().forClass(Game.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @DisplayName("Should update score")
    @Test
    public void shouldUpdateScore() {
        IGame game = new Game(homeTeam, awayTeam);
        int expected = 0;
        int actual = game.getTotalScore();
        game.updateScore(1, 1);
        when(homeTeam.getTeamScore()).thenReturn(1);
        when(awayTeam.getTeamScore()).thenReturn(1);
        int expected2 = 2;
        int actual2 = game.getTotalScore();
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @DisplayName("Should return total initial score")
    @Test
    public void shouldReturnTotalScore() {
        IGame game = new Game(homeTeam, awayTeam);
        int expected = 0;
        int actual = game.getTotalScore();
        assertEquals(expected, actual);
    }
}