import java.util.PriorityQueue;

class KthLargestPQ {
    //Initialize this in the constructor so that add function can access it
    int kthLargest;
    PriorityQueue<Integer> sortedNums;

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 76, 2, 1};

        KthLargestPQ ob = new KthLargestPQ(1, arr);

        System.out.println(ob.add(3) + " is the " + ob.kthLargest + " largest value in the pq");
        System.out.println(ob.add(5) + " is the " + ob.kthLargest + " largest value in the pq");
        System.out.println(ob.add(10) + " is the " + ob.kthLargest + " largest  value in the pq");
        System.out.println(ob.add(9) + " is the " + ob.kthLargest + " largest value in the pq");
        System.out.println(ob.add(4) + " is the " + ob.kthLargest + " largest value in the pq");

    }//End main


    public KthLargestPQ(int k, int[] nums) {

        //Implement merge sort to achieve
        //O(NLog(N)) time complexity
        //and O(N) space complexity
        PriorityQueue temp = new PriorityQueue<Integer>();

        for (int num : nums) {
            temp.add(num);
        }
        sortedNums = temp;
        this.kthLargest = k;

        //now that it is sorted we can expect the add function to get called
        //Nothing left to do in the constructor


    }

    public int add(int val) {



        if (sortedNums.isEmpty() || val > sortedNums.peek()) {
            sortedNums.offer(val);
        }

        
        while (sortedNums.size() > kthLargest) {
            sortedNums.poll();
        }

        return sortedNums.peek();
    }
}//end class

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
