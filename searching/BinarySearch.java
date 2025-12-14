class Search {
    public int binarySearch(int[] arr, int low, int high, int target){

        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == target){
            return mid;
        }

        else if(target > arr[mid]){
            return binarySearch(arr, mid+1, high, target);
        }

        else{
            return binarySearch(arr, low, mid - 1, target);
        }
    }
}


public class BinarySearch{
    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 9;

        Search s = new Search();
        int result = s.binarySearch(arr, 0, arr.length - 1, target);

        System.out.printf("Element found at index: %d", result);


    }
}
