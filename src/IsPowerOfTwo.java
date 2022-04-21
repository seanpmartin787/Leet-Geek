public class IsPowerOfTwo {
    public static void main(String[] args) {
//        System.out.println(4);
//        System.out.println(~4);
//        System.out.println(4 | 1);
//        System.out.println(4 | 0);
        System.out.println(4 | ~4);
        System.out.println(5 | ~5);
        System.out.println(6 | ~6);
        System.out.println(16 | ~16);

    }
    public boolean isPowerOfTwo(int n) {
        return (n > 0 & (n & (n-1)) == 0);
    }
}
