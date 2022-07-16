package pl.scoreboard.worldcup.team;

import pl.scoreboard.worldcup.person.IPerson;

public interface ITeam {

    void addPlayerToATeam(IPerson player);
    void removePlayerFromATeam(IPerson player);
    void addStaffToATeam(IPerson player);
    void removeStaffFromATeam(IPerson player);

}
