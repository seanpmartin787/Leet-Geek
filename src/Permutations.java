import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        permute(perms, nums, new ArrayList<>(), new HashSet<>());

        return perms;
    }

    private static void permute(List<List<Integer>> perms, int[] nums, List<Integer> permutation, HashSet<Integer> permSet) {
        if (permutation.size() == nums.length) {
            //Have to create new array list or it will just get overwritten
            perms.add(new ArrayList<>(permutation));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (permSet.contains(i)) continue;

                permutation.add(nums[i]);
                permSet.add(nums[i]);

                permute(perms, nums, permutation, permSet);

                //Remove the most recent entry
                permSet.remove(permutation.get(permutation.size() - 1));
                permutation.remove(permutation.size()-1);

            }
        }
    }
}

