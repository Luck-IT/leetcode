package solution0207;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月12日
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != null && pB != null){
            pA = pA.next;
            pB = pB.next;
        }
        if(pA == null && pB == null){
            pA = headA;
            pB = headB;
            while(pA != null){
                if(pA == pB){
                    return pA;
                }
                pA = pA.next;
                pB = pB.next;
            }
        }else{
            ListNode longP = pA == null?pB:pA;
            ListNode startP = pA == null?headB:headA;
            ListNode compP = pA == null?headA:headB;
            while(longP!= null){
                startP= startP.next;
                longP = longP.next;
            }
            while(compP!= null){
                if(compP == startP){
                    return compP;
                }
                compP = compP.next;
                startP = startP.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] Aa = new int[]{4,1,8,4,5};
        int[] Ba = new int[]{5,0,1,8,4,5};
        ListNode headA= new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode pA = headA;
        for(int i=1;i<2;i++){
            pA.next = new ListNode(Aa[i]);
            pA = pA.next;
        }
        ListNode pB = headB;
        for(int i=1;i<3;i++){
            pB.next = new ListNode(Ba[i]);
            pB = pB.next;
        }
        for(int i=2;i<Aa.length;i++){
            ListNode tmp = new ListNode(Aa[i]);
            pA.next = tmp;
            pB.next = tmp;
            pA = tmp;
            pB = tmp;
        }
        Solution s = new Solution();
        ListNode result = s.getIntersectionNode(headA, headB);
        System.out.println("=============");
        
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}
