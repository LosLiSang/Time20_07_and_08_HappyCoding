

public class No707_A {
    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        // linkedList.addAtHead(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(1);
        linkedList.addAtHead(1);
        // linkedList.addAtTail(3);
        
        // linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3

        // linkedList.get(1);            //返回2
        // linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        // linkedList.get(1);            //返回3
    
    }
    public static class MyLinkedList {

        /** Initialize your data structure here. */
        class Node{
            int val;
            Node next;
            Node(int val){
                this.val = val;
            }
        }
        
        Node head;
        Node tail;
        int length;
        
        public MyLinkedList() {
        
        }
        
        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index >= 0 & index < length){
                Node tNode = head;
                int i = 0;
                while(tNode != null & i < index){
                    tNode = tNode.next;
                    i++;
                }
                return tNode.val;
            }else{
                return -1;
            }
        }
        
        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if(head == null){
                head = new Node(val);
                tail = head;
                length = 1;
                return;
            }
            Node tNode = new Node(val);
            tNode.next = head;
            head = tNode;
            length += 1;
        }
        
        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if(head == null){
                head = new Node(val);
                tail = head;
                length = 1;
                return;
            }
            Node tNode = new Node(val);
            tail.next = tNode;
            tail = tNode;
            length += 1;
        }
        
        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(head == null){
                head = new Node(val);
                tail = head;
                length = 1;
                return;
            }
            if(index <= 0){
                addAtHead(val);
                return;
            }
            if(index == length){
                addAtTail(val);
                return;
            }
            Node curNode = new Node(val);
            Node preNode = head;
            int i = 0;
            while(i < index - 1){
                preNode = preNode.next;
                i++;
            }
            Node nextNode = preNode.next;
            curNode.next = nextNode;
            preNode.next = curNode;
            length++;
        }
        
        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(head == null){
                return;
            }
            if(index == 0){
                head = head.next;
                length--;
                return;
            }
            int i = 0;
            Node preNode = head;
            while(i < index - 1 & preNode != null){
                preNode = preNode.next;
                i++;
            }
            preNode.next = preNode.next.next; 
            length -= 1;
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