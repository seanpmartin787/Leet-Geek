import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {

        List<String> perms = new LinkedList<>();
        getPerms (s.toCharArray(), perms, 0);
        return perms;
    }
    private static void getPerms (char[] chars, List<String> list, int pos) {
        if (pos == chars.length) {
            list.add(new String(chars));
        } else if (chars[pos] >= '0' && chars[pos] <= '9') {
            //Nothing to do if it is a number
            getPerms(chars, list, pos + 1);
        } else {
            chars[pos] = Character.toLowerCase(chars[pos]);
            getPerms(chars, list, pos + 1);

            chars[pos] = Character.toUpperCase(chars[pos]);
            getPerms(chars, list, pos + 1);
        }

    }

}
