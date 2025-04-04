package binarysearch;

public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid] < arr[mid+1]){ // ascending order pattern detect
              start = mid + 1;
            }
            else if(arr[mid] > arr[mid+1]){ // descending order pattern
              end = mid;
            }
        }

        return start; // either return start or end both will point out to the peak element
      
    }
}
