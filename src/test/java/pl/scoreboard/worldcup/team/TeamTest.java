package pl.scoreboard.worldcup.team;


import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TeamTest {

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    public void shouldCheckEqualsAndHashCodeContract() {
        EqualsVerifier.forClass(Team.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @DisplayName("Should change player in a game")
    @Test
    public void shouldChangePlayerInAGame() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        team.setCurrentlyInGame(Boolean.TRUE);
        String player1 = "Player1";
        String player2 = "Player2";
        String player3 = "Player3";
        String player4 = "Player4";
        Set<String> lineUp = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        Set<String> expected = Stream.of(player2, player3, player4).collect(Collectors.toSet());
        team.setLineUp(lineUp);
        team.changePlayerInAGame(player1, player4);
        Set<String> actual = team.getLineUp();
        assertEquals(expected, actual);
    }

    @DisplayName("Should not change player in a game")
    @Test
    public void shouldNotChangePlayerInAGame() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        team.setCurrentlyInGame(Boolean.FALSE);
        String player1 = "Player1";
        String player2 = "Player2";
        String player3 = "Player3";
        String player4 = "Player4";
        Set<String> lineUp = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        Set<String> expected = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        team.setLineUp(lineUp);
        team.changePlayerInAGame(player1, player4);
        Set<String> actual = team.getLineUp();
        assertEquals(expected, actual);
    }

    @DisplayName("Should add a new player to the team")
    @Test
    public void shouldAddPlayerToATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        String player1 = "Player1";
        String player2 = "Player2";
        String player3 = "Player3";
        Set<String> players = Stream.of(player1, player2).collect(Collectors.toSet());
        Set<String> expected = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        team.setAllPlayers(players);
        team.addPlayerToATeam(player3);
        Set<String> actual = team.getAllPlayers();
        assertEquals(expected, actual);
    }

    @DisplayName("Should remove a player from the team")
    @Test
    public void shouldRemovePlayerFromATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        String player1 = "Player1";
        String player2 = "Player2";
        String player3 = "Player3";
        Set<String> players = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        Set<String> expected = Stream.of(player1, player2).collect(Collectors.toSet());
        team.setAllPlayers(players);
        team.removePlayerFromATeam(player3);
        Set<String> actual = team.getAllPlayers();
        assertEquals(expected, actual);
    }
}