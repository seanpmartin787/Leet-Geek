import java.util.*;

public class TargetSumThree {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> foundTriples = new ArrayList<>();
        if (nums.length >= 3) {
            //Hash map for search on values, but maintaining indexes as the value
            TreeMap<Integer, Integer> numMap = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                //our target is 2 numbers that add up to -nums[i] -- ie. they cancel each other out
                int target = -nums[i];

                for (int j = (i + 1); j < nums.length; j++) {
                    //Now we basically find a number that offsets target - nums[j]
                    // ie. Is there a number so that number = nums[i] + nums[j]
                    Integer kValue = (Integer) (target - nums[j]);
                    if (numMap.containsKey(kValue)) {
                        int k = numMap.get(kValue);
                        if (i != k && j != k) {
                            foundTriples.add(Arrays.asList(nums[i], nums[j], kValue));
                            numMap.remove(nums[j]);
                        }//If conditions met
                    } else {
                        numMap.put(nums[j], j);
                    }//If we haven't already added key, add it
                }//end 2 sum
            }//end 3 sum

            return foundTriples;

        } else {
            return foundTriples;
        }//Else it is too small, return null
    }
}
