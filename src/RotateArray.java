public class RotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {

        //We can do this by reversing the whole array, then reversing sub array 0 - (k-1)
            // and reversing other sub array k - (nums.length - 1)
            k %= nums.length;
            reverse(0, nums.length - 1, nums);
            reverse(0, k - 1, nums);
            reverse(k, nums.length - 1, nums);

        }

        private void reverse (int startIndex, int lastIndex, int[] arr) {
            while (startIndex < lastIndex) {
                int temp = arr[startIndex];
                arr[startIndex] = arr[lastIndex];
                arr[lastIndex] = temp;
                startIndex++;
                lastIndex--;
            }

        }//reverse all the values

    }
}
