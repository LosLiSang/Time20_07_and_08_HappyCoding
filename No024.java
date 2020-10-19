public class No024 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        
    }
    
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode fakeHead = new ListNode(0, head);
            head = fakeHead;
            return head.next;
        }
        private void swap(){
            
        }
    }
}
