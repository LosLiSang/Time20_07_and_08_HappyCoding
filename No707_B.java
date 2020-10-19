public class No707_B {
    //双链表
    public static void main(String[] args) {
        MyLinkedList listHead = new MyLinkedList();
        MyLinkedList.DoublyListNode head = listHead.headNode;
        listHead.addAtHead(0);
        listHead.addAtTail(1);
        listHead.addAtTail(2);
        listHead.addAtTail(3);
        listHead.addAtTail(4);
        listHead.addAtTail(5);
        listHead.addAtTail(6);
        listHead.addAtTail(7);
        listHead.addAtTail(8);
        listHead.addAtTail(9);
        listHead.addAtTail(10);
        listHead.addAtIndex(10, 11);
        listHead.addAtIndex(11, 12);
        listHead.deleteAtIndex(5);
        listHead.deleteAtIndex(6);
        listHead.deleteAtIndex(7);
        listHead.deleteAtIndex(8);
        System.out.println(listHead.get(3));
        System.out.println(listHead.get(1));
        System.out.println(listHead.get(0));
        System.out.println(listHead.get(4));
        System.out.println(listHead.get(5));
        head = head.next;
        while(head.next != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}




class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList listHead = new MyLinkedList();
        MyLinkedList.DoublyListNode head = listHead.headNode;
        listHead.addAtHead(38);
        listHead.addAtTail(66);
        listHead.addAtTail(61);
        listHead.addAtTail(76);
        listHead.addAtTail(26);
        listHead.addAtTail(37);
        listHead.addAtTail(8);
        listHead.deleteAtIndex(5);
        listHead.addAtHead(4);
        listHead.addAtHead(45);
        listHead.get(4);
        listHead.addAtTail(85);
        listHead.addAtHead(37);
        listHead.get(5);
        listHead.addAtTail(93);
        listHead.addAtIndex(10, 23);
        listHead.addAtTail(21);
        listHead.addAtHead(52);
        listHead.addAtHead(15);
        listHead.addAtHead(47);
        listHead.get(12);
        listHead.addAtIndex(6, 24);
        listHead.addAtHead(64);
        listHead.get(4);
        listHead.addAtHead(31);
        listHead.deleteAtIndex(6);
        listHead.addAtHead(40);
        listHead.addAtTail(17);
        listHead.addAtTail(15);
        listHead.addAtIndex(19, 2);
        listHead.addAtTail(11);
        listHead.addAtHead(86);
        listHead.get(17);
        listHead.addAtTail(55);
        listHead.deleteAtIndex(15);
        listHead.addAtIndex(14, 95);
        listHead.deleteAtIndex(22);
        listHead.addAtHead(66);
        listHead.addAtTail(95);;
        listHead.addAtHead(8);
        listHead.addAtHead(47);
        listHead.addAtTail(23);
        listHead.addAtTail(39);
        listHead.get(30);
        listHead.get(27);
        listHead.addAtHead(0);
        listHead.addAtTail(99);
        listHead.addAtTail(45);
        listHead.addAtTail(4);
        listHead.addAtIndex(9, 11);
        listHead.get(6);
        listHead.addAtHead(81);
        listHead.addAtIndex(18, 32);
        listHead.addAtHead(20);
        listHead.addAtTail(13);
        listHead.addAtTail(42);
        listHead.addAtIndex(37, 91);
        listHead.deleteAtIndex(36);
        listHead.addAtIndex(10, 37);
        listHead.addAtHead(96);
        listHead.addAtHead(57);
        listHead.deleteAtIndex(20);
        listHead.addAtTail(89);
        listHead.deleteAtIndex(18);
        listHead.addAtIndex(41, 5);
        listHead.addAtTail(23);
        listHead.addAtHead(75);
        listHead.get(7);
        listHead.addAtIndex(25, 51);
        listHead.addAtTail(48);
        listHead.addAtHead(46);
        listHead.addAtHead(29);
        listHead.addAtHead(85);
        listHead.addAtHead(82);
        listHead.addAtHead(6);
        listHead.addAtHead(38);
        listHead.deleteAtIndex(14);
        listHead.get(1);
        listHead.get(12);
        listHead.addAtHead(42);
        listHead.get(42);
        listHead.addAtTail(83);
        listHead.addAtTail(13);
        listHead.addAtIndex(14, 20);
        listHead.addAtIndex(17, 34);
        listHead.addAtHead(36);
        listHead.addAtTail(58);
        listHead.addAtTail(2);
        listHead.get(38);
        listHead.addAtIndex(33, 59);
        listHead.addAtHead(37);
        listHead.deleteAtIndex(15);
        listHead.addAtTail(64);
        listHead.get(56);
        listHead.addAtHead(0);
        listHead.get(40);
        listHead.addAtHead(92);
        listHead.deleteAtIndex(63);
        listHead.get(35);
        listHead.addAtTail(62);
        listHead.addAtTail(32);
        head = head.next;
        while(head.next != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    // Definition for doubly-linked list.
    class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int x) {val = x;}
    }

    /** Initialize your data structure here. */
    DoublyListNode headNode;
    DoublyListNode tailNode;
    int size;

    public MyLinkedList() {
        size = 0;
        headNode = new DoublyListNode(0);
        tailNode = new DoublyListNode(0);
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DoublyListNode itr = headNode;
        int count = -1;
        while(count < size){
            if(count == index)
                return itr.val;
            count++;
            itr = itr.next;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0) index = 0;
        if(index > size) return;
        DoublyListNode toAdd = new DoublyListNode(val);
        DoublyListNode itr = headNode;
        for(int count = -1; count < size; count++, itr = itr.next){
            if(count + 1 == index){
                toAdd.next = itr.next;
                toAdd.prev = itr;
                itr.next.prev = toAdd;
                itr.next = toAdd;
                size++;
                return;
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0) return;
        DoublyListNode itr = headNode;
        for(int count = -1; count < size; count++){
            if(count == index){
                itr.prev.next = itr.next;
                size--;
                return;
            }
            itr = itr.next;
        }
    }
}