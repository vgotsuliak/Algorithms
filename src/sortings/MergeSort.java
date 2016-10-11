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
        if (from < to) {
            int center = from + (to - from) / 2;
            mergeSort(array, from, center);
            mergeSort(array, center + 1, to);
            mergeResult(array, from, center, to);
        }
        return array;
    }

    public static void mergeResult(int[] array, int start, int center, int end) {
        int[] resultArray = new int[array.length];
        int resultIndex = 0;
        int firstIndex = start;
        int secondIndex = center;
        while (firstIndex < center - 1 && secondIndex < end) {
            if (array[firstIndex] < array[secondIndex]) {
                resultArray[resultIndex++] = array[firstIndex++];
            } else {
                resultArray[resultIndex++] = array[secondIndex++];
            }
        }
        while (firstIndex <= center - 1) {
            resultArray[resultIndex++] = array[firstIndex++];
        }
        while (secondIndex <= end) {
            resultArray[resultIndex++] = array[secondIndex++];
        }
        int num = end - start + 1;
        for (int i = 0; i < num; i++, end--) {
            array[end] = resultArray[end];
        }
    }

    public static int[] mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
        return a;
    }


    private static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd)
            if (a[left] < a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }

        while (left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while (right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

}
