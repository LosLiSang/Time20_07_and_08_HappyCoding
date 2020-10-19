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
            ListNode itr = new ListNode(0, head);
            head = itr;
            while(itr != null && itr.next != null && itr.next.next != null){
                swap(itr, itr.next, itr.next.next);
                itr = itr.next.next;
            }
            return head.next;
        }
        private void swap(ListNode n1f, ListNode n1, ListNode n2f, ListNode n2){
            ListNode n1r = n1.next, n2r = n2.next;
            n1f.next = n2;
            n2f.next = n1;
            n1.next = n2r;
            n2.next = n1r;
        }

        private void swap(ListNode n1f, ListNode n1, ListNode n2){
            ListNode n2r = n2.next;
            n1f.next = n2;
            n1.next = n2r;
            n2.next = n1;
        }
    }
}
