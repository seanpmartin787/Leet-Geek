import static java.lang.Character.getNumericValue;

public class DigitNumberCount {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        for (int i = 0; i < num.length(); i++) freq[Integer.parseInt(String.valueOf(((num.charAt(i)))))]++;
        for (int i = 0; i < num.length(); i++) if (freq[i] != Integer.parseInt(String.valueOf(((num.charAt(i)))))) return false;
        return true;
    }
}
