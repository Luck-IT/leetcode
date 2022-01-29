package solution142;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月13日
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            fast = fast.next;
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast == slow){
                ListNode meetIndex = fast;
                ListNode start = head;
                while(meetIndex!= start){
                    meetIndex = meetIndex.next;
                    start = start.next;
                }
                return start;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
