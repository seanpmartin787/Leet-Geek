import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
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
            set.add(nums[i]);
            backTrack(nums, remaining - nums[i], i, set, res);
            set.remove(set.size()-1);
        }
    }
}
