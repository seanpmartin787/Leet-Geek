import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutationBFS {
    public List<String> letterCasePermutation(String s) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                //For the currently found character, create two strings
                //One with an upper case version
                //and one with a lower case version
                String current = queue.poll();
                char[] currentChars = current.toCharArray();

                currentChars[i] = Character.toUpperCase(currentChars[1]);
                queue.offer(String.valueOf(currentChars));

                currentChars[i] = Character.toLowerCase(currentChars[1]);
                queue.offer(String.valueOf(currentChars));
            }
        }

        return new LinkedList<>(queue);
    }


}
