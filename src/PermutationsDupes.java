import java.util.*;

public class PermutationsDupes {
    public static void main(String[] args) {
        //System.out.println(permuteUnique(new int[] {1,2,3}));
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        //System.out.println(permuteUnique(new int[] {1,1,2}));
        //[[1,1,2],
        // [1,2,1],
        // [2,1,1]]
//        System.out.println(permuteUnique(new int[] {1,1,1}));
        //System.out.println(permuteUnique(new int[] {3,3,0,3}));
        System.out.println(permuteUnique(new int[] {1,2,2,2,4}));


    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);

        backTrack(nums, visited, new ArrayList<>(), res);

        return res;

    }

    private static void backTrack (int[] nums, int[] visited, List<Integer> path, List<List<Integer>> res) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i] == 1 || (i > 0 && nums[i-1] == nums[i] && visited[i-1] == 0)) continue;
            //we can only add successive duplicates so the one before has to be visited
            //basically for the two's, order does matter
            //that way we won't get different combinations of the same numbers

            path.add(nums[i]);
            visited[i] = 1;

            backTrack(nums,visited, path, res);

            path.remove(path.size()-1);
            visited[i] = 0;


        }

    }
}
