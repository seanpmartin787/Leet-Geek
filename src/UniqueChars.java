import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UniqueChars {
    public static void main(String[] args) {
        System.out.println(isUnique("tt"));
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("abca"));
        System.out.println(isUnique("abcA"));

    }
    public static boolean isUnique(String str) {
        if (str.length() > 128) return false; //by pigeonhole principle

        var chSet = new HashSet<Character>();
        for (char ch: str.toCharArray()) {
            if (chSet.contains(ch)) return false;
            else chSet.add(ch);
        }
        return true;
    }
}
