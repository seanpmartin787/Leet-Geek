import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
        //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();

        getSubSets(nums,0, subSets, new ArrayList<>());

        return subSets;
    }

    public static void getSubSets (int[]nums, int start, List<List<Integer>> subSets, ArrayList<Integer> set) {
        subSets.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            set.add(num);

            getSubSets(nums, i + 1, subSets, set);
            set.remove(set.size() - 1);
        }
    }
}
