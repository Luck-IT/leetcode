package eric;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月11日
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode tmp = dummy;
        while(tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}