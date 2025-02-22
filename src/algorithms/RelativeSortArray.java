package algorithms;

import java.util.Arrays;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001]; // For numbers from 0 to 1000

        // 1. Count the occurrences of elements in arr1
        for (int num : arr1) {
            count[num]++;
        }

        // 2. Index to construct the result array
        int index = 0;

        // 3. Add elements from arr2 in the specified order
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        // 4. Add remaining elements not in arr2 in ascending order
        for (int num = 0; num < count.length; num++) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}







