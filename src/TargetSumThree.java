import java.util.*;

public class TargetSumThree {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length >= 3) {
            Set<List<Integer>> foundTriples = new HashSet<>();
            //Hash map for search on values, but maintaining indexes as the value
            Arrays.sort(nums);
            TreeMap<Integer, Integer> numMap = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                //our target is 2 numbers that add up to -nums[i] -- ie. they cancel each other out
                //int target = -nums[i];
                //i = nums[i];
                int j = i + 1;
                int k = nums.length -1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        //If matching sum
                        foundTriples.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    } else if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    }
                }
            }//for length of list
            return new ArrayList<>(foundTriples);

        } else {
            return new ArrayList<>();
        }//Else it is too small, return empty set
    }
}
