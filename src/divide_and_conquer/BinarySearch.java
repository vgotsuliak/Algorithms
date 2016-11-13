package divide_and_conquer;

import sortings.SortingUtils;

import java.util.Arrays;

public class BinarySearch {

    private static int iterations = 0;

    public static void main(String[] args) {
        int[] array = SortingUtils.getRandomArray(10000, 10000);
        Arrays.sort(array);
        System.out.println(binarySearch(array, 0, array.length - 1, 9000));
        System.out.println(iterations);
        System.out.println();
        iterations = 0;
        System.out.println(linearSearch(array, 9000));
        System.out.println(iterations);
    }

    public static int binarySearch(int[] array, int start, int end, int number) {
        iterations++;
        if (array[start + (end - start) / 2] == number) {
            return number;
        }
        if (array[start + (end - start) / 2] < number) {
            return binarySearch(array, start + (end - start) / 2 + 1, end, number);
        } else {
            return binarySearch(array, start, start + (end - start) / 2 - 1, number);
        }
    }

    public static int linearSearch(int[] array, int number) {
        for (int element : array) {
            iterations++;
            if (element == number) {
                return element;
            }
        }
        throw new IllegalArgumentException();
    }

}
