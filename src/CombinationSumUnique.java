import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumUnique {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        //[10,1,2,7,6,1,5]
        //8
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target,0,  new ArrayList<>(), res);
        return res;
    }
    private static void backTrack (int[] nums, int remaining, int start, List<Integer> set, List<List<Integer>> res) {
        if (remaining < 0) return; //sum was too large, not a match
        if (remaining == 0) {
            //we got a winner
            res.add(new ArrayList<>(set));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            set.add(nums[i]);
            backTrack(nums, remaining - nums[i], i + 1, set, res);
            set.remove(set.size()-1);
        }
    }
}
