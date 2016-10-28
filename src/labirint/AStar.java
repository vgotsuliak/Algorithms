package labirint;

public class AStar {

    public static void main(String[] args) {
        int[][] map = new int[10][10];
        map[1][1] = -1; //start point
        map[9][9] = -2; //finish point

        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
        }

        //find starting point
        map[1][1] = 2;

        map = aStar(map, 1, 1);

        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%3d", + map[i][j]);
            }
        }
    }

    public static int[][] aStar(int[][] map, int x, int y) {

        boolean found = false;
        while (!found) {
            makeStep(map, x);


        }



        map = step(map, x, y);
        return map;
    }

    public static int makeStep(int[][] map, int value) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == value) {
                    return ++value;
                }
            }
        }
        return -1;
    }

    public static int[][] step(int[][] map, int x, int y) {
        int nextValue = map[y][x] + 1;
        if (y + 1 < map.length && map[y + 1][x] == 0) {
            map[y + 1][x] = nextValue;
            aStar(map, x, y + 1);
        }
        if (y - 1 >= 0 && map[y - 1][x] == 0) {
            map[y - 1][x] = nextValue;
        }
        if (x + 1 < map.length && map[y][x + 1] == 0) {
            map[y][x + 1] = nextValue;
            aStar(map, x + 1, y);
        }
        if (x - 1 >= 0 && map[y][x - 1] == 0) {
            map[y][x - 1] = nextValue;
        }
        return map;
    }

}
