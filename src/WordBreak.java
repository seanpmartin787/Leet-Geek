import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        //"leetcode"
        //["leet","code"]
        List<String> wordDict = new ArrayList<>() {{
           add("leet");
           add("code");
        }};
        System.out.println(wordBreak("leetcode", wordDict));

        //"bb"
        //["a","b","bbb","bbbb"]
        wordDict = new ArrayList<>() {{
            add("a");
            add("b");
            add("bbb");
            add("bbbb");
        }};
        System.out.println(wordBreak("bb", wordDict));

        //"aaaaaaa"
        //["aaaa","aaa"]
        wordDict = new ArrayList<>() {{
            add("aaaa");
            add("aaa");
        }};
        System.out.println(wordBreak("aaaaaaa", wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        //we want s to have a non overlapping substring for each word in wordDict

        HashSet<String> wordSet = new HashSet<>(wordDict);

            boolean[] f = new boolean[s.length() + 1];

            f[0] = true;

            for(int i=1; i <= s.length(); i++){
                for(int j=0; j < i; j++){
                    if(f[j] && wordSet.contains(s.substring(j, i))){
                        f[i] = true;
                        break;
                    }
                }
            }

            return f[s.length()];
        }
}
