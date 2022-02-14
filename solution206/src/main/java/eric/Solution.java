package eric;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月10日
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head){
        if(head == null){
            return head;
        }
        return reverseList2(null,head);
    }

    public ListNode reverseList2(ListNode pre,ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode tmp = cur.next;
        cur.next = pre;
        return reverseList2(cur,tmp);

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
