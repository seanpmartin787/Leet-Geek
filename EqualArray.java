class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        boolean match = true;
        int otherI = 0;
        int otherJ = -1;
        for (int i = 0; i < (word1.length) ; i++) {
            for (int j = 0; j < (word1[i].length()) ; j++) {
                otherJ++; 
                  try {
                      match = ((word1[i].charAt(j)) == (word2[otherI].charAt(otherJ)));
                  } catch (Exception e) {
                      try {
                          otherI++;
                          otherJ = 0;
                          match = ((word1[i].charAt(j)) == (word2[otherI].charAt(otherJ)));
                      } catch (Exception e2) {
                          return false;
                      }
                  }
                
            }
        }
        if ((otherI) < (word2.length - 1) || (otherJ) < (word2[otherI].length() -1)) {
            return false;
        }
        
        return match;
    }
}