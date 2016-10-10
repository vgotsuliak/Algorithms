package sortings;

public class CountingSort {

    public static void main(String[] args) {
        int differentNumbersCount = 10;
        int[] randomArray = SortingUtils.getRandomArray(1000, differentNumbersCount);
        int[] buckets = new int[differentNumbersCount+1];
        for (int i = 0; i < randomArray.length; i++) {
            buckets[randomArray[i]]++;
        }
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.print(i);
            }
        }
    }

}
