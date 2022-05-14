import java.util.ArrayList;
import java.util.List;

public class KBeauty {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(430043,2));
        System.out.println(divisorSubstrings(430043,6));
        System.out.println(divisorSubstrings(430043,8));
        System.out.println(divisorSubstrings(30003,3));
    }
    public static int divisorSubstrings(int num, int k) {
        //parse into String so we can access the indexes
        String numString = Integer.toString(num);
        int counter = 0;
        //we can just loop through this string in O(N) time
        for (int i=0; i < numString.length()-k+1; i++) {
                int divisor = Integer.parseInt(numString.substring(i,i+k));
                if (divisor == 0) continue; //divide by zero error
                counter += num % divisor == 0 ? 1 : 0;
        }
        return counter;
    }
}
