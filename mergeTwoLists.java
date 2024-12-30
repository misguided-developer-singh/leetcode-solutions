

public class mergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to help simplify the merge process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            // Traverse both lists and merge them
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // If there are remaining nodes in list1 or list2, append them
        if(list1 != null) current.next = list1;
        else current.next = list2;

        // Return the merged list, starting from the next of the dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create two example linked lists
//        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode list1 = null;
        ListNode list2 = new ListNode(2);

        ListNode mergedList = mergeTwoLists(list1, list2);

        while(mergedList != null) {
            System.out.print(mergedList.val + "->");
            mergedList = mergedList.next;
        }
    }
}






class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}