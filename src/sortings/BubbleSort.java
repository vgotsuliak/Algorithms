package sortings;

import java.util.Arrays;
import java.util.Random;

import static sortings.SortingUtils.getRandomArray;
import static sortings.SortingUtils.printArrayInHtml;

public class BubbleSort {

    private static final int ARRAY_SIZE = 50;

    public static void main(String[] args) {
        int[] randomArray = getRandomArray(ARRAY_SIZE, ARRAY_SIZE);
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbleSort(randomArray)));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length - 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

}
