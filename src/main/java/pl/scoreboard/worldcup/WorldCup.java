package pl.scoreboard.worldcup;

import com.github.javafaker.Faker;
import pl.scoreboard.worldcup.game.Game;
import pl.scoreboard.worldcup.game.IGame;
import pl.scoreboard.worldcup.person.IPerson;
import pl.scoreboard.worldcup.person.Player;
import pl.scoreboard.worldcup.person.Staff;
import pl.scoreboard.worldcup.scoreboard.IScoreBoard;
import pl.scoreboard.worldcup.scoreboard.ScoreBoard;
import pl.scoreboard.worldcup.team.ITeam;
import pl.scoreboard.worldcup.team.Team;
import pl.scoreboard.worldcup.teaminagame.Host;
import pl.scoreboard.worldcup.teaminagame.ITeamGame;
import pl.scoreboard.worldcup.teaminagame.TeamGame;


public class WorldCup {

    public static void main(String[] args) {
        ITeam team = new Team("Poland");
        ITeam team2 = new Team("Germany");
        ITeam team3 = new Team("France");
        ITeam team4 = new Team("Spain");
        ITeam team5 = new Team("Croatia");
        ITeam team6 = new Team("Portugal");
        ITeam team7 = new Team("Argentina");
        ITeam team8 = new Team("Brazil");

        IPerson[] teamLineup = fakeLineUp();
        IPerson[] teamLineup2 = fakeLineUp();
        IPerson[] teamLineup3 = fakeLineUp();
        IPerson[] teamLineup4 = fakeLineUp();
        IPerson[] teamLineup5 = fakeLineUp();
        IPerson[] teamLineup6 = fakeLineUp();
        IPerson[] teamLineup7 = fakeLineUp();
        IPerson[] teamLineup8 = fakeLineUp();

        IPerson[] bench = fakeBench();
        IPerson[] bench2 = fakeBench();
        IPerson[] bench3 = fakeBench();
        IPerson[] bench4 = fakeBench();
        IPerson[] bench5 = fakeBench();
        IPerson[] bench6 = fakeBench();
        IPerson[] bench7 = fakeBench();
        IPerson[] bench8 = fakeBench();

        IPerson coach = fakeCoach();
        IPerson coach2 = fakeCoach();
        IPerson coach3 = fakeCoach();
        IPerson coach4 = fakeCoach();
        IPerson coach5 = fakeCoach();
        IPerson coach6 = fakeCoach();
        IPerson coach7 = fakeCoach();
        IPerson coach8 = fakeCoach();


        ITeamGame homeTeam = new TeamGame(team, Host.HOME_TEAM, teamLineup, bench, coach);
        ITeamGame awayTeam = new TeamGame(team2, Host.AWAY_TEAM, teamLineup2, bench2, coach2);

        ITeamGame homeTeam2 = new TeamGame(team3, Host.HOME_TEAM, teamLineup3, bench3, coach3);
        ITeamGame awayTeam2 = new TeamGame(team4, Host.AWAY_TEAM, teamLineup4, bench4, coach4);

        ITeamGame homeTeam3 = new TeamGame(team5, Host.HOME_TEAM, teamLineup5, bench5, coach5);
        ITeamGame awayTeam3 = new TeamGame(team6, Host.AWAY_TEAM, teamLineup6, bench6, coach6);

        ITeamGame homeTeam4 = new TeamGame(team7, Host.HOME_TEAM, teamLineup7, bench7, coach7);
        ITeamGame awayTeam4 = new TeamGame(team8, Host.AWAY_TEAM, teamLineup8, bench8, coach8);

        IGame game = new Game(homeTeam, awayTeam);
        IGame game2 = new Game(homeTeam2, awayTeam2);
        IGame game3 = new Game(homeTeam3, awayTeam3);
        IGame game4 = new Game(homeTeam4, awayTeam4);
        IScoreBoard scoreBoard = ScoreBoard.getInstance();

        scoreBoard.startAGame(game);
        scoreBoard.startAGame(game2);
        scoreBoard.startAGame(game3);
        scoreBoard.startAGame(game4);

        scoreBoard.getAllGamesScore();

        scoreBoard.updateScore(game2, 10, 1);
        scoreBoard.updateScore(game4, 6, 5);
        scoreBoard.updateScore(game, 3, 3);
        scoreBoard.updateScore(game3, 1, 4);

        scoreBoard.getScore(game2);
        scoreBoard.getScore(game);
        scoreBoard.getScore(game3);
        scoreBoard.getAllGamesScore();

        game.getAwayTeam().giveRedCardToAPlayer(teamLineup2[2]);

        scoreBoard.finishAGame(game);
        scoreBoard.updateScore(game3, 7, 0);
        scoreBoard.getAllGamesScore();

    }

    private static IPerson[] fakeLineUp() {
        IPerson[] teamLineup = new IPerson[11];
        Faker faker = new Faker();
        for (int i = 0; i < teamLineup.length; i++) {
            teamLineup[i] = new Player(faker.name().firstName(), faker.name().lastName());
        }
        return teamLineup;
    }

    private static IPerson[] fakeBench() {
        IPerson[] team = new IPerson[5];
        Faker faker = new Faker();
        for (int i = 0; i < team.length; i++) {
            IPerson player = new Player(faker.name().firstName(), faker.name().lastName());
            team[i] = player;
        }
        return team;
    }

    private static IPerson fakeCoach() {
        Faker faker = new Faker();
        return new Staff(faker.name().firstName(), faker.name().lastName());
    }
}
