package pl.scoreboard.worldcup.teaminagame;

import pl.scoreboard.worldcup.person.Person;
import pl.scoreboard.worldcup.team.ITeam;

import java.util.*;

public class TeamGame implements ITeamGame {

    private final ITeam team;
    private final Host host;
    private Person[] lineUp;
    private Person[] bench;
    private int substituteCounter;
    private int teamScore;
    private Map<Person, List<Card>> cards;
    private final Person coach;

    public TeamGame(ITeam team, Host host, Person[] lineUp, Person[] bench, Person coach) {
        this.team = team;
        this.host = host;
        this.lineUp = lineUp;
        this.bench = bench;
        this.coach = coach;
        this.teamScore = 0;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setBench(Person[] bench) {
        this.bench = bench;
    }

    public Host getHost() {
        return host;
    }

    public Person[] getLineUp() {
        return lineUp;
    }

    public int getSubstituteCounter() {
        return substituteCounter;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public Person[] getBench() {
        return bench;
    }

    public Map<Person, List<Card>> getCards() {
        return cards;
    }

    public Person getCoach() {
        return coach;
    }

    public void setLineUp(Person[] lineUp) {
        this.lineUp = lineUp;
    }

    public void setSubstituteCounter(int substituteCounter) {
        this.substituteCounter = substituteCounter;
    }

    @Override
    public void substitute(Person person1, Person person2) {
        if (substituteCounter < 5) {
            List<Person> tempBench = new LinkedList<>(List.of(bench));
            tempBench.remove(person2);
            tempBench.add(person1);
            bench = tempBench.toArray(new Person[0]);
            List<Person> tempLineUp = new LinkedList<>(List.of(lineUp));
            tempLineUp.add(person2);
            tempLineUp.remove(person1);
            lineUp = tempLineUp.toArray(new Person[0]);
            substituteCounter++;
        }
    }

    @Override
    public void giveRedCardToAPlayer(Person person) {
        if (Objects.isNull(cards)) cards = new HashMap<>();
        if (this.cards.containsKey(person)) {
            cards.get(person).add(Card.RED_CARD);
        } else {
            List<Card> temp = new LinkedList<>();
            temp.add(Card.RED_CARD);
            cards.put(person, temp);
        }
        List<Person> tempLineUp = new LinkedList<>(List.of(lineUp));
        tempLineUp.remove(person);
        lineUp = tempLineUp.toArray(new Person[0]);
    }

    @Override
    public void giveYellowCardToAPlayer(Person person) {
        if (Objects.isNull(cards)) cards = new HashMap<>();
        if (this.cards.containsKey(person)) {
            if (!this.cards.get(person).contains(Card.RED_CARD)) {
                this.cards.get(person).add(Card.YELLOW_CARD);
                if (this.cards.get(person).stream().filter(o -> o.equals(Card.YELLOW_CARD)).count() == 2) {
                    giveRedCardToAPlayer(person);
                }
            }
        } else {
            List<Card> temp = new LinkedList<>();
            temp.add(Card.YELLOW_CARD);
            cards.put(person, temp);
        }
    }

    @Override
    public void addScore() {
        teamScore++;
    }

    @Override
    public void removeScore() {
        if (teamScore > 0) {
            teamScore--;
        }
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TeamGame)) {
            return false;
        }

        TeamGame other = (TeamGame) o;

        boolean substituteCounterCodeEquals = this.substituteCounter == other.getSubstituteCounter();
        boolean scoreCodeEquals = this.teamScore == other.getTeamScore();
        boolean teamCodeEquals = (this.team == null && other.getTeam() == null) || (this.team != null && this.team.equals(other.getTeam()));
        boolean lineUpCodeEquals = (Objects.isNull(this.lineUp) && Objects.isNull(other.getLineUp())) || (Arrays.equals(this.lineUp, other.getLineUp()));
        boolean benchCodeEquals = (this.bench == null && other.getTeam() == null) || (this.bench != null && Arrays.equals(this.bench, other.getBench()));
        boolean coachCodeEquals = (this.coach == null && other.getCoach() == null) || (this.coach != null && this.coach.equals(other.getCoach()));
        boolean cardsCodeEquals = (this.cards == null && other.getCards() == null) || (this.cards != null && this.cards.equals(other.getCards()));
        boolean hostCodeEquals = (this.host == null && other.getHost() == null) || (this.host != null && this.host.equals(other.getHost()));
        return teamCodeEquals && coachCodeEquals && substituteCounterCodeEquals && scoreCodeEquals && lineUpCodeEquals && benchCodeEquals && cardsCodeEquals && hostCodeEquals;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(team)) result = prime * result + team.hashCode();
        if (Objects.nonNull(host)) result = prime * result + host.hashCode();
        if (Objects.nonNull(lineUp)) result = prime * result + Arrays.hashCode(lineUp);
        if (Objects.nonNull(bench)) result = prime * result + Arrays.hashCode(bench);
        result = prime * result + substituteCounter;
        result = prime * result + teamScore;
        if (Objects.nonNull(cards)) result = prime * result + cards.hashCode();
        if (Objects.nonNull(coach)) result = prime * result + coach.hashCode();
        return result;
    }
}
