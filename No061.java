public class No061 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution().rotateRight(head, 2);
        System.out.println(1);    
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return head;
            ListNode res = head, tail = head;
            int len = 1;
            while(tail.next != null){
                tail = tail.next;
                len++;
            }
            k = k % len;
            k = (len - k) % len;
            tail.next = head;
            for(; k > 0; k--){
                tail = tail.next;
            }
            res = tail.next;
            tail.next = null;
            return res;
        }
    }

    // Failed 
    static class Solution1 {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return head;
            ListNode res = new ListNode(0), itr = head, tail = head;
            int len = 0; // 链表长度
            while(itr != null){
                tail = itr;
                itr = itr.next;
                len += 1;
            }
            itr = head;
            k = k % len;
            while(k > 0){
                itr = itr.next;
                k--;
            }
            res.next = itr.next;
            tail.next = head;
            itr.next = null;
            return res.next;
        }
    }
}
