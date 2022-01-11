package solution707;

/**
* MyLinkedList
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月10日
*/
public class MyLinkedList {


    public static class ListNode{
        Integer val;
        ListNode next;

        public ListNode(Integer val){
            this.val = val;
            this.next = null;
        }

    }

    private ListNode head;
    private Integer size;


    public MyLinkedList() {
      this.head = new ListNode(0);
      this.size = 0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        ListNode p = head;
        for(int i = 0;i<=index;i++){
            p = p.next;
        }
        return p.val;
    }
    
    public void addAtHead(int val) {
       ListNode node = new ListNode(val);
       node.next = head.next;
       head.next = node;
       this.size++;
    }
    
    public void addAtTail(int val) {
        ListNode p = head;
        while(p.next != null){
            p = p.next;
        }
        ListNode node = new ListNode(val);
        p.next = node;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
       if(index>size){
           return;
       }
       if(index < 0 ){
         this.addAtHead(val);
         return;
       }
       if(index == size){
           this.addAtTail(val);
           return;
       }
       ListNode p = head;
       for(int i = 0;i<index;i++){
           p = p.next;
       }
       ListNode node = new ListNode(val);
       node.next = p.next;
       p.next = node;
       this.size++;
    }

    public void deleteAtIndex(int index){
        if(index<0|| index>= size){
            return;
        }
        ListNode p = head;
        for(int i = 0;i<index;i++){
            p = p.next;
        }
        p.next = p.next.next;
        this.size--;
    }
}
