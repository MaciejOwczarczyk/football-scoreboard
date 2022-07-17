package pl.scoreboard.worldcup.teaminagame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.scoreboard.worldcup.person.IPerson;
import pl.scoreboard.worldcup.person.Person;
import pl.scoreboard.worldcup.person.Player;
import pl.scoreboard.worldcup.team.ITeam;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class TeamGameTest {

    @Mock
    ITeam team;
    @Mock
    IPerson coach;

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    void shouldCheckEqualsAndHashCodeContract() {
        Host host = Host.HOME_TEAM;
        IPerson[] lineup = new Person[0];
        ITeamGame teamGame = new TeamGame(team, host, lineup, lineup, coach);
        ITeamGame teamGame1 = new TeamGame(team, host, lineup, lineup, coach);
        int hasCode = teamGame.hashCode();
        int hasCode1 = teamGame1.hashCode();
        assertThat(Integer.compare(hasCode1, hasCode), is(0));
    }

    @DisplayName("Should substitute player")
    @Test
    void shouldSubstitutePlayer() {
        TeamGame teamGame = mock(TeamGame.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        IPerson[] lineup = new IPerson[]{player1, player2};
        IPerson[] bench = new IPerson[]{player3};
        teamGame.setSubstituteCounter(0);
        teamGame.setLineUp(lineup);
        teamGame.setBench(bench);
        teamGame.substitute(player1, player3);
        IPerson[] expectedLineUp = new IPerson[]{player2, player3};
        IPerson[] expectedBench  = new IPerson[]{player1};
        IPerson[] actualLineUp = teamGame.getLineUp();
        IPerson[] actualBench = teamGame.getBench();
        assertArrayEquals(expectedLineUp, actualLineUp);
        assertArrayEquals(expectedBench, actualBench);
    }

    @DisplayName("Should not substitute player")
    @Test
    void shouldNotSubstitutePlayer() {
        TeamGame teamGame = mock(TeamGame.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        IPerson[] lineup = new IPerson[]{player1, player2};
        IPerson[] bench = new IPerson[]{player3};
        teamGame.setSubstituteCounter(6);
        teamGame.setLineUp(lineup);
        teamGame.setBench(bench);
        teamGame.substitute(player1, player3);
        IPerson[] expectedLineUp = new IPerson[]{player1, player2};
        IPerson[] expectedBench  = new IPerson[]{player3};
        IPerson[] actualLineUp = teamGame.getLineUp();
        IPerson[] actualBench = teamGame.getBench();
        assertArrayEquals(expectedLineUp, actualLineUp);
        assertArrayEquals(expectedBench, actualBench);
    }

    @DisplayName("Should give red card to a player")
    @Test
    void shouldGiveRedCardToAPlayer() {
        TeamGame teamGame = mock(TeamGame.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        IPerson[] lineup = new IPerson[]{player1, player2, player3};
        teamGame.setLineUp(lineup);
        teamGame.giveRedCardToAPlayer(player1);
        IPerson[] expectedLineUp = new IPerson[]{player2, player3};
        IPerson[] actualLineUp = teamGame.getLineUp();
        Card expected = Card.RED_CARD;
        Card actual = teamGame.getCards().get(player1).get(0);
        assertArrayEquals(expectedLineUp, actualLineUp);
        assertEquals(expected, actual);
    }

    @DisplayName("Should give first yellow card to a player")
    @Test
    void shouldGiveFirstYellowCardToAPlayer() {
        TeamGame teamGame = mock(TeamGame.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        IPerson[] lineup = new IPerson[]{player1, player2, player3};
        teamGame.setLineUp(lineup);
        teamGame.giveYellowCardToAPlayer(player1);
        IPerson[] expectedLineUp = new IPerson[]{player1, player2, player3};
        IPerson[] actualLineUp = teamGame.getLineUp();
        Map<IPerson, List<Card>> cards = teamGame.getCards();
        Card expected = Card.YELLOW_CARD;
        Card actual = cards.get(player1).get(0);
        assertArrayEquals(expectedLineUp, actualLineUp);
        assertEquals(expected, actual);
    }

    @DisplayName("Should give second yellow card to a player")
    @Test
    void shouldGiveSecondYellowCardToAPlayer() {
        TeamGame teamGame = mock(TeamGame.class, CALLS_REAL_METHODS);

        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        IPerson[] lineup = new IPerson[]{player1, player2, player3};
        teamGame.setLineUp(lineup);

        teamGame.giveYellowCardToAPlayer(player1);
        teamGame.giveYellowCardToAPlayer(player1);
        IPerson[] expectedLineUp = new IPerson[]{player2, player3};
        IPerson[] actualLineUp = teamGame.getLineUp();
        Map<IPerson, List<Card>> cards = teamGame.getCards();
        Card expectedCard = Card.YELLOW_CARD;
        Card actualCard = cards.get(player1).get(0);
        int expectedYellowCards = 2;
        int actualYellowCards = (int) cards.get(player1).stream().filter(o -> o.equals(Card.YELLOW_CARD)).count();
        int expectedRedCards = 1;
        int actualRedCards = (int) cards.get(player1).stream().filter(o -> o.equals(Card.RED_CARD)).count();
        assertArrayEquals(expectedLineUp, actualLineUp);
        assertEquals(expectedCard, actualCard);
        assertEquals(expectedYellowCards, actualYellowCards);
        assertEquals(expectedRedCards, actualRedCards);
    }

}