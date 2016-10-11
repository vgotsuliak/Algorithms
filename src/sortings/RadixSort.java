package sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public static void main(String[] args) {
        int[] randomArray = SortingUtils.getRandomArray(100, 1000);
        System.out.println(Arrays.toString(randomArray));
        int[] sortedArray = radix(randomArray);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] radix(int[] array) {
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int divider = 1;
        boolean some = true;
        while (some) {
            some = false;
            for (int number : array) {
                int temp = number / divider;
                buckets[temp % 10].add(number);
                if (temp > 0) {
                    some = true;
                }
            }
            int position = 0;
            for (int a = 0; a < 10; a++) {
                for (Integer number : buckets[a]) {
                    array[position++] = number;
                }
                buckets[a].clear();
            }
            divider *= 10;
        }
        return array;
    }

}
