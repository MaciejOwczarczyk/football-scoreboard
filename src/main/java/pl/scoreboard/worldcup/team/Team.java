package pl.scoreboard.worldcup.team;

import pl.scoreboard.worldcup.person.Person;

import java.util.Objects;
import java.util.Set;

public class Team implements ITeam {

    private final String teamName;
    private String city;
    private String country;
    private Set<Person> players;
    private Set<Person> staff;
    private boolean currentlyInGame;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Set<Person> getPlayers() {
        return players;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Person> getStaff() {
        return staff;
    }

    public void setStaff(Set<Person> staff) {
        this.staff = staff;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public boolean isCurrentlyInGame() {
        return currentlyInGame;
    }

    public void setCurrentlyInGame(boolean currentlyInGame) {
        this.currentlyInGame = currentlyInGame;
    }

    public void setPlayers(Set<Person> players) {
        this.players = players;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(teamName)) {
            result = prime * result + teamName.hashCode();

        }
        if (Objects.nonNull(players)) {
            result = prime * result + players.hashCode();
        }
        if (Objects.nonNull(staff)) {
            result = prime * result + staff.hashCode();
        }
        if (Objects.nonNull(city)) {
            result = prime * result + city.hashCode();
        }
        if (Objects.nonNull(country)) {
            result = prime * result + country.hashCode();
        }
        result = prime * result + Boolean.hashCode(isCurrentlyInGame());
        return result;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Team)) {
            return false;
        }
        Team other = (Team) obj;
        boolean teamNameCodeEquals = (this.teamName == null && other.getTeamName() == null) || (this.teamName != null && this.teamName.equals(other.getTeamName()));
        boolean playersCodeEquals = (this.players == null && other.getPlayers() == null) || (this.players != null && this.players.equals(other.getPlayers()));
        boolean staffCodeEquals = (this.staff == null && other.getStaff() == null) || (this.staff != null && this.staff.equals(other.getStaff()));
        boolean cityCodeEquals = (this.city == null && other.getCity() == null) || (this.city != null && this.city.equals(other.getCity()));
        boolean countryCodeEquals = (this.country == null && other.getCountry() == null) || (this.country != null && this.country.equals(other.getCountry()));
        boolean currentlyInGameCodeEquals = this.isCurrentlyInGame() == other.isCurrentlyInGame();
        return teamNameCodeEquals && playersCodeEquals && cityCodeEquals && countryCodeEquals && currentlyInGameCodeEquals && staffCodeEquals;
    }

    @Override
    public void addPlayerToATeam(Person player) {
        if (Objects.nonNull(this.getPlayers())) {
            this.getPlayers().add(player);
        }
    }

    @Override
    public void removePlayerFromATeam(Person player) {
        if (Objects.nonNull(this.getPlayers())) {
            this.getPlayers().remove(player);
        }
    }

    @Override
    public void addStaffToATeam(Person staff) {
        if (Objects.nonNull(this.getStaff())) {
            this.getStaff().add(staff);
        }
    }

    @Override
    public void removeStaffFromATeam(Person staff) {
        if (Objects.nonNull(this.getStaff())) {
            this.getStaff().remove(staff);
        }
    }
}
