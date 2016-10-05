import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] randomArray = getRandomArray(100000);
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(bubbleSort(randomArray)));
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] getRandomArray(int n) {
        Random random = new Random();
        int[] randomArray = new int[n];
        for (int i = 0; i < n; i++) {
            double randomDouble = Math.abs(random.nextDouble());
            randomArray[i] = new Double(Math.round(randomDouble * n)).intValue();
        }
        return randomArray;
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
