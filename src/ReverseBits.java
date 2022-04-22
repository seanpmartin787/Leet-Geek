public class ReverseBits {
    public static void main(String[] args) {
        reverseBits(43261596);
    }
    public static int reverseBits(int n) {
        if (n == 0) return 0;

        int flip = 0;
        for (int i = 0; i < 32; i ++) {
            flip <<= 1;
            if ((n & 1) == 1) {
                flip += 1;
            }
            n = n >> 1;
        }
        return flip;
    }
}
