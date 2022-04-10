public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {

            if (!(nums.length == k)) {

                startSwap(0, k, nums, 0);

                if (nums.length % k == 0) {
                    //if k creates a cycle we need to call swap on the other track
                    startSwap(1, k, nums, 1);
                }
                //0, 1, 2, 3, 4, 5]

            }

        }
        public void startSwap(int currentIndex, int distance, int[] nums, int startingPoint) {

            //performs the first swap outside the stop condition
            int sourceVal = 0, destinationVal = 0, destinationIndex = 0;
            sourceVal = nums[currentIndex];
            destinationIndex = newIndex(currentIndex, distance, nums.length - 1);
            destinationVal = nums[destinationIndex];
            nums[destinationIndex] = sourceVal;

            performSwap(destinationIndex, destinationVal, nums, startingPoint);
        }

        public void performSwap(int currentIndex, int distance, int[] nums, int startingPoint) {

            if (currentIndex != startingPoint) {
                int sourceVal = 0, destinationVal = 0, destinationIndex = 0;
                sourceVal = nums[currentIndex];
                destinationIndex = newIndex(currentIndex, distance, nums.length - 1);
                destinationVal = nums[destinationIndex];
                nums[destinationIndex] = sourceVal;

                performSwap(destinationIndex, destinationVal, nums, startingPoint);
            }//break recursive chain

        }

        public int newIndex(int currentIndex, int distance, int lastIndex) {
            if (currentIndex + distance <= lastIndex) {
                return  currentIndex + distance;
            } else {
                //Modulus lets us have k > size of array
                currentIndex = ((distance - (lastIndex - currentIndex)) - 1) % (lastIndex + 1);
                return currentIndex;
            }
        }
    }
}
