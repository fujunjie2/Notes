package Sort;

public class JQuickSort {

    public static void main(String[] args) {
        int[] list = new int[]{12,6,2,3,19,4,5,9,8,7,1};

        quickSort(list, 0, list.length -  1);

        for (int i : list) {
            System.out.println(i);
        }

    }


    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] > arr[pivot]) {
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
