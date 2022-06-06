public class Mahjong {
    /* You've decided to make an advanced version of a variant of the game Mahjong, incorporating runs.

Players have a number of tiles, each marked 0-9. The tiles can be grouped into pairs or triples of the same tile or runs.

A run is a series of three consecutive tiles, like 123, 678, or 456. 0 counts as the lowest tile, so 012 is a valid run, but 890 is not.

A complete hand consists of exactly one pair, and any number (including zero) of triples and/or three-tile runs. Each tile is used in exactly one triple, pair, or run.

Write a function that returns true or false depending on whether the collection represents a complete hand under these rules.

hand1 = "11123"          # True. 11 123
hand2 = "12131"          # True. Also, 11 123. Tiles are not necessarily sorted.
hand3 = "11123455"       # True. 111 234 55
hand4 = "11122334"       # True. 11 123 234
hand5 = "11234"          # True. 11 234
hand6 = "123456"         # False. Needs a pair
hand7 = "11133355577"    # True. 111 333 555 77
hand8 = "11223344556677" # True. 11 234 234 567 567 among others
hand9 = "12233444556677" # True. 123 234 44 567 567
hand10 = "11234567899"   # False.
hand11 = "00123457"      # False.
hand12 = "0012345"       # False. A run is only three tiles
hand13 = "11890"         # False. 890 is not a valid run
hand14 = "99"            # True.
hand15 = "111223344"     # False.

All Test Cases
advanced(hand1)  => True
advanced(hand2)  => True
advanced(hand3)  => True
advanced(hand4)  => True
advanced(hand5)  => True
advanced(hand6)  => False
advanced(hand7)  => True
advanced(hand8)  => True
advanced(hand9)  => True
advanced(hand10) => False
advanced(hand11) => False
advanced(hand12) => False
advanced(hand13) => False
advanced(hand14) => True
advanced(hand15) => False

Complexity Variable
N - Number of tiles in the input string*/


    public static void main(String[] args) {

        String hand1 = "11123";          // True. 11 123
        String hand2 = "12131";          // True. Also, 11 123. Tiles are not necessarily sorted.
        String hand3 = "11123455";       //True. 111 234 55
        String hand4 = "11122334";       //True. 11 123 234
        String hand5 = "11234";          //True. 11 234
        String hand6 = "123456";         //False. Needs a pair
        String hand7 = "11133355577";    //True. 111 333 555 77
        String hand8 = "11223344556677"; //True. 11 234 234 567 567 among others
        String hand9 = "12233444556677"; //True. 123 234 44 567 567
        String hand10 = "11234567899";   //False.
        String hand11 = "00123457";      //False.
        String hand12 = "0012345";       //False. A run is only three tiles
        String hand13 = "11890";         //False. 890 is not a valid run
        String hand14 = "99";            //True.
        String hand15 = "111223344";     //False.

        System.out.println(isValidHand(hand1));
        System.out.println(isValidHand(hand2));
        System.out.println(isValidHand(hand3));
        System.out.println(isValidHand(hand4));
        System.out.println(isValidHand(hand5));
        System.out.println(isValidHand(hand6));
        System.out.println(isValidHand(hand7));
        System.out.println(isValidHand(hand8));
        System.out.println(isValidHand(hand9));
        System.out.println(isValidHand(hand10));
        System.out.println(isValidHand(hand11));
        System.out.println(isValidHand(hand12));
        System.out.println(isValidHand(hand13));
        System.out.println(isValidHand(hand14));
        System.out.println(isValidHand(hand15));




/*
All Test Cases
advanced(hand1)  => True
advanced(hand2)  => True
advanced(hand3)  => True

advanced(hand4)  => True
advanced(hand5)  => True
advanced(hand6)  => False

advanced(hand7)  => True
advanced(hand8)  => True
advanced(hand9)  => True

advanced(hand10) => False
advanced(hand11) => False
advanced(hand12) => False

advanced(hand13) => False
advanced(hand14) => True
advanced(hand15) => False
    */

    }



    public static boolean isValidHand(String str) {
        int[] sortedHand = new int[10];
        int numCards = str.length();

        for (char ch: str.toCharArray()) sortedHand[ch - '0']++;

        for (int i = 0; i <= 9; i++) {
            //pick out a pair and then find out if it can make a valid
            if (sortedHand[i] < 2) continue; //can't make a pair
            sortedHand[i] -= 2;
            if (isValidHand(sortedHand, numCards - 2)) return true;
            sortedHand[i] += 2; //otherwise keep searching
        }
        return false; //if we never found a valid hand
    }

    public static boolean isValidHand (int[] sortedHand, int numCards) {
        if (numCards == 0) return true;
        if (numCards < 3) return false; // we have leftovers
        //base cases, no we backtrack

        //two options
        //first three sums, b/c I like that one more
        for (int i=0; i <= 9; i++) {
            if (sortedHand[i] >= 3) {
                sortedHand[i] -= 3;
                if (isValidHand(sortedHand, numCards - 3)) return true;
                sortedHand[i] += 3;
            }
        }
        //now let's give series a go
        for (int i=0; i <= 7; i++) {

            if (sortedHand[i] >= 1 && sortedHand[i+1] >= 1 && sortedHand[i+2] >= 1) {
                for (int j = i; j <= i + 2; j++) sortedHand[j]--;
                if (isValidHand(sortedHand, numCards - 3)) return true;
                for (int j = i; j <= i + 2; j++) sortedHand[j]++;
            }
        }
        return false; //no luck
    }

    public static boolean isValidHandEasy(String str) {

        int[] numberFreq = new int[10];
        boolean pairFound = false;

        for (char ch: str.toCharArray()) {
            numberFreq[Character.getNumericValue(ch)]++;
        }

        for (int i = 0; i < 10; i++) {
            int leftOver = numberFreq[i] % 3;
            if (leftOver == 1) return false;
            else if (leftOver != 0) {
                if (pairFound) return false;
                else pairFound = true;
            }
        }

        return pairFound;
    }

}

