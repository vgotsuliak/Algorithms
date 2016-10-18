package sortings;

import java.util.Arrays;

public class Heapsort {

    public static void main(String[] args) {
//        int[] randomArray = SortingUtils.getRandomArray(100, 10);
        int[] randomArray = {7, 3, 1, 6, 5, 0, 4, 6, 10, 2};
        System.out.println(Arrays.toString(randomArray));
        int[] array = heapsort(randomArray);
        System.out.println(Arrays.toString(array));
    }

    public static int[] heapsort(int[] array) {
        int[] heap = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            insertElement(heap, array[i], i);
        }
        for (int i = 0; i < heap.length; i++) {
            array[heap.length - i - 1] = removeElement(heap, heap.length - i - 1);
        }
        return array;
    }

    private static int removeElement(int[] heap, int end) {
        int temp = heap[0];
        heap[0] = heap[end];
        heap[end] = temp;
        sinkElement(heap, 0, end);
        return heap[end];
    }

    private static int[] insertElement(int[] heap, int element, int position) {
        heap[position] = element;
        return floatElement(heap, position);
    }


    private static int[] sinkElement2(int[] heap, int position, int end) {
        int leftChildPosition = leftChildPosition(position);
        int rightChildPosition = rightChildPosition(position);
        if (leftChildPosition > end && rightChildPosition > end) {
            return heap;
        }
        if (leftChildPosition <= end && heap[position] < heap[leftChildPosition]) {
            //swap position with left
            int temp = heap[leftChildPosition];
            heap[leftChildPosition] = heap[position];
            heap[position] = temp;
            sinkElement2(heap, leftChildPosition, end);
        } else if (rightChildPosition <= end && heap[position] < heap[rightChildPosition]) {
            int temp = heap[rightChildPosition];
            heap[rightChildPosition] = heap[position];
            heap[position] = temp;
            sinkElement2(heap, rightChildPosition, end);
        }

        return heap;
    }

    private static int[] sinkElement(int[] heap, int position, int end) {
        int leftChildPosition = leftChildPosition(position);
        int rightChildPosition = rightChildPosition(position);
        if (leftChildPosition < end && heap[leftChildPosition] > heap[rightChildPosition]) {
            //swap position with left
            int temp = heap[leftChildPosition];
            heap[leftChildPosition] = heap[position];
            heap[position] = temp;
            sinkElement(heap, leftChildPosition, end);
        } else if (rightChildPosition < end && heap[rightChildPosition] > heap[leftChildPosition]) {
            int temp = heap[rightChildPosition];
            heap[rightChildPosition] = heap[position];
            heap[position] = temp;
            sinkElement(heap, rightChildPosition, end);
            //swap position with right
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
