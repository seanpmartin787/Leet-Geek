import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyLLWithRandom {

// Definition for a Node.
private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    public static void main(String[] args) {
        //[7,null],[13,0],[11,4],[10,2],[1,0]
        Node zero = new Node(7);
        Node one = new Node(13);
        Node two = new Node(11);
        Node three = new Node(10);
        Node four = new Node(1);

        zero.next = one;
        one.next = two;
        one.random = zero;
        two.next = three;
        two.random = four;
        three.next = four;
        three.random = two;
        four.random = zero;

        Node root = copyRandomList(zero);

        System.out.println("all done");

    }

    public static Node copyRandomList(Node head) {
        //I know this one
        //We want to loop through the original list twice
        //The first time we will create a copy of each node, and a copy of the next
        //We will also add each of these new nodes to a HashMap for random pointer assignment
        //Then we will loop through each list again, this time assigning the random pointers (can't do it off of value because of duplicate values
        //edge cases:
            //head is null: return null
            //head is just one node: return new node
            //all values are the same for unique nodes: we need to cache location of second list based on index, not value
        if (head == null) return null;
        //declare the variables we will need
        Map<Integer,Node> newListMap = new HashMap();
        Map<Node,Integer> randomIndexMap = new HashMap();
        Node current = head, currentOther = null, newHead = null;
        int i = 0;
        ////[7,null],[13,0],[11,4],[10,2],[1,0]
        while (current != null) {
            //This will allow random access lookup for random pointer assignment
            randomIndexMap.put(current, i++);
            current = current.next;
        }
        //reset current and i
        i=0;
        current = head;

        //don't have to worry about null b/c of edge case checking
        //intitialize new list
        newHead = new Node(head.val);
        currentOther = newHead;
        newListMap.put(i++,currentOther);

        //copy list and cache indexes of otherList nodes
        while (current != null && current.next != null) {
            currentOther.next = new Node(current.next.val);
            newListMap.put(i++,currentOther.next);
            current = current.next;
            currentOther = currentOther.next;
        }

        //reset currentOther and current
        current = head;
        currentOther = newHead;
        //loop through once more to assign random pointers
        //we will get the index of current's random pointer from randomIndexMap
        //and then get the node at that index in new list with newListMap
        while (current != null) {
            if (current.random != null) currentOther.random = newListMap.get(randomIndexMap.get(current.random));
            current = current.next;
            currentOther = currentOther.next;
        }
        return newHead;
    }
}
