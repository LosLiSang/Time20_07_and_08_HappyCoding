import java.util.List;
import java.util.ArrayList;

//234. 回文链表
//请判断一个链表是否为回文链表。

public class No234 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(new Solution().isPalindrome(head));
    }
    // 时间复杂度O(n) 空间复杂度O(1)
    static class Solution{
        public boolean isPalindrome(ListNode head){
            boolean result = true;
            ListNode midList = cutList(head), itr1 = head;
            midList = reverse(midList);
            ListNode itr2 = midList;
            while(itr2 != null){
                if(itr1.val != itr2.val) result = false;
                itr1 = itr1.next;
                itr2 = itr2.next;
            }
            midList = reverse(midList);
            return result;
        }

        private ListNode reverse(ListNode head){
            ListNode curHead = null, itr = head;
            while(itr != null){
                ListNode t = itr;
                itr = itr.next;
                t.next = curHead;
                curHead = t;
            }
            return curHead;
        }

        private ListNode cutList(ListNode head){
            ListNode itr1 = head, itr2 = head;
            while(itr2 != null && itr2.next != null){
                itr1 = itr1.next;
                itr2 = itr2.next.next;
            }
            if(itr2 == null) return itr1;
            else return itr1.next;
        }
    }
    //时间复杂度O(n) 空间复杂度O(n)
    static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            ListNode itr1  = head, itr2 = head;
            List<Integer> left = new ArrayList<Integer>();
            int size = 0;
            while(itr2 != null && itr2.next != null){
                left.add(itr1.val);
                size += 1;
                itr1 = itr1.next;
                itr2 = itr2.next.next;
            }
            boolean isEven = itr2 == null ? true : false;
            if(!isEven) itr1 = itr1.next;
            while(itr1 != null){
                if(left.get(size-1) != itr1.val) return false;                
                itr1 = itr1.next;
                size--;
            }
            return true;
        }
    }
}