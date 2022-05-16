public class CombinationBitwiseAnd {
    public static void main(String[] args) {
        System.out.println(largestCombination(new int[] {16,16,48,71,62,12,24,14,17,18,19,20,10000}));
//        int[] test = new int[] {16,16,48,71,62,12,24,14,17,18,19,20,10000};
//        int current = test[4];
//        for (int i = 4; i < test.length; i++) {
//            current &= test[i];
//            System.out.println(current);
//        }
    }
    public static int largestCombination(int[] A) {
        int max=0;
        for(int i=31;i>=0;i--){
            int cnt=0;
            for(int j:A) if(((j>>i)&1)==1) cnt++;
            max= Math.max(max,cnt);
        }
        return max;
    }
}
