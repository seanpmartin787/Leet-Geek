public class GreatestUpperAndLowerInString {
    public String greatestLetter(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char ch: s.toCharArray()) {
            if (Character.isUpperCase(ch)) upper[ch - 'A']++;
            else lower[ch - 'a']++;
        }

        for (int i = 25; i >= 0; i--) {
            if (upper[i] > 0 && lower[i] > 0) return Character.toString((char)i + 'A');
        }

        return "";
    }
}
