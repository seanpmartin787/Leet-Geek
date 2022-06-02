import java.net.URL;
import java.util.*;

public class URLify {


    public static void main(String[] args) {
        var test = new URLify();

        System.out.println(test.toURL(new char[] {'T',' ','T',' ',' '}, 2));
        System.out.println(test.toURL(new char[] {}, 1));

        System.out.println("done");
    }
    public char[] toURL (char[] charArr, int tEnd) {

        List<Integer> stack = new Stack<Integer>();

        if (tEnd == 0 || charArr == null || charArr.length == 0) return new char[] {};

        for (int end = charArr.length-1;tEnd >= 0; tEnd--) {
            char ch = charArr[tEnd];
            if (ch == ' ') end = insertSpace(end, charArr);
            else charArr[end--] = ch;
        }
        return charArr;
    }

    private int insertSpace(int end, char[] charArr) {
        charArr[end--] = '0';
        charArr[end--] = '2';
        charArr[end--] = '%';
        return end;
    }
}
