public class No37 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class Solution {
        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head = new Solution().reverseList(head); 
            while(head != null){
                System.out.println(head.val);
                head = head.next;
            }
        }
        public ListNode reverseList(ListNode head) {
            ListNode itr = head.next;
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            head = fakeHead;
            ListNode tNode = head.next;
            while(tNode != null){
                tNode.next = head;
                head = tNode;
                tNode = itr;
                if(itr == null) break;
                itr = itr.next;
                if(fakeHead.next != null) fakeHead.next = null;
            }
            itr = head;
            while(itr != null){
                if(itr.next.next == null) {
                    itr.next = null;
                    break;
                }
                itr = itr.next;
            }
            return head;
        }
    }
}