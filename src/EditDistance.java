public class EditDistance {
    public static void main (String[] args) {
        System.out.println(isOneAway("A","A"));
        System.out.println(isOneAway("A",""));
        System.out.println(isOneAway("A","ABC"));
        System.out.println(isOneAway("A","AB"));
        System.out.println(isOneAway("",""));
        System.out.println(isOneAway("B","C"));

    }
    public static boolean isOneAway (String m, String n) {
        if (m == null || n == null || Math.abs(m.length() - n.length()) > 1) return false;

        int[][] memo = new int[m.length()+1][n.length()+1];
        int insert=0,delete=0,replace=0;

        for (int i=0; i<m.length(); i++) {
            char mChar = m.charAt(i);
            for (int j=0; j<n.length(); j++) {
                char nChar = n.charAt(j);
                if (mChar == nChar) memo[i+1][j+1] = memo[i][j];
                else {
                    replace = memo[i][j];
                    delete = memo[i][j+1];
                    insert = memo[i+1][j];
                    memo[i+1][j+1] = Math.min(replace, Math.min(delete,insert));
                }
            }
        }
    return memo[m.length()][n.length()] <= 1;
    }
}
