package pl.scoreboard.worldcup.teaminagame;

import pl.scoreboard.worldcup.person.IPerson;
import pl.scoreboard.worldcup.team.ITeam;

import java.util.List;
import java.util.Map;

public interface ITeamGame {

    ITeam getTeam();

    void setBench(IPerson[] bench);

    Host getHost();

    IPerson[] getLineUp();

    int getSubstituteCounter();

    int getTeamScore();

    void setTeamScore(int teamScore);

    IPerson[] getBench();

    Map<IPerson, List<Card>> getCards();

    IPerson getCoach();

    void setLineUp(IPerson[] lineUp);

    void setSubstituteCounter(int substituteCounter);

    void substitute(IPerson person1, IPerson person2);

    void giveRedCardToAPlayer(IPerson person);

    void giveYellowCardToAPlayer(IPerson person);


}
