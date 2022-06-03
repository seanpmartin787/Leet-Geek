public class CompareTimeSlots {
    public static int compareOpenings (int[][] a, int[][] b, int minDuration) {
        // example: a [0,5],[10,15],[30,45]
        //          b [5,10],[11,15],[36,42] | minDuration = 6

        //edge cases:
        if (a == null || b == null) return -1;


        int aTimeSlot = 0,  bTimeSlot = 0, overlap = 0, start, end;

        while(aTimeSlot < a.length && bTimeSlot < b.length) {
            start = Math.max(a[aTimeSlot][0],b[bTimeSlot][0]);
            end = Math.min(a[aTimeSlot][1],b[bTimeSlot][1]);
            overlap = end - start + 1;

            if (overlap >= minDuration) return start;
            else if (a[aTimeSlot][1] == b[bTimeSlot][1]) {
                //if they have the same end times than we can advance both
                aTimeSlot++;
                bTimeSlot++;
            }
            //otherwise we advance the earlier one
            else if (end == a[aTimeSlot][1]) aTimeSlot++;
            else bTimeSlot++;
        }
        //if not found return -1
        return -1;
    }
}
