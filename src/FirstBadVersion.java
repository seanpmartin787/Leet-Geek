public class FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 1, h = n, m = 0;

            if (n == 1) return 1;

            while (l < h) {
                m = l + (h-l) / 2;
                if (!isBadVersion(m)) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }//Binary search
            return l;
        }
    }

    private static class VersionControl {
        public static boolean isBadVersion(int n) {
            return true;
        }
    }
}
