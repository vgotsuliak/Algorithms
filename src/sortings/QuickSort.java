package sortings;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] randomArray = SortingUtils.getRandomArray(100, 100);
        System.out.println(Arrays.toString(randomArray));
        int[] sortedArray = quickSort(randomArray, 0, randomArray.length - 1);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] quickSort(int[] array, int start, int end) {
        int pivot = getPivotMiddlePoint(array, start, end);
        int i = start;
        int j = end;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) {
            array = quickSort(array, start, j);
        }
        if (i < end) {
            array = quickSort(array, i, end);
        }
        return array;
    }

    public static int getPivotMiddlePoint(int[] array, int start, int end) {
        return array[start + (end - start) / 2];
    }

}
