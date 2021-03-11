package Sort;

public class QuickSort {


    public static void main(String[] args) {

        int[] list = new int[]{6,2,3,1,4,5,9,8,7};
    }

    public static void sort(int[] arr) {
        int pivotKey = arr[0];

        quickSort(arr, 0, arr.length);
    }

    public static void quickSort(int[] arr, int low, int high) {

        while (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex -1);
            quickSort(arr, partitionIndex + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        int index = low + 1;
        for (int i = index; i <= high; ++i) {
            if (arr[i] < pivot) {

            }
        }

        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }
}
