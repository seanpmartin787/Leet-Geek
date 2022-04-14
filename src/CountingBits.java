public class CountingBits {
    public static void main(String[] args) {
//        for (int i : countBits(5)) {
//            System.out.println(i);
//        }
        System.out.println(1 & 1);
        System.out.println(3 & 1);
        System.out.println(5 & 1);
        System.out.println(57 & 1);
        System.out.println(47 & 1);
        System.out.println(120331 & 1);
    }

    public static int[] countBits(int n) {
        int[] bitArray = new int[n+1];
        int temp = 0;
        int currentNumber = 0;

        bitArray[0] = 0;
        for(int i = 1; i <= n; i++){
            if((i & 1) == 0){
                bitArray[i] = bitArray[i >> 1];
                //System.out.println("Bitwise operator " + (i & 1));
                //System.out.println("Turning " + i + " into "  + (i >> 1));
                //System.out.println("Adding " + bitArray[i >> 1] + " to array for: " + i);
            }else{
                bitArray[i] = bitArray[i - 1] + 1;
                //System.out.println("Adding " + (bitArray[i - 1] + 1) + " to array for: " + i);
            }
        }
        return bitArray;
    }
}
