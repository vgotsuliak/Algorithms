package sortings;

import java.util.Arrays;

public class Heapsort {

    public static void main(String[] args) {
        int[] randomArray = SortingUtils.getRandomArray(100, 10);
//        int[] randomArray = {7, 3, 1, 6, 5, 0, 4, 6, 10, 2, 3,4,5,7,1,3,6,9,6,0,6,2,12,3,5,57,3};
        System.out.println(Arrays.toString(randomArray));
        int[] array = heapsort(randomArray);
        System.out.println(Arrays.toString(array));
    }

    public static int[] heapsort(int[] array) {
        int[] heap = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            insertElement(heap, array[i], i);
        }
        for (int i = heap.length - 1; i >= 0; i--) {
            array[i] = removeElement(heap, i);
        }
        return array;
    }

    private static int removeElement(int[] heap, int end) {
        int temp = heap[0];
        heap[0] = heap[end];
        heap[end] = temp;
        sinkElement(heap, 0, end - 1);
        return heap[end];
    }

    private static int[] insertElement(int[] heap, int element, int position) {
        heap[position] = element;
        return floatElement(heap, position);
    }

    private static int[] sinkElement(int[] heap, int position, int end) {
        int lc = leftChildPosition(position);
        int rc = rightChildPosition(position);
        if (lc > end) {
            return heap;
        }
        if (rc > end && heap[position] < heap[lc]) {
            int temp = heap[lc];
            heap[lc] = heap[position];
            heap[position] = temp;
            sinkElement(heap, lc, end);
        } else if (heap[lc] > heap[rc] && heap[position] < heap[lc]) {
            int temp = heap[lc];
            heap[lc] = heap[position];
            heap[position] = temp;
            sinkElement(heap, lc, end);
        } else if (rc <= end && heap[position] < heap[rc]) {
            int temp = heap[rc];
            heap[rc] = heap[position];
            heap[position] = temp;
            sinkElement(heap, rc, end);
        }
        return heap;
    }

    private static int[] floatElement(int[] heap, int elementPosition) {
        if (heap[parentPosition(elementPosition)] < heap[elementPosition]) {
            int temp = heap[parentPosition(elementPosition)];
            heap[parentPosition(elementPosition)] = heap[elementPosition];
            heap[elementPosition] = temp;
            floatElement(heap, parentPosition(elementPosition));
        }
        return heap;
    }

    private static int parentPosition(int position) {
        return (position - 1) / 2;
    }

    private static int leftChildPosition(int position) {
        return 2 * position + 1;
    }

    private static int rightChildPosition(int position) {
        return 2 * position + 2;
    }

}
