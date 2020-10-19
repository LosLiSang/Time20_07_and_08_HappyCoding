

public class No05 {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(1);
        // linkedList.addAtHead(1);
        // linkedList.addAtHead(1);
        // linkedList.addAtHead(1);
        // linkedList.addAtHead(1);
        // linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3

        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}


class LinkedList {

    /** Initialize your data structure here. */
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    
    Node head = null;
    int length;
    
    public LinkedList() {
     
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length | index < 0){
            return -1;
        }
        Node itr = head;
        int count = 0;
        while(itr != null){
            if(count == index){
                return itr.val;
            }
            itr = itr.next;
            count += 1;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head;
        head = cur;
        length += 1;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);
        if(head == null){
            head = cur;
            length = 1;
            return;
        }
        Node itr = head;
        while(itr != null){
            if(itr.next == null){
                itr.next = cur;
                length += 1;
                return;
            }
            itr = itr.next;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index <= 0){
            addAtHead(val);
            return;
        }
        Node curNode = new Node(val);
        Node itr = head;
        int count = 0;
        while(itr != null){
            if(count + 1 == index){
                Node nextNode = itr.next;
                curNode.next = nextNode;
                itr.next = curNode;
                length++;
                break;
            }
            itr = itr.next;
            count++;
        } 
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int count = 0;
        Node itr = head;
        Node pre = null;
        while(itr != null){
            if(count == index){
                if(pre == null){
                    head = itr.next;
                }else{
                    pre.next = itr.next;
                }
                length -= 1;
                break;
            }
            pre = itr;
            itr = itr.next;
            count++;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */