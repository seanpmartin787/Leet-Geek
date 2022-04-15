import java.util.HashMap;


public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("hello","ooolleoooleh"));
    }

    public static class MutableInt {
        int value = 1; // note that we start at 1 since we're counting
        public void increment () { ++value;      }
        public int  get ()       { return value; }
    }

    public static boolean checkInclusion(String s1, String s2) {
        boolean found = false;

        HashMap<Character, MutableInt> map1 = new HashMap<>();
        HashMap<Character, MutableInt> map2 = new HashMap<>();
        int i = 0, j = 0;


        for (int k = 0; k < s1.length(); k++) {
            char currentChar = s1.charAt(i);
            MutableInt count = map1.get(currentChar);
            if (count == null) {
                map1.put(currentChar, new MutableInt());
            }
            else {
                count.increment();
            }
        }

        while (i < s2.length() && !found) {
            int letterCount = s1.length();
            j = i++;

            while (j < s2.length() && (j-i) < s1.length()) {
                char currentChar = s2.charAt(j++);
                if (!map1.containsKey(currentChar)) break;

                letterCount++;
            }
            if (letterCount == s1.length()) found = true;
        }

        return found;
    }
}
