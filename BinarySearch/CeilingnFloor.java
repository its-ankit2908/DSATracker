package revision.binarysearch;

import java.util.Arrays;

public class Ceiling {

    private static int ceiling(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        if (target > arr[end]) { // if my target element is greater then the greatest element in the array
            return -1;
        }
        while (start <= end) {

            int mid = start - (start - end) / 2;
            if (arr[mid] == target) {
                return arr[mid + 1];
            } else if (arr[mid] < target) {

                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return arr[start];
    }


    
    private static String ceiling(String[] arr, String target) {

        int start = 0;
        int end = arr.length - 1;
        if (target.compareTo(arr[end]) > 0) { // if my target element is greater then the greatest element in the array
            return "";
        }

        while (start <= end) {

            int mid = start - (start - end) / 2;
            if (arr[mid] == target) {
                return arr[mid + 1];

            } else if (arr[mid].compareTo(target) < 0) {

                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return arr[start];
    }

    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (target < arr[start]) { // if my target is smaller than the smallest element in the array then no floor available in the array
            return -1;
        }
        while (start <= end) {
            int mid = end - (end - start) / 2;
            if (arr[mid] == target) {
                return arr[mid - 1];

            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[end];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7, 9, 14, 16 };
        int target = 14;
        int ceil = ceiling(arr, target);
        int floor = floor(arr, target);
        System.out.println("Ceil: " + ceil + "," + "Floor: " + floor);

        String letters[]  = {"c","f","j","k"};
        Arrays.sort(letters);
        System.out.println(Arrays.toString(letters));
        System.out.println(ceiling(letters, "h"));
    }

}
