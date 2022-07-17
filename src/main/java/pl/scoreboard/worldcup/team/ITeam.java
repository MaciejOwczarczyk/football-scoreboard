package pl.scoreboard.worldcup.team;

import pl.scoreboard.worldcup.person.IPerson;

import java.util.Set;

public interface ITeam {

    Set<IPerson> getPlayers();

    void setCity(String city);

    void setCountry(String country);

    Set<IPerson> getStaff();

    void setStaff(Set<IPerson> staff);

    String getCity();

    String getCountry();

    boolean isCurrentlyInGame();

    void setCurrentlyInGame(boolean currentlyInGame);

    void setPlayers(Set<IPerson> players);

    void addPlayerToATeam(IPerson player);

    void removePlayerFromATeam(IPerson player);

    void addStaffToATeam(IPerson player);

    void removeStaffFromATeam(IPerson player);

    String getTeamName();

}
