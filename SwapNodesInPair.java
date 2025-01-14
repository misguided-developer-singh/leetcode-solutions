public class SwapNodesInPair {
    public static ListNode swapPairs(ListNode head) {

        // Create a dummy node to handle edge cases like the head being null or having only one node
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // Initialize the previous node to the dummy node
        ListNode prevNode = dummyNode;
        ListNode curr = head;

        while(curr != null && curr.next != null) {

            // Swap the pair
            prevNode.next = curr.next;
            curr.next = prevNode.next.next;
            prevNode.next.next = curr;

            // Move the 'prevNode' and 'curr' pointers forward by two nodes
            prevNode = curr;
            curr = curr.next;
        }
        // Return the new head, which is the next node after the dummy node
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Perform the pair swap operation
        ListNode resultantList = swapPairs(head);

        // Print the resulting swapped linked list
        while (resultantList != null) {
            System.out.print(resultantList.val);
            if (resultantList.next != null) {
                System.out.print(" -> ");
            }
            resultantList = resultantList.next;
        }
        System.out.println(); // Print a newline after the list

    }
}




