import java.util.HashMap;

public class NumDecoding {
    private static final HashMap<String, Character> dict = new HashMap() {{
        put("1",'a');
        put("2",'b');
        put("3",'c');
        put("4",'d');
        put("5",'e');
        put("6",'f');
        put("7",'g');
        put("8",'h');
        put("9",'i');
        put("10",'j');
        put("11",'k');
        put("12",'l');
        put("13",'m');
        put("14",'n');
        put("15",'o');
        put("16",'p');
        put("17",'q');
        put("18",'r');
        put("19",'s');
        put("20",'t');
        put("21",'u');
        put("22",'v');
        put("23",'w');
        put("24",'x');
        put("25",'y');
        put("26",'z');
    }
    };

    public static void main(String[] args) {
        System.out.println("null returns: " + numDecodings(null));
        System.out.println("empty string returns: " + numDecodings(""));
        System.out.println("0 returns: " + numDecodings("0"));
        System.out.println("a returns: " + numDecodings("a"));
        System.out.println("666666 returns: " + numDecodings("666666"));
        System.out.println("111 returns: " + numDecodings("111"));

    }
    public static int numDecodings(String s) {
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
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return dict.containsKey(Character.toString(s.charAt(0))) ? 1 : 0;
        int numEncodings = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (!dict.containsKey(Character.toString(s.charAt(i)))
                    || !dict.containsKey(Character.toString(s.charAt(i+1)))) return 0;
            if (isValidDoubleDigit(s.charAt(i),s.charAt(i+1))) numEncodings++;
        }
        return numEncodings;
    }
    private static boolean isValidDoubleDigit (char firstDigit, char secondDigit) {
        //possible combinations
        // first digit is 1
        // first digit is 2 AND second digit is less than 7
        return firstDigit == '1' || (firstDigit == '2' && secondDigit < 7) ? true : false;
    }
}
