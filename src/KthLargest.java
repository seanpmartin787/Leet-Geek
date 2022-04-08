class KthLargest {
    //Initialize this in the constructor so that add function can access it
    int kthLargest;
    int[] sortedNums;

    public static void main(String[] args) {
        int arr[] = {};

//        Sort(arr, 0, (arr.length -1));
//
//

        KthLargest ob = new KthLargest(1, arr);

        for (int value : ob.sortedNums) {
            System.out.println(value);
        }

        ob.add(3);
        ob.add(5);
        ob.add(10);
        ob.add(9);
        ob.add(4);

        for (int value : ob.sortedNums) {
            System.out.println(value);
        }

    }//End main



    public KthLargest(int k, int[] nums) {

        //Implement merge sort to achieve
        //O(NLog(N)) time complexity
        //and O(N) space complexity
        Sort(nums, 0, (nums.length -1));
        this.sortedNums = nums;
        this.kthLargest = k;

        //now that it is sorted we can expect the add function to get called
        //Nothing left to do in the constructor


    }

    public int add(int val) {
        //Implement this with a binary search so that we can find value in list size (n)
        // with time complexity of O(Log(N))

        if (sortedNums.length > 0) {
            int l = 0, h = (sortedNums.length - 1), m = 0;

            while (l <= h) {
                m = l + (h - l) / 2;

                if (sortedNums[m] == val) {
                    //put(m+1, val);
                    //If there is a match break the loop and put the value at m + 1
                    break;
                } else if (val < sortedNums[m]) {
                    //Search bottom half
                    h = m - 1;
                } else {
                    //search top half
                    l = m + 1;
                }
            }//While searching

            if (sortedNums[m] == val || sortedNums[m] <= val) {
                m = m + 1;
            }

            put(m, val);

        } else {
            sortedNums = new int[] {val};
        }
        return sortedNums[sortedNums.length - kthLargest];
    }
    public void put(int index, int value) {

        int[] newArr = new int[(sortedNums.length + 1)];
        int j = 0;

        for (int i = 0; i < newArr.length; i++) {

            if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = sortedNums[j];
                j++;
            }
        }//place each value, shifting over when we are at our new index

        this.sortedNums = newArr;

    }//Abstract put method

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
        int i = 0, j = 0, k = l; // i is left sub array, j is right, k is merged array

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
            arr[k] = upper[j];
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
