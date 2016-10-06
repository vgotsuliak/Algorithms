package arrays;

import java.util.Random;

public class TeamMatch {

    public static final int TEAMS_COUNT = 16;

    public static void main(String[] args) {
        Integer[][] teamMatches = new Integer[TEAMS_COUNT][TEAMS_COUNT];

        for (int i = 0; i < teamMatches.length; i++) {
            for (int j = 0; j < teamMatches[i].length; j++) {
                if (i != j) {
                    teamMatches[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 300; i++) {
            if (i % 2 > 0) {
                int team1 = new Random(System.nanoTime()).nextInt(TEAMS_COUNT);
                int team2 = new Random(System.nanoTime()).nextInt(TEAMS_COUNT);

                if (team1 != team2) {
                    teamMatches[team1][team2] = 1;
                    teamMatches[team2][team1] = 1;
                }
            } else {
                int queryTeam1 = new Random(System.nanoTime()).nextInt(TEAMS_COUNT);
                int queryTeam2 = new Random(System.nanoTime()).nextInt(TEAMS_COUNT);

                if (queryTeam1 != queryTeam2) {
                    System.out.println(String.format("Did team %d play with team %d - %d", queryTeam1, queryTeam2, teamMatches[queryTeam1][queryTeam2]));
                }
            }
        }

        printArray(teamMatches);
    }

    private static void printArray(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(String.format("%5d", array[i][j]));
            }
        }
    }



}
