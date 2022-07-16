package pl.scoreboard.worldcup.team;

import pl.scoreboard.worldcup.person.Person;

public interface ITeam {

    void addPlayerToATeam(Person player);
    void removePlayerFromATeam(Person player);
    void addStaffToATeam(Person player);
    void removeStaffFromATeam(Person player);

}
