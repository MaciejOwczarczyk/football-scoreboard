package pl.scoreboard.worldcup.team;

public interface ITeam {

    void changePlayerInAGame(String oldPlayer, String newPlayer);
    void addPlayerToATeam(String player);
    void removePlayerFromATeam(String player);

}
