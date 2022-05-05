import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsDupes {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2,2,4}));
        //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        Arrays.sort(nums);
        getSubSets(nums,0, subSets, new ArrayList<>());

        return subSets;
    }

    public static void getSubSets (int[]nums, int start, List<List<Integer>> subSets, ArrayList<Integer> set) {
        subSets.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if(i > start && num == nums[i-1]) continue;

            set.add(num);

            getSubSets(nums, i + 1, subSets, set);
            set.remove(set.size() - 1);
        }
    }
}
