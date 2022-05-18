public class IsMatchString {
    public static void main(String[] args) {
//        System.out.println(isMatch(null,"a"));
//        System.out.println(isMatch("",""));
//        System.out.println(isMatch("","a"));
//        System.out.println(isMatch("","*"));
//        System.out.println(isMatch("aa",""));
//        System.out.println(isMatch("aa","a"));
//        System.out.println(isMatch("aa","*b"));
//        System.out.println(isMatch("cb","?a"));
//        System.out.println(isMatch("cb","*****"));
//        System.out.println(isMatch("csdfssfsdffdb","c*b"));
//        System.out.println(isMatch("csdfssfsdffdbbbb","c*b*"));
        System.out.println(isMatch("abcabczzzde","*abc???de*"));
        //"abcabczzzde"
        //"*abc???de*"
    }
    public static boolean isMatch(String s, String p) {
        //so we want to search through s to see if it matches p
        // * is an anything wildcard (including an empty sequence)
        // ? is a single character replacement
        // Edge cases:
        //s or p is null
        //s and p is empty
        //s is empty (the only valid p would be *)
        //p is empty (is this a match or no?)
        //else we search through s + p
        if (s == null || p == null) return false;
        if (s.isEmpty() && p.isEmpty()) return true;
        if (s.isEmpty()) return p.charAt(0) == '*';
        if (p.isEmpty()) return false;

        int i=0, j=0;
        while (i < p.length() && j < s.length()) {
            char charP = p.charAt(i); //a
            char charI = s.charAt(j);
            if (charP == charI || charP == '?') {
                j++;
                i++;
            }
            else if (charP == '*') {
                while (i < p.length() && p.charAt(i) == '*') i++;
                if (i == p.length()) return true; //if we have nothing but * left it has to be true
                else {
                    charP = p.charAt(i);
                    while (j < s.length() && s.charAt(j) != charP) j++;
                    if (j == s.length()) return false; //If we never match the next p character this pattern won't match
                }
            } else return false;
            if (i == p.length() && j == s.length()) return true;
        }
        return false; //if we never finished the pattern, return false
    }
}
