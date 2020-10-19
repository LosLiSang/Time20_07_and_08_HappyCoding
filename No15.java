public class No15 {
    public static void main(String[] args) {


    }   
}
class Solution6 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        ListNode itr1 = head;
        ListNode itr2 = head;
        while (itr2.next != null)
            itr2 = itr2.next;
        int count = 0;
        while (itr1 != null) {
            if (itr1.next == itr2) {
                itr2 = itr1;
                itr1 = head;
                count++;
                if (count == n) {
                    itr2.next = itr2.next.next;
                    break;
                }
                continue;
            }
            itr1 = itr1.next;
        }
        return head.next;
    }


}

