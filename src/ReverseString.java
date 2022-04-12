public class ReverseString {
    public void reverseString(char[] s) {

        int low = 0, high = s.length - 1;
        char temp;

        while (low<high) {
            temp = s[high];
            s[high--] = s[low];
            s[low++] = temp;
        }
    }
}
