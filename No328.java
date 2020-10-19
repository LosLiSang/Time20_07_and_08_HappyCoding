public class No328 {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        new Solution().oddEvenList(head);
    }

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode odd = new ListNode(0), even = new ListNode(0);
            ListNode evenHead = even, oddHead = odd;
            int count = 1;
            while(head != null){
                if(count % 2 == 1){
                    odd.next = head;
                    odd = odd.next;
                    head = head.next;
                    odd.next = null;
                }else if(count % 2 == 0){
                    even.next = head;
                    even = even.next;
                    head = head.next;
                    even.next = null;
                }
                count++;
            }
            odd.next = evenHead.next;
            return oddHead.next;
        }
    }
}
