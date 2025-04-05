package binarysearch;

// arr is the given mountain array 
public class FindInMountainArray {

    public static int search(int[] arr,int target){
        
        int peak = findPeakIndex(arr);
        int firstHalf = orderAgnosticBS(arr, 0, peak, target);
        if(firstHalf != -1){
            return firstHalf;
        }

        // if not found in first half (0,peak) then search it on second half (peak+1,len(arr)-1)
        return orderAgnosticBS(arr, peak+1, arr.length - 1, target);
    }

    public static int findPeakIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start != end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1]){
                //descend
                end = mid;
            }else if(arr[mid] < arr[mid+1]){
                //ascend
                start = mid + 1;
            }
        }

        return start;
    }

    static int orderAgnosticBS(int[] arr,int start,int end, int target) {
        

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; // might be possible that (start + end) exceeds
            // the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int target = 3;
        int result = search(arr,target);
    }
}
