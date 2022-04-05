import java.util.PriorityQueue;

class WeakestMatrix {

    public static void main() {
        System.out.println("Testing my WeakestMatrix class");
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        //Create Comparator with Lambda expression that compares a int[2] array defined as such [armySize,index]
        //If army sizes are diferent it will order by army size, else it will order by index
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        //Loop through and values
        for (int index = 0; index < mat.length; index++){
            int lo = 0, hi = mat[index].length; 
            
            //Binary search
            while(lo < hi){
                int mid = (lo + hi) / 2;
                if (mat[index][mid] != 0) lo = mid + 1;
                else hi = mid;
            }
            
            //[armySize,index]
            q.add(new int[]{lo, index});
        }
        
        //Now create outpute array of size k
        int[] output = new int[k];
        for(int i = 0; i < k; i++)  output[i] = q.remove()[1];
        return output;
    }
}