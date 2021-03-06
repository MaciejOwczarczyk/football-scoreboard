package pl.scoreboard.worldcup.team;

import pl.scoreboard.worldcup.person.IPerson;

import java.util.Objects;
import java.util.Set;

public class Team implements ITeam {

    private final String teamName;
    private String city;
    private String country;
    private Set<IPerson> players;
    private Set<IPerson> staff;
    private boolean currentlyInGame;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public Set<IPerson> getPlayers() {
        return players;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public Set<IPerson> getStaff() {
        return staff;
    }

    @Override
    public void setStaff(Set<IPerson> staff) {
        this.staff = staff;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public boolean isCurrentlyInGame() {
        return currentlyInGame;
    }

    @Override
    public void setCurrentlyInGame(boolean currentlyInGame) {
        this.currentlyInGame = currentlyInGame;
    }

    @Override
    public void setPlayers(Set<IPerson> players) {
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
    public void addPlayerToATeam(IPerson player) {
        if (Objects.nonNull(this.getPlayers())) {
            this.getPlayers().add(player);
        }
    }

    @Override
    public void removePlayerFromATeam(IPerson player) {
        if (Objects.nonNull(this.getPlayers())) {
            this.getPlayers().remove(player);
        }
    }

    @Override
    public void addStaffToATeam(IPerson staff) {
        if (Objects.nonNull(this.getStaff())) {
            this.getStaff().add(staff);
        }
    }

    @Override
    public void removeStaffFromATeam(IPerson staff) {
        if (Objects.nonNull(this.getStaff())) {
            this.getStaff().remove(staff);
        }
    }

}
