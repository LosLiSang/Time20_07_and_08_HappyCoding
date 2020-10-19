public class No20 {
    
}



class Solution10 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        ListNode head = new ListNode();
        ListNode fakeHead = head;
        while(itr1 != null | itr2 != null){
            int lessVal = itr1.val < itr2.val ? itr1.val : itr2.val;
            if(itr1.val < itr2.val) itr1 = itr1.next;
            else itr2 = itr2.next;
            head.next = new ListNode(lessVal);
            head = head.next;
        }
        if(itr1 == null) head.next = itr2;
        if(itr2 == null) head.next = itr1;
        return fakeHead.next;
    }
}