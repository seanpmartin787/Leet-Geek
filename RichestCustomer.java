class Solution {
    public int maximumWealth(int[][] accounts) {
        int winnerWinner = 0;
        int currentPerson = 0;
        for (int i = 0; i < accounts.length; i++) {
            currentPerson = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                currentPerson += accounts[i][j];
            }
            if (currentPerson > winnerWinner) {
                winnerWinner = currentPerson;
            }//If new winner 
            
        }
        return winnerWinner;
    }
}