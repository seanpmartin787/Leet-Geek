public class CombinationBitwiseAnd {
    public int largestCombination(int[] candidates) {
        int[] largest = new int[1];
        getCombinations(candidates, largest, candidates[0],0, candidates.length);
        return largest[0];
    }
    private static void getCombinations (int[] cand, int[] largest, int current, int start, int k) {
        if (start == cand.length) {
            largest[0] = Math.max(largest[0], current);
        }
        for (int i = start; i < cand.length-k+1; i++) {
            current = current & cand[i];
            getCombinations(cand,largest,current,start+1,k-1);
        }
    }
}
