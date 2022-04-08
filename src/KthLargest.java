class KthLargest {

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        Sort(arr, 0, (arr.length -1));

        for (int value : arr) {
            System.out.println(value);
        }
    }

    public KthLargest(int k, int[] nums) {

        //Implement merge sort to achieve
        //O(NLog(N)) time complexity
        //and O(N) space complexity

    }

    public int add(int val) {
        //Implement this with a binary search so that we can insert into list size (n)
        // with time complexity of O(Log(N))

        return 0;
    }

    public static void Sort(int arr[], int l, int r) {

        if (l < r) {

            int m = l + (r-l)/2; //This will make the right side the bigger half

            //sort each half recursively
            Sort (arr, l, m);
            Sort (arr, m+1, r);

            //merge the sorted halves
            Merge (arr, l, m, r);

        }//If not size < 2

    }//End Sort

    public static void Merge(int arr[], int l, int m, int r) {
        //Get the sizes of the sub arrays
        int size1 = m - l + 1;
        int size2 = r - m;

        //System.out.println("Int the Merge class");
        //Temp arrays of said sizes
        int lower[] = new int[size1];
        int upper[] = new int[size2];

        //Copy contents
        for (int i = 0; i < size1; i ++) {
            lower[i] = arr[l + i];
        }
        for (int i = 0; i < size2; i ++) {
            upper[i] = arr[m + 1 + i]; //middle + 1 is starting point for upper
        }

        //indexes
        int i = 0, j = 0, k = 1; // i is left sub array, j is right, k is merged array

        while (i < size1 && j < size2) {
            if (lower[i] <= upper[j]) {
                arr[k] = lower[i];
                i++;
            } else {
                arr[k] = upper[j];
                j++;
            }
            k++;
        }

        //Copy any remaining elements b/c loop ends when shorter arr hits limit
        //we can append to the end because the sub array should be sort so the last one is largest
        while (i < size1) {
            arr[k] = lower[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = lower[j];
            j++;
            k++;
        }


    }//End Merge
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
