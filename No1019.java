import java.util.Arrays;
import java.util.Stack;

public class No1019{


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next= new ListNode(8);
        System.out.println(Arrays.toString(new Solution().nextLargerNodes(head)));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //单调栈
    static class Solution{
        public int[] nextLargerNodes(ListNode head){
            int len = 0;
            for(ListNode itr = head; itr != null; itr = itr.next)
                len++;
            int[] res = new int[len];
            Stack<Integer> s = new Stack<>();
            Stack<Integer> s_index = new Stack<>();
            ListNode itr = head;
            int i = 0;
            while(itr != null){
                while(!s.empty() && s.peek() < itr.val){
                    res[s_index.pop()] = itr.val;
                    s.pop();
                }
                s.push(itr.val);
                s_index.push(i);
                itr = itr.next;
                i++;
            }
            return res;
        }
    }

    //双指针
    static class Solution1 {
        public int[] nextLargerNodes(ListNode head){
            int len = 0;
            for(ListNode itr = head; itr != null; itr = itr.next)
                len++;
            int[] res = new int[len];
            ListNode itr1 = head, itr2 = head;
            int i = 0;
            while(itr1 != null){
                while(itr2 != null && itr1.val >= itr2.val){ 
                    itr2 = itr2.next;
                }
                if(itr2 == null)
                    res[i] = 0;
                else
                    res[i] = itr2.val;    
                itr2 = itr1.next;
                itr1 = itr1.next;
                i++;
            }
            return res;
        }
    }    
}
