

public class No06 {
    public static class MyLinkedList{
        public class Node{
            int val;
            Node next;
            Node(int val) {this.val = val;}
        }
        int size;
        Node head;
        MyLinkedList(){
            size = 0;
            head = new Node(0);
        }
        public int get(int index){
            if(index > size | size < 0) return -1;
            Node itr = head;
            for(int i = 0; i < index + 1; ++i) itr = itr.next;
            return itr.val;
        }
        public void addAtHead(int val){
            addAtIndex(0, val);
        }
        public void addAtTail(int val){
            addAtIndex(size, val);
        }
        public void addAtIndex(int index, int val){
            if(index > size) return;
            if(index < 0) index = 0;
            size++;

            Node itr = head;
            for(int i = 0; i < index; ++i) itr = itr.next;
            Node toAdd = new Node(val);
            toAdd.next = itr.next;
            itr.next = toAdd;
        }
        public void delectAtIndex(int index){
            if(index > size | index < 0) return;
            
            size--;
            Node itr = head;
            for(int i = 0; i < index; ++i) itr = itr.next;
            itr.next = itr.next.next;
        }
    }
    

}