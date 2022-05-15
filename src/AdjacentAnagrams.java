import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacentAnagrams {
    public static void main(String[] args) {
//        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
//        System.out.println(removeAnagrams(new String[] {"a","b","c","d","e"}));
        System.out.println(removeAnagrams(new String[] {"zlipeytnb","zlneytbpi","iplzebtny","tezbnyilp","bytzpnile",
                "pebtnlyiz","pblnyetzi","ypiltbzne","y","y","y","y","y","y","y","y"}));

    }
    public static List<String> removeAnagrams(String[] words) {
        HashMap<Character,Integer> freq = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String word: words) {
            res.add(word);
        }

        for (int i = words.length - 1; i > 0; i--) {
            if (words[i].length() != words[i-1].length()) continue;
            getFrequency(freq, words[i]);
            //compare frequencies
            for (int j = 0; j < words[i-1].length(); j++) {
                char currentChar = words[i-1].charAt(j);
                if (freq.containsKey(currentChar)) {
                    if (freq.get(currentChar) > 1) freq.replace(currentChar,freq.get(currentChar)-1);
                    else freq.remove(currentChar);
                } else break; //if word 2 has a different character then we don't have an anagram
            }
            if (freq.size() == 0) res.remove(i);
        }
        return res;
    }

    private static void getFrequency (HashMap<Character,Integer> freq, String word) {
        freq.clear();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (freq.containsKey(currentChar)) {
                freq.replace(currentChar,freq.get(currentChar)+1);
            } else freq.put(currentChar,1);
        }
    }
}
