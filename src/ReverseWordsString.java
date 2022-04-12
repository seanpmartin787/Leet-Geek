public class ReverseWordsString {
    public static void main(String[] args) {
        String newS = "This string";

        ReverseWordsString ob = new ReverseWordsString();
        newS =  ob.reverseWords(newS);

        System.out.println(newS);

    }
        public String reverseWords(String s) {

            //declare variables
            int low = 0, high = 0;
            char temp;

            //Initialize StringBuilder for char manipulation of String
            StringBuilder flipString = new StringBuilder(s);

            for (int i = 0; i < s.length(); i++) {
                low = high = i;

                //find next space
                while (high < flipString.length() && flipString.charAt(high) != ' ') {
                    high++;
                }//get end of first word

                //when i increments it will be at the start of the next word
                i = high;
                //since high is at the space, set it to the end of the last word
                high--;

                //now we can just swap the characters in the string
                while (low < high) {
                    temp = s.charAt(high);
                    flipString.setCharAt(high--, flipString.charAt(low));
                    flipString.setCharAt(low++, temp);
                }
            }//Loop through string
            //convert back to string
            return flipString.toString();
        }
}
