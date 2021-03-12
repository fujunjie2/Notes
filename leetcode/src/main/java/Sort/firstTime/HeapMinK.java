package Sort.firstTime;

/**
 * 最小的K个数
 */
public class HeapMinK {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};

        HeapSort.buildMaxHeap(arr, 4);


        int len = arr.length;
        for (int i = 4; i < len; i++) {
            if (arr[i] < arr[0]) {
                HeapSort.swap(arr, 0, i);
                HeapSort.heapifyMax(arr, 0, 4);
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
