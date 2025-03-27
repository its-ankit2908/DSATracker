package revision.binarysearch;

public class FindPositionArrayInfinite {
    
    public static int findPositionArrayInfinite(int[] arr,int target){

        int start = 0;
        int end = 1;

        // increase the window size till we found that the target is lie inside the window size
        while(target > arr[end]){

            // double the box value
            int newStart = end + 1;
            int newEnd = end + (end - start + 1)*2; // formula: previousend + boxSize*2

            start = newStart;
            end = newEnd;
        }

        int ans = search(arr, target,start,end);
        return ans;
    }

    // binarysearch
    public static int search(int[] arr,int target,int start,int end){

        while(start <= end){
            int mid = end - (end -start)/2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid -1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}
