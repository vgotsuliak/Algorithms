package data_structure;

public class ForiForj {

    public static void main(String[] args) {
        int[][] array = new int[10000][10000];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i;
            }
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int v = array[i][j];
            }
        }
        System.out.println(System.currentTimeMillis() - start + " milliseconds");

        start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int v = array[j][i];
            }
        }
        System.out.println(System.currentTimeMillis() - start + " milliseconds");

        start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int v = array[i][j];
            }
        }
        System.out.println(System.currentTimeMillis() - start + " milliseconds");


    }

}
