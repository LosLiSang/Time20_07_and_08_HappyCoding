public class No12 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode head2 = head1.next;
        
        // ListNode head1 = new ListNode(4);
        // head1.next = new ListNode(1);
        // head1.next.next = new ListNode(8);
        // head1.next.next.next = new ListNode(4);
        // head1.next.next.next.next = new ListNode(5);
        // ListNode head2 = new ListNode(5);
        // head2.next = new ListNode(6);
        // head2.next.next = new ListNode(1);
        // head2.next.next.next = head1.next.next;
        ListNode result = new Solution3().getIntersectionNode(head1, head2);
        System.out.println(result.val);
    }
}
class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = new ListNode(0);
        t1.next = headA;
        ListNode t2 = new ListNode(0);
        t2.next = headB;
        headA = t1;
        headB = t2;
        // if(headA == null | headB == null) return null;
        // if(headA == headB) return headA;
        ListNode tail, itrA = headA, itrB = headB;
        while(itrA.next != null) itrA = itrA.next;
        tail = itrA;
        itrA = headA;
        while(itrA.next != null && itrB.next != null){
            if(itrA.next == tail && itrB.next == tail){
                if(itrA != itrB) return itrA.next;
                tail = itrA;
                itrA = headA;
                itrB = headB;
                continue;
            }
            if(itrA.next != tail) itrA = itrA.next;
            if(itrB.next != tail) itrB = itrB.next;
        }
        return null;
    }
}