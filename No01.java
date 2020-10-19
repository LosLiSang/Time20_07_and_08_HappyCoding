
//总结：
//  先确定好指向的节点，再迭代

public class No01 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        ListNode l = new No01().addTwoNumbers(l1, l2);
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int size1 = 0;
        int size2 = 0;
        while(t1 != null){
            t1 = t1.next;
            size1 += 1;
        }
        while(t2 != null){
            t2 = t2.next;
            size2 += 1;
        }
        int maxSize = size1 > size2 ? size1 : size2;
        int minSize = size1 < size2 ? size1 : size2;
        ListNode maxList = size1 > size2 ? l1 : l2;
        ListNode result = new ListNode(0);
        ListNode head = result;
        int isFull = 0;
        for(int i = 0; i < maxSize; i++){
            if(i < minSize){
                result.next = new ListNode((l1.val + l2.val + isFull) % 10);
                isFull = (l1.val + l2.val + isFull) / 10;
                l1 = l1.next;
                l2 = l2.next;
                maxList = maxList.next;
                result = result.next;
            }else{
                result.next = new ListNode((maxList.val + isFull) % 10);
                isFull = (maxList.val + isFull) / 10;
                maxList = maxList.next;
                result = result.next;
            }
        }
        if(isFull != 0){
            result.next = new ListNode(isFull);
            result = result.next;
        }
           
        return head.next;
    }
}

