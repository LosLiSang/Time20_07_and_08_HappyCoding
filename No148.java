public class No148 {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    
    static class Solution {
        public static void main(String[] args) {
            ListNode head1 = new ListNode(6);
            head1.next = new ListNode(3);
            head1.next.next = new ListNode(2);
            head1.next.next.next = new ListNode(5);
            head1.next.next.next.next = new ListNode(4);
            ListNode head0 = new Solution().sortList(head1);
            System.out.println(head0.val);
            System.out.println(head0.next.val);
            System.out.println(head0.next.next.val);
            System.out.println(head0.next.next.next.val);
            System.out.println(head0.next.next.next.next.val);
        }
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;
            //分割
            ListNode temp = cut(head);
            // ListNode faster = head.next, lower = head;
            // while(faster != null && faster.next != null){
            //     lower = lower.next;
            //     faster = faster.next.next;
            // }
            // ListNode temp = lower.next;
            // lower.next = null;
            ListNode right = sortList(head), left = sortList(temp);
            //合并
            head = merge(right, left);
            return head;
        }
        
        private ListNode cut(ListNode head){
            ListNode faster = head.next, lower = head;
            while(faster != null && faster.next != null){
                lower = lower.next;
                faster = faster.next.next;
            }
            ListNode temp = lower.next;
            lower.next = null;
            return temp;
        }
        private ListNode merge(ListNode l1, ListNode l2){
            ListNode head = new ListNode(0);
            ListNode itr = head;
            
            while(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    itr.next = l2;
                    l2 = l2.next;
                    itr = itr.next;
                }else{
                    itr.next = l1;
                    l1 = l1.next;
                    itr = itr.next;
                }
            }
            itr.next = l1 == null ? l2 : l1;
            return head.next;
        }  
    }


}