public class BackspaceStringCompare {
    public static void main(String[] args) {
        String one = "ab##";

        String two = "c#d#";

        System.out.println(backspaceCompare(one,two));


    }
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#') {
                    sb.deleteCharAt(i);
                    i--;
                if (i >= 0) {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        for (int i = 0; i < tb.length(); i++) {
            if (tb.charAt(i) == '#') {
                tb.deleteCharAt(i);
                i--;
                if (i >= 0) {
                    tb.deleteCharAt(i);
                    i--;
                }
            }
        }
        if (tb.length() != sb.length()) return false;
        else {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) != tb.charAt(i)) return false;
            }
        }
        return true;
    }
}
