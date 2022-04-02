import java.util.LinkedList;

class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int numSoldiers = 0;
        int index = 0;
        LinkedList <Integer> LL= new LinkedList<>();

        for (int[] army : mat) {
            for (int soldier : army) {
                numSoldiers += soldier;
            }
            if (LL.size() > 0 && numSoldiers >= LL.peek()) {
                //Add to front of list
                LL.addFirst(index);
            } else {
                LL.push(index);
            }//Else 
            index++;
        }
        int[] array = new int [k];

        for (int i = 0; i < k; i ++) {
            array[i] = LL.pop();
        }//create array of ints
        
        return array;
    }
}