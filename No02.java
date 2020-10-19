

public class No02 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l = new No01().addTwoNumbers(l1, l2);
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        result = result.next;
        int isFull = 0;
        while(l1 !=  null & l2 != null){
            result = new ListNode((l1.val + l2.val + isFull) % 10);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}   