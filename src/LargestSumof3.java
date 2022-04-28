public class LargestSumof3 {
    public static void main(String[] args) {
        System.out.println(largestSum(new int[]{6, 3, 7, 2, 4, 9}));
    }
    public static int largestSum (int[] s) {
        int sum = 0, sizeW = 0, maxSum = 0;

        for (int i = 0; i < s.length; i++) {
             sum += s[i];
             sizeW++;

             if (sizeW == 3) {
                 maxSum = Math.max(maxSum, sum);
                 sum -= s[i - 2];
                 sizeW--;
             }
        }
        return maxSum;
    }
}
