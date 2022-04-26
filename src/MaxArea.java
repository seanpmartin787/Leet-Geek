public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }
    public static int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = (end - start) * Math.min(height[start], height[end]);
        int area = 0;

        while (start != end) {
            if (height[start] < height[end]) start++;
            else end--;
            area = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, area);
        }
        return max;
    }
}
