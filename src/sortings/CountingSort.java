package sortings;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int differentNumbersCount = 10;
        int[] randomArray = SortingUtils.getRandomArray(1000, differentNumbersCount);
        int[] sortedArray = countingSort(randomArray, 10);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] countingSort(int[] array, int differentNumbersCount) {
        int[] buckets = new int[differentNumbersCount+1];
        for (int i = 0; i < array.length; i++) {
            buckets[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                array[index] = i;
                index++;
            }
        }
        return array;
    }

}
