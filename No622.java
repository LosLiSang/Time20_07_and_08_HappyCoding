public class No622 {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        obj.enQueue(1);
        obj.enQueue(1);
        obj.enQueue(1);
        obj.enQueue(1);
        obj.enQueue(1);
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.Front();
        obj.Rear();
        obj.isEmpty();
        obj.isFull();
    }
    static class MyCircularQueue {

        /** Initialize your data structure here. Set the size of the queue to be k. */
        private int[] list;
        private int cap;
        private int head;
        private int tail;
        public MyCircularQueue(int k) {
            this.cap = k;
            list = new int[k + 1];
            this.tail = 0;
            this.head = 0;
        }
        
        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(head == (tail+1)%(cap+1))
                return false;
            else{
                this.list[tail] = value;
                tail = (tail+1)%(cap+1);
                return true;
            }
        }   
        
        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(head == tail) return false;
            else{
                head = (head+1)%(cap+1);
                return true;
            }
        }
        
        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()) return -1;
            return list[head];
        }
        
        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) return -1;
            return list[(tail+cap)%(cap+1)];
        }
        
        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }
        
        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (tail+1)%(cap+1) == head;
        }
    }
    
    

}
