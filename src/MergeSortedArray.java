import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        merge(new int[] {1}, 1,new int[] {},0);
        merge(new int[1], 0,new int[] {1},1);
        merge(new int[] {1,2,3,0,0,0}, 3,new int[] {2,2,2},3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }
}
