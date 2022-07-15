package pl.scoreboard.worldcup.team;

import java.util.Objects;
import java.util.Set;

public class Team implements ITeam {

    private final String teamName;
    private Field field;
    private int score;
    private String city;
    private String country;
    private Set<String> allPlayers;
    private Set<String> lineUp;
    private boolean currentlyInGame;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public int getScore() {
        return score;
    }

    public Set<String> getAllPlayers() {
        return allPlayers;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Set<String> getLineUp() {
        return lineUp;
    }

    public void setLineUp(Set<String> lineUp) {
        this.lineUp = lineUp;
    }

    public boolean isCurrentlyInGame() {
        return currentlyInGame;
    }

    public void setCurrentlyInGame(boolean currentlyInGame) {
        this.currentlyInGame = currentlyInGame;
    }

    public void setAllPlayers(Set<String> allPlayers) {
        this.allPlayers = allPlayers;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        if (Objects.nonNull(teamName)) {
            result = prime * result + teamName.hashCode();

        }
        if (Objects.nonNull(field)) {
            result = prime * result + field.hashCode();
        }
        result = prime * result + score;
        if (Objects.nonNull(allPlayers)) {
            result = prime * result + allPlayers.hashCode();
        }
        if (Objects.nonNull(city)) {
            result = prime * result + city.hashCode();
        }
        if (Objects.nonNull(country)) {
            result = prime * result + country.hashCode();
        }
        if (Objects.nonNull(lineUp)) {
            result = prime * result + lineUp.hashCode();
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
        boolean homeCodeEquals = this.field == other.field;
        boolean scoreCodeEquals = this.score == other.getScore();
        boolean playersCodeEquals = (this.allPlayers == null && other.getAllPlayers() == null) || (this.allPlayers != null && this.allPlayers.equals(other.getAllPlayers()));
        boolean cityCodeEquals = (this.city == null && other.getCity() == null) || (this.city != null && this.city.equals(other.getCity()));
        boolean countryCodeEquals = (this.country == null && other.getCountry() == null) || (this.country != null && this.country.equals(other.getCountry()));
        boolean lineUpCodeEquals = (this.lineUp == null && other.getLineUp() == null) || (this.lineUp != null && this.lineUp == other.getLineUp());
        boolean currentlyInGameCodeEquals = this.isCurrentlyInGame() == other.isCurrentlyInGame();
        return teamNameCodeEquals && homeCodeEquals && scoreCodeEquals && playersCodeEquals && cityCodeEquals && countryCodeEquals && lineUpCodeEquals && currentlyInGameCodeEquals;
    }

    @Override
    public void changePlayerInAGame(String oldPlayer, String newPlayer) {
        if (Boolean.TRUE.equals(this.currentlyInGame)) {
            lineUp.remove(oldPlayer);
            lineUp.add(newPlayer);
        }
    }

    @Override
    public void addPlayerToATeam(String player) {
        if (Objects.nonNull(this.getAllPlayers())) {
            this.getAllPlayers().add(player);
        }
    }

    @Override
    public void removePlayerFromATeam(String player) {
        if (Objects.nonNull(this.getAllPlayers())) {
            this.getAllPlayers().remove(player);
        }
    }
}
