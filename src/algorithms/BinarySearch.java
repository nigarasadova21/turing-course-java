package algorithms;
// Java implementation of iterative Binary Search

 public class BinarySearch {

    // Returns index of x if it is present in arr[].
   public static int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

                // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    // Driver code
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
    }
}













//public class BinarySearch {
//    public static int binarySearch(int[] arr, int left, int right, int target) {
//        if (left > right)
//            return -1; // Tapılmadı
//
//        int mid = left + (right - left) / 2;
//
//        if (arr[mid] == target)
//            return mid; // Tapıldı
//        else if (arr[mid] < target)
//            return binarySearch(arr, mid + 1, right, target); // Sağ hissədə axtar
//        else
//            return binarySearch(arr, left, mid - 1, target);  // Sol hissədə axtar
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
//        int target = 23;
//
//        int result = binarySearch(arr, 0, arr.length - 1, target);
//        if (result != -1)
//            System.out.println("Element index: " + result);
//        else
//            System.out.println("Element tapılmadı.");
//    }
//}
