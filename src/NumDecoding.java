import java.util.HashMap;

public class NumDecoding {

    public static void main(String[] args) {
        System.out.println("empty string returns: " + numDecodings(""));
        System.out.println("0 returns: " + numDecodings("0"));
        System.out.println("a returns: " + numDecodings("a"));
        System.out.println("666666 returns: " + numDecodings("666666"));
        System.out.println("111 returns: " + numDecodings("111"));
        System.out.println("226 returns: " + numDecodings("226"));
        System.out.println("10 returns: " + numDecodings("10"));
        System.out.println("110 returns: " + numDecodings("110"));

    }
        //given this string s, which will be a series of number digits, we need to decode it with this mapping:
        // 1 -> a, 2 -> b, 3 -> c ... 26 -> z
        // this is not so easy, because string "111" could be "aaa" or "ka" or "ak"
        // edge cases:
        // invalid input (0,-1,b) -> return 0
        // s.length == 0 ("") -> return 0
        // s is size 1 and valid -> return mapping of letter
        // every input has one solution (66666) -> "ggggg" -> return 1
        // or, we have to find all the possible solutions in a mix ("111" could be "aaa" or "ka" or "ak") -> return 3
        // we know that it can have multiple interpretations if the first number is 0 < num < 3 and second number is 0 < num2 < 7
        //every time there is a double entendre it increases the num of encodings by one
        //last digit is a zero
        public static int numDecodings(String s) {
            int n=s.length();
            int curr = 0, dp1 = 1, dp2 = 0;
            for(int i=n-1;i>=0;i--) {
                curr = s.charAt(i) == '0' ? 0 : dp1;
                if (i < n - 1 && isValidDoubleDigit(s.charAt(i), s.charAt(i + 1)))
                    curr += dp2;
                dp2 = dp1;
                dp1 = curr;
            }
            return dp1;
        }
    private static boolean isValidDoubleDigit (char firstDigit, char secondDigit) {
        //possible combinations
        // first digit is 1
        // first digit is 2 AND second digit is less than 7
        return firstDigit == '1' || (firstDigit == '2' && secondDigit < '7');
    }
}
