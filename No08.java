public class No08 {
    public static void main(String[] args) {
        
    }
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode itr1 = head;
            ListNode itr2 = head;
            while(itr1 != null & itr1.next != null){
                itr1 = itr1.next.next;  
                itr2 = itr2.next;
                if(itr1 == itr2){
                    itr1 = head;
                    while(itr1 != itr2){
                        itr1 = itr1.next;
                        itr2 = itr2.next;
                    }
                    return itr1;
                }
            }
            return null;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
}