package pl.scoreboard.worldcup.teaminagame;

import pl.scoreboard.worldcup.person.IPerson;

public interface ITeamGame {

    void substitute(IPerson person1, IPerson person2);
    void giveRedCardToAPlayer(IPerson person);
    void giveYellowCardToAPlayer(IPerson person);
    void addScore();
    void removeScore();

}
