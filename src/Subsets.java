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
        subSets.add(null);

        getSubSets(nums,0, subSets, new ArrayList<>(), new HashSet<>());

        return subSets;
    }

    public static void getSubSets (int[]nums, int start, List<List<Integer>> subSets, ArrayList<Integer> set, HashSet<Integer> alreadyAdded) {
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (alreadyAdded.contains(num)) continue;
            set.add(num);
            alreadyAdded.add(num);
            subSets.add(new ArrayList<>(set));

            if (set.size() != nums.length) getSubSets(nums, start + 1, subSets, set, alreadyAdded);

            alreadyAdded.remove(set.get(set.size() - 1));
            set.remove(set.size() - 1);
        }

    }
}
