package pl.scoreboard.worldcup.team;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.scoreboard.worldcup.person.IPerson;
import pl.scoreboard.worldcup.person.Player;
import pl.scoreboard.worldcup.person.Staff;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
class TeamTest {

    @DisplayName("Should check contract between hashcode() and equals()")
    @Test
    void shouldCheckEqualsAndHashCodeContract() {
        EqualsVerifier.forClass(Team.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @DisplayName("Should add a new player to the team")
    @Test
    void shouldAddPlayerToATeam() {
        ITeam team = mock(Team.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        Set<IPerson> players = Stream.of(player1, player2).collect(Collectors.toSet());
        Set<IPerson> expected = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        team.setPlayers(players);
        team.addPlayerToATeam(player3);
        Set<IPerson> actual = team.getPlayers();
        assertEquals(expected, actual);
    }

    @DisplayName("Should remove a player from the team")
    @Test
    void shouldRemovePlayerFromATeam() {
        ITeam team = mock(Team.class, CALLS_REAL_METHODS);
        IPerson player1 = new Player("Player1", "Player1");
        IPerson player2 = new Player("Player2", "Player2");
        IPerson player3 = new Player("Player3", "Player3");
        Set<IPerson> players = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        Set<IPerson> expected = Stream.of(player1, player2).collect(Collectors.toSet());
        team.setPlayers(players);
        team.removePlayerFromATeam(player3);
        Set<IPerson> actual = team.getPlayers();
        assertEquals(expected, actual);
    }

    @DisplayName("Should add a new staff to the team")
    @Test
    void shouldAddStaffToATeam() {
        ITeam team = mock(Team.class, CALLS_REAL_METHODS);
        IPerson staff = new Staff("Coach1", "Coach");
        IPerson staff2 = new Staff("Physio2", "Physio2");
        IPerson staff3 = new Staff("Physio3", "Physio3");
        Set<IPerson> players = Stream.of(staff, staff2).collect(Collectors.toSet());
        Set<IPerson> expected = Stream.of(staff, staff2, staff3).collect(Collectors.toSet());
        team.setStaff(players);
        team.addStaffToATeam(staff3);
        Set<IPerson> actual = team.getStaff();
        assertEquals(expected, actual);
    }

    @DisplayName("Should remove a staff from the team")
    @Test
    void shouldRemoveStaffFromATeam() {
        ITeam team = mock(Team.class, CALLS_REAL_METHODS);
        IPerson staff = new Staff("Coach1", "Coach");
        IPerson staff2 = new Staff("Physio2", "Physio2");
        IPerson staff3 = new Staff("Physio3", "Physio3");
        Set<IPerson> players = Stream.of(staff, staff2, staff3).collect(Collectors.toSet());
        Set<IPerson> expected = Stream.of(staff, staff2).collect(Collectors.toSet());
        team.setStaff(players);
        team.removeStaffFromATeam(staff3);
        Set<IPerson> actual = team.getStaff();
        assertEquals(expected, actual);
    }


}