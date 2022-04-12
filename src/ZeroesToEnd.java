public class ZeroesToEnd {
    public static void main(String[] args) {
        int[] test = new int[] {0,2,4,0,0,10,75,0,453,34,43,56};
        var ob = new Solution();
        ob.moveZeroes(test);

        for (int num : test) {
            System.out.println(num);
        }

        System.out.println("-".repeat(50));
        int[] test2 = new int[] {0,0,1};
        ob.moveZeroes(test2);

        for (int num : test2) {
            System.out.println(num);
        }

    }
    static class Solution {

        public void moveZeroes(int[] nums) {

            int startZeroIndex = nums.length -1;
            for (int i = 0; i <= startZeroIndex; i++) {

                int consecutiveZeroes = 0;

                if (nums[i] == 0) {
                    while (i + consecutiveZeroes < startZeroIndex && nums[i + consecutiveZeroes] == 0) {
                        consecutiveZeroes++;
                    }
                    for (int j = i; j + consecutiveZeroes < nums.length && j < startZeroIndex; j++) {
                        nums[j] = nums[j + consecutiveZeroes];
                    }
                    startZeroIndex -= consecutiveZeroes;
                }
            }//End loop through array
            for (int i = startZeroIndex + 1; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
