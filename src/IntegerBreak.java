public class IntegerBreak {
    public int integerBreak(int n) {
        //I feel like you can reliably pick the most similar numbers to multiple
        //k = 2, 5,5 is best
        //k = 3, 3,3,4 is best
        //k = 4, 2,2,3,3 is best
        int pieces = 0, maxProduct = 0, product = 1, remainder = 0;
        //memo size of k+1
        //for each remainder add it
        //then multiply each

        for (int k=2; k <= n; k++) {
            remainder = n%k;
            pieces = n/k;
            product = 1;
            for (int i=1; i <= k; i++) {
                if (remainder-- > 0) product *= pieces + 1;
                else product *= pieces;
            }
            maxProduct = Math.max(maxProduct, product);
        }

        return maxProduct;
    }

    public int integerBreakLogTime(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;
        int num_3 = (int)n/3;
        int remainder = n % 3;
        if (remainder == 1) {
            remainder = 4;
            num_3 --;
        } else if (remainder == 0)
            remainder = 1;

        //pow runs in log time
        return (int)Math.pow(3, num_3) * remainder;
    }
}
