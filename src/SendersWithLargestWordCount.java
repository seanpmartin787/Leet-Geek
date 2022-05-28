import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class SendersWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {

        int count = 0, max = 0;
        HashMap<String,Integer> senderWordCount = new HashMap<>();
        Queue<String> busySenders = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < messages.length; i++) {
            String[] arrayOfStrings = messages[i].split(" ");
            count = arrayOfStrings.length;

            if (senderWordCount.containsKey(senders[i])) {
                senderWordCount.replace(senders[i], senderWordCount.get(senders[i]) + count);
                count = senderWordCount.get(senders[i]);
            } else {
                senderWordCount.put(senders[i], count);
            }

            if (count > max) {
                busySenders.clear();
                busySenders.add(senders[i]);
                max = count;
            } else if (count == max) busySenders.offer(senders[i]);
        }
        return busySenders.peek();
    }
}
