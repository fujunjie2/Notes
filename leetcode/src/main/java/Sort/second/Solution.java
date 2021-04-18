package Sort.second;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8,-1};

        Solution solution = new Solution();
        ArrayList a = solution.GetLeastNumbers_Solution(arr, 4);
        for (int i = 0 ; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        build(input, input.length);

        heapSort(input);
        ArrayList<Integer> result = new ArrayList();
        for (int i = 0 ; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public void heapSort(int[] arr){
        int len = arr.length;
        for (int i = len-1; i >= 0; --i) {
            swap(arr, 0, i);
            heapify(arr, 0, --len);
        }
    }


    public void build(int[] input, int n) {
        int firstLevel = input.length / 2;
        for (int i = firstLevel; i >= 0; --i){
            heapify(input, i, n);
        }

    }

    public void heapify(int[] input, int idx, int n) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        int largestIdx = idx;
        if (left < n && input[largestIdx] < input [left]) {
            largestIdx = left;
        }

        if (right < n && input[largestIdx] < input[right]) {
            largestIdx = right;
        }

        if (idx != largestIdx) {
            swap(input, idx, largestIdx);
            heapify(input, largestIdx, n);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}