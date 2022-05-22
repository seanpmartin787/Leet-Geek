//public class SumOfStrengthWizards {
//TODO:get better and figure this out
//https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2061787/Amazon-Online-Assessment
//    public static void main(String[] args) {
//        System.out.println(totalStrength(new int[] {1,2,3}));
//    }
//
//    public static int totalStrength(int[] strength) {
//        long sumStrength = 0, minStrength = 0;
//        long[] sum = new long[strength.length+1];
//        int[][] min = new int[strength.length+1][strength.length+1];
//
//        for (int window=1; window <= strength.length; window++){
//            //loop through all the window sizes
//            for (int i = 0; i < strength.length; i++) {
//                if (window == 1) {
//                    //memo current sum up to this point
//                    sum[i + 1] = sum[i] + strength[i];
//                    //memo min value from i to i
//                    min[0][i+1] = strength[i];
//                }
//                if (i+1-window >= 0) {
//                    //if it is a valid sized window
//                    //minValue
//                    min[i+1-window][i+1] = Math.min(min[i+1-window][i],strength[i+1]);
//                    sumStrength += (sum[i+1] - sum[i+1-window]) * min[i+1-window][i+1];
//                }
//            }
//        }
//        return (int) sumStrength;
//    }
//}
