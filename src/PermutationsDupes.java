import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PermutationsDupes {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];

        backTrack(nums, visited, 0, new ArrayList<>(), res);

        return res;

    }

    private static void backTrack (int[] nums, int[] visited, int start, List<Integer> path, List<List<Integer>> res) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {

            if (visited[i] == 1 || i > 0 && nums[i-1] == nums[i]) continue;

            path.add(nums[i]);
            visited[i] = 1;

            backTrack(nums,visited,i + 1, path, res);

            path.remove(path.size()-1);
            visited[i] = 0;


        }

    }
}
