package pl.scoreboard.worldcup.teaminagame;

import pl.scoreboard.worldcup.person.Person;

public interface ITeamGame {

    void substitute(Person person1, Person person2);
    void giveRedCardToAPlayer(Person person);
    void giveYellowCardToAPlayer(Person person);
    void addScore();
    void removeScore();

}
