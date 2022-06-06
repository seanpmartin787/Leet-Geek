import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
    public static List<String> fizzBuzz(int n) {

        List<String> wordList = new ArrayList<>();

        //define default initialization for a new HashMap
        HashMap<Integer, String> codeDict = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };


        for (int i = 1; i <= n ; i++) {
            String toAdd = "";

            for (Integer key : codeDict.keySet()) {
                if (i % key == 0) {
                    toAdd += codeDict.get(key);
                }
            }
            if (toAdd.isBlank()) {
                toAdd = Integer.toString(i);
            }
            wordList.add(toAdd);
        }

        return wordList;
    }
}