package intro;

public class NumbersBySpiral {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        printMatrix(matrix);
    }

    private static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int dirIndex = 0;
        for (int i = 1; i <= size * size; i++) {
            matrix[y][x] = i;


            if (((dirIndex == 0) && (x == size - 1 || matrix[y + dy[dirIndex]][x + dx[dirIndex]] != 0))
                    || ((dirIndex == 2) && (x == 0 || matrix[y + dy[dirIndex]][x + dx[dirIndex]] != 0))
                    || ((dirIndex == 1) && (y == size - 1 || matrix[y + dy[dirIndex]][x + dx[dirIndex]] != 0))
                    || ((dirIndex == 3) && (y == 0 || matrix[y + dy[dirIndex]][x + dx[dirIndex]] != 0))) {
                dirIndex = (dirIndex + 1) % 4;
            }

            x += dx[dirIndex];
            y += dy[dirIndex];
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
