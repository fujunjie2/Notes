package Sort.firstTime;


public class HeapSort {

    public static void main(String[] args) {
        int[] list = new int[]{12,6,2,3,19,4,5,9,8,7,1};

        int len = list.length;

        buildMinHeap(list, len);


        for (int i = len - 1; i >= 0; i--) {
            swap(list, 0, i);
            heapifyMin(list, 0, --len);
        }

        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void buildMaxHeap(int[] arr, int len) {
        int end = (int) Math.floor(len/2);
        for (int i = end; i >= 0; i--) {
            heapifyMax(arr, i, len);
        }

    }

    public static void buildMinHeap(int[] arr, int len) {
        int end = (int) Math.floor(len/2);
        for (int i = end; i >= 0; i--) {
            heapifyMin(arr, i, len);
        }

    }

    public static void heapifyMax(int[] arr, int parentIndex, int len) {
        int left = 2 * parentIndex + 1;
        int right = 2 * parentIndex + 2;

        int largestIndex = parentIndex;

        if (left < len && arr[left] > arr[parentIndex]) {
            largestIndex = left;
        }

        if (right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != parentIndex) {
            swap(arr, largestIndex, parentIndex);
            heapifyMax(arr, largestIndex, len);
        }

    }

    public static void heapifyMin(int[] arr, int parentIndex, int len) {
        int left = 2 * parentIndex + 1;
        int right = 2 * parentIndex + 2;

        int smallIndex = parentIndex;

        if (left < len && arr[left] < arr[parentIndex]) {
            smallIndex = left;
        }

        if (right < len && arr[right] < arr[smallIndex]) {
            smallIndex = right;
        }

        if (smallIndex != parentIndex) {
            swap(arr, smallIndex, parentIndex);
            heapifyMin(arr, smallIndex, len);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
