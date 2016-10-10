package sortings;

import java.util.Arrays;
import java.util.Random;

import static sortings.SortingUtils.getRandomArray;

public class BubbleSort {

    public static void main(String[] args) {
        int[] randomArray = getRandomArray(100000, 100000);
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbleSort(randomArray)));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] bubbleSort(int[] array) {
        int n = array.length - 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            n--;
        }
        return array;
    }

}
