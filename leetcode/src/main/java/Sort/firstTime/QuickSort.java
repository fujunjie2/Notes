package Sort.firstTime;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int[] list = new int[]{6,2,3,1,4,5,9,8,7};
        quickSort(list, 0, list.length - 1);

        for (int i : list) {
            System.out.println(i);
        }

    }



    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex -1);
            quickSort(arr, partitionIndex + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;

        int index = low + 1;
        for (int i = index; i <= high; i++) {
            if (arr[i] < arr[pivot]) {
                if (i != index) {
                    swap(arr, i, index);
                }
                index++;
            }
        }
        swap(arr, pivot, index - 1);

        return index - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
