package sortings;

import java.util.Random;

public class SortingUtils {

    public static int[] getRandomArray(int size, int limit) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            double randomDouble = Math.abs(random.nextDouble());
            randomArray[i] = new Double(Math.round(randomDouble * limit)).intValue();
        }
        return randomArray;
    }

}
