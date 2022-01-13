package solution19;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月11日
*/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ){
            return null;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(n-- > 0 && fast!= null){
            fast = fast.next;
        }
        fast =fast.next;
        while(fast!=null){
            fast = fast.next;
            slow= slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
