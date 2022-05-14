import java.util.ArrayList;
import java.util.List;

public class KBeauty {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240,2));
    }
    public static int divisorSubstrings(int num, int k) {
        //this is basically the combinations of int num choose K
        //parse into String so we can access the indexes
        String numString = Integer.toString(num);
        List<List<Character>> solutions = new ArrayList<>();
        combine(solutions, new ArrayList<>(), numString, 0, numString.length(), k);
        return solutions.size();
    }

    private static void combine(List<List<Character>> solutions, List<Character> comb, String numString, int start, int n, int k) {
        if(k==0) {
            solutions.add(new ArrayList<>(comb));
            return;
        }
        //240
        //k = 2
        //n=3
        for(int i=start;i<n-k+1;i++) {
            char newChar = numString.charAt(i);
            if (comb.size() == 0 && newChar == '0') continue; // no valid combinations with a leading zero

            comb.add(newChar);
            combine(solutions, comb, numString,i + 1, n, k - 1);
            comb.remove(comb.size() - 1);

        }
    }
}
