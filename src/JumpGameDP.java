public class JumpGameDP {
    public static void main(String[] args) {
        //[2,3,1,1,4]
        System.out.println(canJumpForwards(new int[] {3,2,1,0,4}));
    }
    public static boolean canJump(int[] nums){
        int last=nums.length - 1,i,j;

        for(i = nums.length - 2 ; i >= 0; i--){
            if(i + nums[i] >= last) last = i;
        }

        return last <= 0;
    }

    public static boolean canJumpForwards(int[] nums) {
            int maxLocation = 0;
            for(int i=0; i<nums.length; i++) {
                if(maxLocation<i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
                maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
            }
            return true;
    }
}
