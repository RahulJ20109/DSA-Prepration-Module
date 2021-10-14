// Problem Link
// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] minArray;
        int[] maxArray;
        if (n1 > n2) {
            minArray = nums2;
            maxArray = nums1;
        } else {
            minArray = nums1;
            maxArray = nums2;
        }
        quickSort(nums1, 0, n1 - 1);
        quickSort(nums2, 0, n2 - 1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < minArray.length; i++) {
            if (stack.size() == 0 || stack.peek() != minArray[i]) {
                stack.push(minArray[i]);
                if (search(maxArray, minArray[i])) {
                    result.add(minArray[i]);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    static boolean search(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == val) {
                return true;
            }
            if (arr[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * The main function that implements QuickSort arr[] --> Array to be sorted, low
     * --> Starting index, high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
