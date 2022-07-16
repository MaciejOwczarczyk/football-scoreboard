package pl.scoreboard.worldcup.team;


import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pl.scoreboard.worldcup.person.Person;
import pl.scoreboard.worldcup.person.Player;
import pl.scoreboard.worldcup.person.Staff;

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

    @DisplayName("Should add a new player to the team")
    @Test
    public void shouldAddPlayerToATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        Person player1 = new Player("Player1", "Player1");
        Person player2 = new Player("Player2", "Player2");
        Person player3 = new Player("Player3", "Player3");
        Set<Person> players = Stream.of(player1, player2).collect(Collectors.toSet());
        Set<Person> expected = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        team.setPlayers(players);
        team.addPlayerToATeam(player3);
        Set<Person> actual = team.getPlayers();
        assertEquals(expected, actual);
    }

    @DisplayName("Should remove a player from the team")
    @Test
    public void shouldRemovePlayerFromATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        Person player1 = new Player("Player1", "Player1");
        Person player2 = new Player("Player2", "Player2");
        Person player3 = new Player("Player3", "Player3");
        Set<Person> players = Stream.of(player1, player2, player3).collect(Collectors.toSet());
        Set<Person> expected = Stream.of(player1, player2).collect(Collectors.toSet());
        team.setPlayers(players);
        team.removePlayerFromATeam(player3);
        Set<Person> actual = team.getPlayers();
        assertEquals(expected, actual);
    }

    @DisplayName("Should add a new staff to the team")
    @Test
    public void shouldAddStaffToATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        Person staff = new Staff("Coach1", "Coach");
        Person staff2 = new Staff("Physio2", "Physio2");
        Person staff3 = new Staff("Physio3", "Physio3");
        Set<Person> players = Stream.of(staff, staff2).collect(Collectors.toSet());
        Set<Person> expected = Stream.of(staff, staff2, staff3).collect(Collectors.toSet());
        team.setStaff(players);
        team.addStaffToATeam(staff3);
        Set<Person> actual = team.getStaff();
        assertEquals(expected, actual);
    }

    @DisplayName("Should remove a staff from the team")
    @Test
    public void shouldRemoveStaffFromATeam() {
        Team team = mock(Team.class, CALLS_REAL_METHODS);
        Person staff = new Staff("Coach1", "Coach");
        Person staff2 = new Staff("Physio2", "Physio2");
        Person staff3 = new Staff("Physio3", "Physio3");
        Set<Person> players = Stream.of(staff, staff2, staff3).collect(Collectors.toSet());
        Set<Person> expected = Stream.of(staff, staff2).collect(Collectors.toSet());
        team.setStaff(players);
        team.removeStaffFromATeam(staff3);
        Set<Person> actual = team.getStaff();
        assertEquals(expected, actual);
    }


}