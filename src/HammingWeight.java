public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(12));
        System.out.println();
        long = 00100000000000000000000000000000;
    }
    public static int hammingWeight(int n) {
        int[] bitArray = new int[n + 1];
        bitArray[0] = 0;
        bitArray[1] = 1;

        for (int i = 2; i < bitArray.length; i++) {
            if ((i & 1) == 0) bitArray[i] = bitArray[i >> 1];
            else bitArray[i] = bitArray[i -1] + 1;
        }
        return bitArray[bitArray.length - 1];
    }
}
