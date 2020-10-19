public class No203 {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);
        new Solution().removeElements(head, 1);
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode fakeHead = new ListNode(0), itr = fakeHead;
            fakeHead.next = head;
            head = fakeHead;
            while(itr != null && itr.next != null){
                if(itr.next.val == val)
                    itr.next = itr.next.next;
                else
                    itr = itr.next;
            }
            return head.next;
        }
    }
}
