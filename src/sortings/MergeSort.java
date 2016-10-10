package sortings;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] randomArray = SortingUtils.getRandomArray(10, 10);
        System.out.println(Arrays.toString(randomArray));
        int[] sortedArray = mergeSort(randomArray, 0, randomArray.length - 1);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] mergeSort(int[] array, int from, int to) {
        return array;
    }

}
